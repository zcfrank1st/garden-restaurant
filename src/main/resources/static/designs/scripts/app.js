'use strict';

// Declare app level module which depends on views, and components
angular.module('SGarden', [
    'ngRoute',
    'ngResource',
    'ui.router',
    'ngAnimate',
    'ui.bootstrap',
    'SGarden.homepg',
    'SGarden.menu',
    'SGarden.menu.items',
    'SGarden.menu.service'

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
                    templateUrl: "apps/components/homepg.html",
                    controller: "homepgCtrl"
                });
            
            
}])

.controller("globalCtrl", ['$scope', function($scope){
    $scope.navToggle = false;
    $scope.showMenu = function(){
         $scope.navToggle = !$scope.navToggle;
    };   
}]);