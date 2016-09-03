'use strict';

angular.module('SGarden.homepg', [
    'ngRoute', 
    'ui.bootstrap'
])

.config([    '$stateProvider', '$urlRouterProvider',
    function ($stateProvider,   $urlRouterProvider){

            $stateProvider
                .state("homepg", {
                    url:"/",
                    templateUrl: "apps/components/homepg.html",
                    resolve: {
                            homepgService: ['homepgService',
                              function( homepgService){

                                return homepgService.homepg();                          
                          }]
                      },
                    controller: ['$scope', '$state', 'homepgService',
                        function($scope, $state, homepgService){
 
                        $scope.ajHomepg = homepgService.data.homepg;
                    }]
                });
                       
}]);
