'use strict';

// Declare app level module which depends on views, and components
var SGarden = angular.module('SGarden', [
    'ngRoute',
    'ngResource',
    'ui.router',
    'ngAnimate',
    'ui.bootstrap',
    'SGarden.homepg',
    'SGarden.menu',
    'SGarden.menu.items',
    'SGarden.menu.service',
    'SGarden.reserv',
    'SGarden.reserv.service',
    'SGarden.rewards',
    'SGarden.story', 
    'SGarden.story.service',
    'SGarden.contact'

]);

SGarden.run(
  [          '$rootScope', '$state', '$stateParams',
    function ($rootScope,   $state,   $stateParams) {

    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    }
  ]
);

SGarden.config([       '$stateProvider', '$locationProvider', '$urlRouterProvider',
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
            
            
}]);

SGarden.controller("globalCtrl", ['$scope', function($scope){
    $scope.navToggle = false;
    $scope.showMenu = function(){
         $scope.navToggle = !$scope.navToggle;
    };   
}]);