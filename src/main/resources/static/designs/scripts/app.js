'use strict';

// Declare app level module which depends on views, and components
angular.module('SGarden', [
    'ui.router',
    'ngAnimate',
    'ui.bootstrap',
    'SGarden.homepg'
])

.run(
  [          '$rootScope', '$state', '$stateParams',
    function ($rootScope,   $state,   $stateParams) {

    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    }
  ]
)

.config([       '$stateProvider', '$locationProvider', '$urlRouterProvider', 
        function($stateProvider,   $locationProvider,   $urlRouterProvider) {
            $locationProvider.html5Mode(true);

            $urlRouterProvider
                .otherwise('/');

            $stateProvider
                .state("home", {
                    url:"/",
                    templateUrl: "apps/components/home.html",
                    controller: "homeCtrl"
                })
                .state("menu", {
                    url:"/menu",
                    templateUrl: "apps/components/menu.html",
                    controller: "menuCtrl"
                });
}])

.controller("homepageCtrl", ['$scope', function($scope){
    $scope.isCollapsed = false;
    
}]);