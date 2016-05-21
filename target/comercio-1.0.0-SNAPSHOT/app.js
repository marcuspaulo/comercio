'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'produto'
]).
config(['$routeProvider', function($routeProvider) {
//  $routeProvider.otherwise({redirectTo: '/produto'});
}]);