package facade;

import java.util.List;

import vo.MediaTaxaAnual;
import vo.TaxaSelicVo;

public interface ITaxaSelicServiceFacade {

	public List<MediaTaxaAnual> calculoTaxaSelicAnualMedia(String ano);
	
	public List<MediaTaxaAnual> calculoTaxaSelicAnual();
	
	public List<TaxaSelicVo> consultaPeriodoTaxa(String ano, String mes);
	
	public List<TaxaSelicVo> historico();
}
