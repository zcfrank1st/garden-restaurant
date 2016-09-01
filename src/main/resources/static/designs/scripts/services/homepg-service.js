'use strict';

angular.module('SGarden.homepg.service', [

])

// A RESTful factory for retrieving contacts from 'contacts.json'
.factory('homepgService', ['$http', function ($http) {
    return {
        homepg: function (){
            var path = 'designs/scripts/services/homepg.json';
            return $http.get(path).success(function (resp) {
                return resp;
            });
        }
   }
    
}]);