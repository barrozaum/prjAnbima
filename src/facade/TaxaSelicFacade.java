package facade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.TaxaSelic;
import file.LerDadosJson;
import util.Utils;
import vo.MediaTaxaAnual;
import vo.TaxaSelicVo;

public class TaxaSelicFacade implements ITaxaSelicServiceFacade {

	private LerDadosJson ldj = new LerDadosJson();

	@Override
	public List<MediaTaxaAnual> calculoTaxaSelicAnualMedia(String ano) {
		    return calculaMediaTaxaAnual(ano , ldj.listarDadosJson());
	}

	private List<MediaTaxaAnual>  calculaMediaTaxaAnual(String ano, List<TaxaSelic> listarDadosJson) {
		List<MediaTaxaAnual> lista = new ArrayList<MediaTaxaAnual>();
		
		Map<Integer, String> anosEncontrados = new HashMap<Integer, String>();
		if(ano != null) {
			anosEncontrados.put(new Integer(ano), ano);
		}else {
			carregandoAnosMapa(anosEncontrados, listarDadosJson);
		}
		
		List<Integer> ListaAnos = new ArrayList<Integer>(anosEncontrados.keySet());
		
		Collections.sort(ListaAnos);
		
		for (Integer anoBase : ListaAnos) {
			Integer qtd = 0;
			double valor = 0;
			for (TaxaSelic taxa : listarDadosJson) {
				if(Utils.pegarAno(taxa.getData_referencia()).equals(anoBase.toString())) {
					valor = valor + taxa.getEstimativa_taxa_selic();
					qtd++;
				}
			}
			if(valor > 0 && qtd > 0) {
				lista.add(new MediaTaxaAnual(anoBase.toString(), Utils.converterValor(valor / qtd)));
			}
		}
		return lista;
	}

	
	private void carregandoAnosMapa(Map<Integer,String> anosEncontrados, List<TaxaSelic> listarDadosJson) {
		for (TaxaSelic taxaSelic : listarDadosJson) {
			if(anosEncontrados.get((new Integer(Utils.pegarAno(taxaSelic.getData_referencia())))) == null) {
				anosEncontrados.put((new Integer(Utils.pegarAno(taxaSelic.getData_referencia()))), Utils.pegarAno(taxaSelic.getData_referencia()));
			}
		}
	}

	@Override
	public List<TaxaSelicVo> consultaPeriodoTaxa(String ano, String mes) {
		return new TaxaSelicVo().converterTaxaSelicParaVo(buscarTaxaMesAno(mes, ano, ldj.listarDadosJson()));
	}

	@Override
	public List<TaxaSelicVo> historico() {
		return new TaxaSelicVo().converterTaxaSelicParaVo(ldj.listarDadosJson());
	}

	private List<TaxaSelic> buscarTaxaMesAno(String mes, String ano, List<TaxaSelic> lista) {

		List<TaxaSelic> taxas = new ArrayList<>();
		for (TaxaSelic taxaSelic : lista) {

			String txmes = Utils.pegarMes(taxaSelic.getData_referencia());
			String txano = Utils.pegarAno(taxaSelic.getData_referencia());

			if (mes != null && ano != null) {
				if (txmes.equalsIgnoreCase(mes.toString()) && txano.equalsIgnoreCase(ano.toString())) {
					taxas.add(taxaSelic);
				}
			} else if (mes == null && ano != null) {
				if (txano.equalsIgnoreCase(ano.toString())) {
					taxas.add(taxaSelic);
				}
			}
		}
		return taxas;
	}

	@Override
	public List<MediaTaxaAnual> calculoTaxaSelicAnual() {
		// TODO Auto-generated method stub
		 return calculaTaxaAnual(ldj.listarDadosJson());
	}

	private List<MediaTaxaAnual> calculaTaxaAnual(List<TaxaSelic> listarDadosJson) {
		List<MediaTaxaAnual> lista = new ArrayList<MediaTaxaAnual>();
		
		Map<Integer, String> anosEncontrados = new HashMap<Integer, String>();
			carregandoAnosMapa(anosEncontrados, listarDadosJson);
		
		List<Integer> ListaAnos = new ArrayList<Integer>(anosEncontrados.keySet());
		
		Collections.sort(ListaAnos);
		
		for (Integer anoBase : ListaAnos) {
			Integer qtd = 0;
			double valor = 0;
			for (TaxaSelic taxa : listarDadosJson) {
				if(Utils.pegarAno(taxa.getData_referencia()).equals(anoBase.toString())) {
					valor = valor + taxa.getEstimativa_taxa_selic();
					qtd++;
				}
			}
			if(valor > 0 && qtd > 0) {
				lista.add(new MediaTaxaAnual(anoBase.toString(), Utils.converterValor(valor)));
			}
		}
		return lista;
	}


	
	
}
