(function() {
	'use strict';

	var app = angular.module('produto', ['ngRoute']);

	app.controller('ProdutoCtrl', function($scope, $http) {
	    
		$scope.mensagem = "";
		//Função responsável por carregar a lista de produto
	    $scope.listarProdutos = function() {
	    	$http.get("./resources/produtos")
	    		.success(function(response) {
	            $scope.produtos = response;
	        });
	    };
	    
	    $scope.cadastrarProdutos = function(produto) {
		    	$http.post("./resources/produtos", produto)
		    	.success(function(response) {
		    		$scope.mensagem = "Produto Cadastrado com sucesso!!!";
		    	});
	    };
	    
	    $scope.listarProdutos();
	    
	    
	});
})();

