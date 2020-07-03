package vo;

import java.util.ArrayList;
import java.util.List;

import entity.TaxaSelic;
import util.Utils;

public class TaxaSelicVo {

	private String data_referencia;

	private String estimativa_taxa_selic;

	public TaxaSelicVo() {

	}

	public TaxaSelicVo(TaxaSelic t) {
		this.estimativa_taxa_selic =  Utils.converterValor(t.getEstimativa_taxa_selic());
		this.data_referencia = Utils.converterDateParaString(t.getData_referencia());
	}

	public String getData_referencia() {
		return data_referencia;
	}

	public void setData_referencia(String data_referencia) {
		this.data_referencia = data_referencia;
	}

	public String getEstimativa_taxa_selic() {
		return  estimativa_taxa_selic;
	}

	public void setEstimativa_taxa_selic(String estimativa_taxa_selic) {
		this.estimativa_taxa_selic = estimativa_taxa_selic;
	}

	public TaxaSelicVo converterTaxaSelicParaVo(TaxaSelic t) {

		TaxaSelicVo vo = new TaxaSelicVo(t);

		return vo;
	}

	public List<TaxaSelicVo> converterTaxaSelicParaVo(List<TaxaSelic> listarDadosJson) {
		List<TaxaSelicVo> lista = new ArrayList<TaxaSelicVo>();
		for (TaxaSelic taxaSelic : listarDadosJson) {
			TaxaSelicVo vo = new TaxaSelicVo(taxaSelic);
			lista.add(vo);
		}
		return lista;
	}

}
