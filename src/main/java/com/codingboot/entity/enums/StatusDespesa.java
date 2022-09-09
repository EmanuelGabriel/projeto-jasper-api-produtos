package com.codingboot.entity.enums;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.codingboot.mappers.response.StatusDespesaResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public enum StatusDespesa {

	PENDENTE("Pendente", 1), 
	PAGO("Pago", 2);

	private final String descricao;
	private final int ordem;

	StatusDespesa(String descricao, int ordem) {
		this.descricao = descricao;
		this.ordem = ordem;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getOrdem() {
		return ordem;
	}

	@JsonIgnore
	public static List<StatusDespesaResponseDTO> getStatusTOSortedByOrdem() {
		return Stream.of(StatusDespesa.values()).sorted(Comparator.comparing(StatusDespesa::getOrdem))
				.map(s -> new StatusDespesaResponseDTO(s.name(), s.getDescricao())).collect(Collectors.toList());
	}

}
