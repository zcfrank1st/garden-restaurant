'use strict';

angular.module('SGarden.story.service', [

])

// A RESTful factory for retrieving contacts from 'contacts.json'
.factory('storyService', ['$http', function ($http) {
    return {
        storyList: function (){
            var path = 'designs/scripts/services/story.json';
            return $http.get(path).success(function (resp) {
                return resp;
            });
        }
   }
    
}]);