package com.codingboot.controller.v2;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingboot.entity.Produto;
import com.codingboot.mappers.response.RelatorioResponseDTO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author emanuel.sousa
 *
 */

@RestController(value = "DespesaFaturaControllerV2")
@RequestMapping(value = "/v2/pdf", produces = MediaType.APPLICATION_JSON_VALUE)
public class DespesaFaturaController {

	private static final Logger LOG = LoggerFactory.getLogger(DespesaFaturaController.class);
	
	private static final String PATH_RELATORIO_DESPESAS_JASPER = "/relatorios/jasper/invoice.jasper";
	
	@GetMapping
	public ResponseEntity<RelatorioResponseDTO> downloadDespesas() throws JRException, IOException {

		BigDecimal somaProdutos = somarTotalValorProdutos(buscarProdutos());
		LOG.info("{}", somaProdutos);

		Map<String, Object> parametros = new HashMap<>();
		parametros.put("tituloRelatorio", "Relatório de Despesas");
		parametros.put("total", somaProdutos.toString());

		byte[] dados = compilarRelatorioViaJasper(PATH_RELATORIO_DESPESAS_JASPER, parametros, buscarProdutos());

		System.err.println(Arrays.asList(dados));

		HttpHeaders headers = new HttpHeaders();
		// Define que o arquivo pode ser visualizado no navegador e também nome final do arquivo
	    // para fazer download do relatório troque 'inline' por 'attachment'
		headers.add("Content-Disposition", "inline; filename=RelatorioDespesas.pdf");
		
		RelatorioResponseDTO relatorio = new RelatorioResponseDTO(Base64.getEncoder().encodeToString(dados),
						"Relatório de Fatura de Despesas" + ".pdf", String.valueOf(dados.length));

		return relatorio != null ? ResponseEntity.ok().body(relatorio) : ResponseEntity.notFound().build();
	}

	/**
	 * Lista de Produtos
	 * @return List<Product>
	 */
	private List<Produto> buscarProdutos() {
		return Arrays.asList(
				new Produto(10, "Notebook ACER", BigDecimal.valueOf(120)),
				new Produto(11, "Mouse Microsoft", BigDecimal.valueOf(100)),
				new Produto(12, "Smartphone Motorola", BigDecimal.valueOf(150)), 
				new Produto(13, "Geladeira Brastemp", BigDecimal.valueOf(1500)));
	}

	/**
	 * A soma total dos preços de todos os produtos
	 * @param produtos
	 * @return BigDecimal
	 */
	private BigDecimal somarTotalValorProdutos(List<Produto> produtos) {

		BigDecimal somaPrecoProduto = BigDecimal.ZERO;
		for (Produto prod : produtos) {
			somaPrecoProduto = somaPrecoProduto.add(prod.getPreco());
		}

		return somaPrecoProduto;
	}
	
	/**
	 * 
	 * @param relatorio
	 * @param parametros
	 * @param registrosRelatorioJasper
	 * @return
	 * @throws JRException
	 */
	private byte[] compilarRelatorioViaJasper(String relatorio, Map<String, Object> parametros, List<Produto> relatorioProdutos) throws JRException {
		
		InputStream input = getClass().getResourceAsStream(relatorio);

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(relatorioProdutos);
		JasperPrint print = JasperFillManager.fillReport(input, parametros, beanColDataSource);

		return JasperExportManager.exportReportToPdf(print);
	}
	
}
