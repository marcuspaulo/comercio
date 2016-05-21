package br.com.comercio.util.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 4122671841598991683L;

	public ProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ProdutoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
