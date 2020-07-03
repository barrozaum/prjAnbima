package entity;

import java.util.Date;

import util.Utils;

public class TaxaSelic {

	private Date data_referencia;

	private Double estimativa_taxa_selic;

	public TaxaSelic() {

	}

	public Date getData_referencia() {
		return data_referencia;
	}

	public void setData_referencia(Date data_referencia) {
		this.data_referencia = data_referencia;
	}

	public Double getEstimativa_taxa_selic() {
		return estimativa_taxa_selic;
	}

	public void setEstimativa_taxa_selic(Double estimativa_taxa_selic) {
		this.estimativa_taxa_selic = estimativa_taxa_selic;
	}

	public TaxaSelic(Date data_referencia, Double double1) {
		super();
		this.data_referencia = data_referencia;
		this.estimativa_taxa_selic = double1;
	}

	@Override
	public String toString() {
		return "[data_referencia=" + data_referencia + ", estimativa_taxa_selic=" + estimativa_taxa_selic + "]";
	}

}
