'use strict';

angular.module('SGarden.menu', [
    'ngRoute',
    'ngResource',
    'ui.router'
])

.config([    '$stateProvider', '$urlRouterProvider',
    function ($stateProvider,   $urlRouterProvider){

            $stateProvider
                .state("menu", {
                    abstract: true,
                    url:"/menu",
                    templateUrl: "apps/components/menu.html",
                    resolve: {
                            menuService: ['menuService',
                              function( menuService){

                                return menuService.menuList();                          
                          }]
                      },
                    controller: ['$scope', '$state', 'menuService',
                        function($scope, $state, menuService){
 
                        $scope.ajMenuCategory = menuService.data;

                        $state.go('menu.list');
                    }]
                })
                .state("menu.list", {
                
                    url:"",
                    views: {
                        "menuList": {
                            templateUrl: "apps/components/menuList.html"
                        }
                    }
                    
                });
                       
}]);