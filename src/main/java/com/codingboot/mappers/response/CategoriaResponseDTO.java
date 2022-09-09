package com.codingboot.mappers.response;

import java.io.Serializable;

/**
 * 
 * @author emanuel.sousa
 *
 *
 */
public final class CategoriaResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String categoria;
	private String descricao;

	public CategoriaResponseDTO() {
		super();
	}

	public CategoriaResponseDTO(String categoria, String descricao) {
		super();
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "CategoriaResponseDTO [categoria=" + categoria + ", descricao=" + descricao + "]";
	}

}
