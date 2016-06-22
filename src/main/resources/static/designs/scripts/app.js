'use strict';

// Declare app level module which depends on views, and components
var SGardent = angular.module('SGarden', [
  'ui.router',
  'SGarden.nav'
])

.config(['$stateProvider', '$locationProvider'], function($stateProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $stateProvider.state("home", {
        url:"/",
        templateUrl: "../../apps/components/global-nav.html",
        controller: "globalNavCtrl"
    });
}]);