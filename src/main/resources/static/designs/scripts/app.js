'use strict';

// Declare app level module which depends on views, and components
var SGardent = angular.module('SGarden', [
  'ui.router',
  'SGarden.nav'
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
                .state("menu", {
                    url:"/menu",
                    templateUrl: "../../apps/components/menu.html",
                    controller: "menuCtrl"
                });
}]);