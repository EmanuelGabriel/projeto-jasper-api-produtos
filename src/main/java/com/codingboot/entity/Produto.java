package com.codingboot.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 
 * @author emanuel.sousa
 *
 */
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private BigDecimal preco;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, BigDecimal preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}

}
