package com.codingboot.exception;

public class ProdutoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ProdutoNaoEncontrado(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
