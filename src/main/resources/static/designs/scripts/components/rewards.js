'use strict';

angular.module('SGarden.rewards', [
    'ngRoute'
])

.config([    '$stateProvider', '$urlRouterProvider',
    function ($stateProvider,   $urlRouterProvider){

            $stateProvider
                .state("rewards", {
                    url:"/rewards",
                    templateUrl: "apps/components/rewards.html",
//                    resolve: {
//                            reservService: ['reservService',
//                              function( reservService){
//
//                                return reservService.reservation();                          
//                          }]
//                      },
                    controller: ['$scope', '$state',
                        function($scope, $state){
 
                        
                    }]
                })
                .state("rewards.login", {
                        url:"/login",
                        views: {
                            "rewardsLogin": {
                                templateUrl: "apps/components/rewardsLogin.html",
                                controller: ['$scope', '$http',
                                    function($scope, $http){
                                        //$scope.loginForm = {};
                                        $scope.errorMessage = false;
                                        $scope.successMessage = false;
                                        
                                        $scope.submitForm = function(isValid) {
                                            // check to make sure the form is completely valid
                                            if (isValid) {
                                                $http({
                                                    method  : 'POST',
                                                    url     : window.location.origin + '/login',
                                                    data    : $scope.loginForm,  // pass in data as strings
                                                    headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
                                                 })
                                                .success(function(data) {
                                                    console.log(data);

                                                    if (!data.success) {
                                                    // if not successful, bind errors to error variables
                                                        $scope.errorMessage = true;

                                                    } else {
                                                    // if successful, bind success message to message
                                                        $scope.successMessage = true;
                                                        $scope.message = $scope.loginForm;
                                                    }
                                                });
                                            }
                                        };
                                }]
                            }                          
                        }
                    });
                       
}]);