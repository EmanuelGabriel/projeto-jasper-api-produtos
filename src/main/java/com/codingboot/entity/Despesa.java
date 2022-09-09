package com.codingboot.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.codingboot.entity.enums.Categoria;
import com.codingboot.exception.RegraNegocioException;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author emanuel.sousa
 *
 */

public class Despesa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private LocalDate data;

	private BigDecimal valor;

	private String descricao;

	private Categoria categoria;

	private boolean paga = false;

	/**
	 * 
	 */
	public void validarValor() {
		if (valor == null || valor.compareTo(BigDecimal.ZERO) == 0) {
			throw new RegraNegocioException("Valor da despesa deve ser maior que zero");
		}
	}

	public void pagar() {
		if (paga) {
			throw new RegraNegocioException("A despesa já está paga");
		}
		this.paga = true;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	public LocalDate getDataFormatada() {
		return data;
	}

	public String getDescricaCategoria() {
		return categoria.getDescricao();
	}

	public Despesa() {
		super();
	}

	public Despesa(Long id, LocalDate data, BigDecimal valor, String descricao, Categoria categoria, boolean paga) {
		super();
		this.id = id;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
		this.categoria = categoria;
		this.paga = paga;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
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
		Despesa other = (Despesa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Despesa [id=" + id + ", data=" + data + ", valor=" + valor + ", descricao=" + descricao + ", categoria="
				+ categoria + ", paga=" + paga + "]";
	}

}
