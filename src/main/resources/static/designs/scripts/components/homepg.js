'use strict';

angular.module('SGarden.homepg', [
    'ngRoute', 
    'ui.bootstrap'
])

.config(['$provide', function($provide){
    $provide.decorator('uibCarouselDirective', function($delegate) {
    $delegate[0].templateUrl = 'apps/templates/carousel.html';
    return $delegate;
  });
}])

.controller('homepgCtrl', ['$scope', function($scope){
    $scope.homepgInterval = 5000;
    $scope.noWrapSlides = false;
    $scope.active = 0;
    var slides = $scope.slides = [];
    var currIndex = 0;

    $scope.addSlide = function() {
        // get images from the server

        slides.push({
          image: "images/Find Us.png",
          id: currIndex++
        });
    };


    for (var i = 0; i < 2; i++) {
        slides.push({
          image: "images/Find Us.png",
          id: currIndex++
        });
    }
}]);