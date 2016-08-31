'use strict';

angular.module('SGarden.story', [
    'ngRoute'
])

.config([    '$stateProvider', '$urlRouterProvider',
    function ($stateProvider,   $urlRouterProvider){

            $stateProvider
                .state("story", {
                    abstract: true,
                    url:"/story",
                    templateUrl: "apps/components/story.html",
                    resolve: {
                            storyService: ['storyService',
                              function( storyService){

                                return storyService.storyList();                          
                          }]
                      },
                    controller: ['$scope', '$state', 'storyService',
                        function($scope, $state, storyService){
 
                        $scope.ajStory = storyService.data;
                    }]
                })
                .state("story.items", {
                    url:"/{storyItems}",            
                    views: {
                        'storyItems' : {
                            templateUrl: "apps/components/storyItems.html",
                                                
                            resolve: {
                                storyService: ['storyService',
                                  function( storyService){

                                    return storyService.storyList();                          
                                }]
                            },
                            controller: ['$scope', '$state', '$stateParams', 'storyService',
                                function($scope, $state, $stateParams, storyService){
                                    
                                    $scope.ajStoryItem = storyService.data[$stateParams.storyItems];


                            }]      
                        }
                    }
                });
                       
}]);