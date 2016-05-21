package br.com.comercio.produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comercio.produto.entidade.Produto;
import br.com.comercio.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired(required=true)
	private ProdutoRepository produtoRepository;

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	public Produto buscar(Long id) {
		Produto produto = produtoRepository.findOne(id);
		
		if(produto == null) {
			//throw new ProdutoNaoEncontradoException("Produto não encontrado.");
		}
		
		return produto;
	}
	
	public Produto salvar(Produto produto) {
		verificarExistencia(produto);
		produto.setId(null);
		return produtoRepository.save(produto);
	}
	
	private void verificarExistencia(Produto produto) {
		if(produto.getId() != null && produtoRepository.findOne(produto.getId()) != null) {
//			throw new ProdutoExistenteException("Produto já cadastrado.");
			System.out.println("Produto já cadastrado!!!");
		}
	}

}