package br.com.makersweb.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException {

	private static final long serialVersionUID = -4225641675585102567L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
