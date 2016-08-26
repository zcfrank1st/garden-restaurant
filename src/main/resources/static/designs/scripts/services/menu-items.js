'use strict';

angular.module('SGarden.menu.items', [
    'ngRoute',
    'ngResource',
    'ui.router'
])

.config([    '$stateProvider', '$urlRouterProvider',
    function ($stateProvider,   $urlRouterProvider){

            $stateProvider
                .state("menu.items", {
                    url:"/{menuCategory}",            
                    views: {
                        'menuItems' : {
                            templateUrl: "apps/components/menuItems.html",
                                                
                            resolve: {
                                menuService: ['menuService',
                                  function( menuService){

                                    return menuService.menuList();                          
                                }]
                            },
                            controller: ['$scope', '$state', '$stateParams', 'menuService',
                                function($scope, $state, $stateParams, menuService){
                                    
                                    $scope.ajMenuItems = menuService.data[$stateParams.menuCategory];


                            }]
                            
                          }
                    }

                });
            
            
}]);
