package com.codingboot.mappers.response;

import java.io.Serializable;

/**
 * 
 * @author emanuel.sousa
 *
 */
public final class StatusDespesaResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	private String descricao;

	public StatusDespesaResponseDTO() {
		super();
	}

	public StatusDespesaResponseDTO(String status, String descricao) {
		super();
		this.status = status;
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
