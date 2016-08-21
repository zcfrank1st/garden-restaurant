'use strict';

angular.module('SGarden.menu.service', [

])

// A RESTful factory for retrieving contacts from 'contacts.json'
.factory('menuService', ['$http', function ($http) {
    return {
        menuList: function (){
            var path = 'designs/scripts/services/menu.json';
            return $http.get(path).success(function (resp) {
                return resp;
            });
        }
   }
    
}]);