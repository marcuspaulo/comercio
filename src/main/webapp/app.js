'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [ 'ngRoute', 'produto' ])

.config(function($locationProvider, $routeProvider) {
//	$locationProvider.html5Mode(true);
	$routeProvider.when('/administrativo/produto', {
		templateUrl : 'administrativo/produtos/produto.html',
		controller : 'ProdutoCtrl'
			
	}).when('/administrativo/cadastroProduto', {
		templateUrl : 'administrativo/produtos/cadastroProduto.html',
		controller : 'ProdutoCtrl'
	}).otherwise({
		redirectTo : '/administrativo/produto'
	});
	
});