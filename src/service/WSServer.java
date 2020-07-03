package service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import facade.TaxaSelicFacade;
import vo.TaxaSelicVo;

@Path("/taxa-selic-service")
public class WSServer {

	private TaxaSelicFacade ts = new TaxaSelicFacade();

	@GET
	@Path("/exbirTaxaSelic/{ano}")
	@Produces("application/json")
	public String exbirTaxaSelic(@PathParam("ano") String ano) {
		return new Gson().toJson(efetuarConsulta(ano, null));
	}

	@GET
	@Path("/exbirTaxaSelic/{ano}/{mes}")
	@Produces("application/json")
	public String exbirTaxaSelic(@PathParam("ano") String ano, @PathParam("mes") String mes) {
		return new Gson().toJson(efetuarConsulta(ano, mes));
	}

	private List<TaxaSelicVo> efetuarConsulta(String ano, String mes) {
		try {
			return ts.consultaPeriodoTaxa(ano, mes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/historico")
	@Produces("application/json")
	public String historico() {
		return new Gson().toJson(ts.historico());
	}
	
	@GET
	@Path("/media-taxa-anual/{ano}")
	@Produces("application/json")
	public String mediaTaxaAnual(@PathParam("ano") String ano) {
		return new Gson().toJson(ts.calculoTaxaSelicAnualMedia(ano));
	}
	
	@GET
	@Path("/taxa-anual")
	@Produces("application/json")
	public String taxaAnual() {
		return new Gson().toJson(ts.calculoTaxaSelicAnual());
	}
	

	@GET
	@Path("/media-taxa-anual")
	@Produces("application/json")
	public String mediaTaxaAnual() {
		return new Gson().toJson(ts.calculoTaxaSelicAnualMedia(null));
	}


	
}
