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

                        $state.go('menu.detail', { menuCategory: "main" });
                    }]
                    

                });
                       
}]);