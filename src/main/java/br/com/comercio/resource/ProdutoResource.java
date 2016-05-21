package br.com.comercio.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.comercio.produto.entidade.Produto;
import br.com.comercio.produto.service.ProdutoService;
import br.com.comercio.util.exception.ProdutoExistenteException;
import br.com.comercio.util.exception.ProdutoNaoEncontradoException;

@RestController
@RequestMapping("/resources/produtos")
public class ProdutoResource {
	
	@Autowired(required = true)
	private ProdutoService service;
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> listar() {
		return service.listar();
	}
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvarProduto(@RequestBody Produto produto) {
		try {
			produto = service.salvar(produto);
			String uri = "http://localhost:8080/produtos/" + produto.getId();
			return ResponseEntity.created(URI.create(uri)).build();
		} catch (ProdutoExistenteException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarProduto(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(service.buscar(id));
		} catch (ProdutoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
