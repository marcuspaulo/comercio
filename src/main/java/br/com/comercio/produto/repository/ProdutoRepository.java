package br.com.comercio.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comercio.produto.entidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
