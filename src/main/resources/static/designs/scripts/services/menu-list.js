'use strict';

angular.module('SGarden.menu.list', [
    'ngRoute',
    'ngResource',
    'ui.router'
])

.config([    '$stateProvider', '$urlRouterProvider',
    function ($stateProvider,   $urlRouterProvider){

            $stateProvider
                .state("menu.detail", {
                    url:"/{menuCategory}",            
                    views: {
                        'menuCategList' : {
                            templateUrl: "apps/components/menuItems.html",
                                                
                            resolve: {
                                menuService: ['menuService',
                                  function( menuService){

                                    return menuService.menuList();                          
                                }]
                            }，
                            controller: ['$scope', '$state', 'menuService',
                                function($scope, $state, menuService){

                                $scope.ajMenuItems = menuService.data;


                            }]
                            
                          }
                    }，

                })
            
            ;
            
            
}])；
