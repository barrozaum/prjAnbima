package vo;

public class MediaTaxaAnual {

	private String anoTaxa;
	
	private String valor;

	public MediaTaxaAnual() {
	
	}
	
	
	
	public MediaTaxaAnual(String anoTaxa, String valor) {
		super();
		this.anoTaxa = anoTaxa;
		this.valor = valor;
	}



	public MediaTaxaAnual(String anoBase, int i) {
		// TODO Auto-generated constructor stub
	}



	public String getAnoTaxa() {
		return anoTaxa;
	}

	public void setAnoTaxa(String anoTaxa) {
		this.anoTaxa = anoTaxa;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
