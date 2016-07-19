'use strict';

angular.module('SGarden.homepg', [
    'ngRoute', 
    'ui.bootstrap'
])

.controller('homeCtrl', ['$scope', function($scope){
    $scope.homepgInterval = 5000;
    $scope.noWrapSlides = false;
    $scope.active = 0;
    var slides = $scope.slides = [];
    var currIndex = 0;

    $scope.addSlide = function() {
        // get images from the server

        slides.push({
          image: '',
          id: currIndex++
        });
    };


    for (var i = 0; i < 4; i++) {
        $scope.addSlide();
    }
}]);