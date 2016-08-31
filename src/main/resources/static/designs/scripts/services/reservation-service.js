'use strict';

angular.module('SGarden.reserv.service', [

])

// A RESTful factory for retrieving contacts from 'contacts.json'
.factory('reservService', ['$http', function ($http) {
    return {
        reservation: function (){
            var path = 'designs/scripts/services/reserv.json';
            return $http.get(path).success(function (resp) {
                return resp;
            });
        }
   }
    
}]);