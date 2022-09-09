package com.codingboot.exception;

public class RegraNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public RegraNegocioException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
