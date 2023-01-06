package com.codingboot.mappers.response;

/**
 * 
 * @author emanuel.sousa
 *
 */

public class RelatorioResponseDTO {

	private String base64;
	private String nomeDoRelatorio;
	private String tamanhoDoArquivo;

	public RelatorioResponseDTO() {
	}

	public RelatorioResponseDTO(String base64, String nomeDoRelatorio, String tamanhoDoArquivo) {
		this.base64 = base64;
		this.nomeDoRelatorio = nomeDoRelatorio;
		this.tamanhoDoArquivo = tamanhoDoArquivo;
	}

	public String getBase64() {
		return base64;
	}

	public String getNomeDoRelatorio() {
		return nomeDoRelatorio;
	}

	public String getTamanhoDoArquivo() {
		return tamanhoDoArquivo;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public void setNomeDoRelatorio(String nomeDoRelatorio) {
		this.nomeDoRelatorio = nomeDoRelatorio;
	}

	public void setTamanhoDoArquivo(String tamanhoDoArquivo) {
		this.tamanhoDoArquivo = tamanhoDoArquivo;
	}

	@Override
	public String toString() {
		return "RelatorioResponseDTO [base64=" + base64 + ", nomeDoRelatorio=" + nomeDoRelatorio + ", tamanhoDoArquivo="
				+ tamanhoDoArquivo + "]";
	}

}
