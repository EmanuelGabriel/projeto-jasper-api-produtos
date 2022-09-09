package com.codingboot.entity.enums;

import java.util.Comparator;
import java.util.stream.Stream;

import com.codingboot.mappers.response.CategoriaResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @return
 */

public enum Categoria {

	ALIMENTACAO("Alimentação"), 
	EDUCACAO("Educação"), 
	SAUDE("Saúde"), 
	TRANSPORTE("Transporte"), 
	MORARIA("Moradia"),
	OUTROS("Outros"),;

	private final String descricao;

	Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@JsonIgnore
    public static Stream<CategoriaResponseDTO> getCategoriasTOSortedByDescricao() {
        return Stream.of(Categoria.values())
                .map(c -> new CategoriaResponseDTO(c.name(), c.getDescricao()))
                .sorted(Comparator.comparing(CategoriaResponseDTO::getDescricao));
       
	}
}
