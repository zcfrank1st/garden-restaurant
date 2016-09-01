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
 
                        $scope.ajHomepg = [
        {
            "homepgTitle":"Monthly Special",
            "homepgSubtitle": "August 2016" ,
            "homepgLink": "/images/roastduck.png"
        },
        {
            "homepgTitle":"How far you can go?",
            "homepgSubtitle": "Your adventure begins here" ,
            "homepgLink": "/images/roastduck.png"
        },
        {
            "homepgTitle":"Monthly Special",
            "homepgSubtitle": "August 2016" ,
            "homepgLink": "/images/roastduck.png"
        }
    ];
                    }]
                });
                       
}]);
