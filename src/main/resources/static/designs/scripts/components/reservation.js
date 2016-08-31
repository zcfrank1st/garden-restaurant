'use strict';

angular.module('SGarden.reserv', [
    'ngRoute'
])

.config([    '$stateProvider', '$urlRouterProvider',
    function ($stateProvider,   $urlRouterProvider){

            $stateProvider
                .state("reservations", {
                    url:"/reservations",
                    templateUrl: "apps/components/reservation.html",
                    resolve: {
                            reservService: ['reservService',
                              function( reservService){

                                return reservService.reservation();                          
                          }]
                      },
                    controller: ['$scope', '$state', 'reservService',
                        function($scope, $state, reservService){
 
                        $scope.ajReserv = reservService.data.reservation;
                    }]
                });
                       
}]);