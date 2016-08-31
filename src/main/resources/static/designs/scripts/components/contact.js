'use strict';

angular.module('SGarden.contact', [
    'ngRoute'
])

.config([    '$stateProvider', '$urlRouterProvider',
    function ($stateProvider,   $urlRouterProvider){

            $stateProvider
                .state("contact", {
                    url:"/contact",
                    templateUrl: "apps/components/contact.html",
                    controller: ['$scope', '$state', 
                        function($scope, $state ){
 
                       
                    }]
                });
                       
}]);