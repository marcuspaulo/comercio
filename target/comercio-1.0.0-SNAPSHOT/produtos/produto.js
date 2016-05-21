(function() {
	'use strict';

	var app = angular.module('produto', ['ngRoute']);

	app.config(function($routeProvider) {
		$routeProvider.when('/produto', {
		    templateUrl: 'produtos/produto.html',
		    controller: 'ProdutoCtrl'
		});
		
		$routeProvider.otherwise({redirectTo: '/produto'});
	});

	app.controller('ProdutoCtrl', function($scope) {
		$scope.produto = "Teste Angular";
		$scope.text="Goodday";
		
	    $scope.adicionar = function() {
	    	alert(1);
	    }
	   
	});
})();

