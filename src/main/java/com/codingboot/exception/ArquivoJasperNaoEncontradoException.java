package com.codingboot.exception;

public class ArquivoJasperNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArquivoJasperNaoEncontradoException() {
	}

	public ArquivoJasperNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
