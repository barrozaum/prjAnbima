package file;

import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entity.TaxaSelic;
import util.Utils;

public class LerDadosJson {

	private String caminho = "C:\\Users\\Igor\\Desktop\\java\\workspace\\prjAnbima\\src\\file\\ESTIMATIVA_SELIC.json";

	public List<TaxaSelic> listarDadosJson() {

		List<TaxaSelic> listaTaxas = new ArrayList<TaxaSelic>();

		try (FileReader reader = new FileReader(caminho)) {
			JSONParser jsonParser = new JSONParser();
			JSONArray JSONArray = (JSONArray) jsonParser.parse(reader);

			Iterator i = JSONArray.iterator();
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();

				listaTaxas.add(new TaxaSelic(Utils.converterStringParaDate(innerObj.get("data_referencia").toString()),
						new Double(innerObj.get("estimativa_taxa_selic").toString())));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listaTaxas;
	}

	public static void main(String[] args) {
		List<TaxaSelic> listaTaxas = new LerDadosJson().listarDadosJson();
		for (TaxaSelic taxaSelic : listaTaxas) {
			System.out.println("Data " + Utils.converterDateParaString(taxaSelic.getData_referencia()));
			System.out.println("Valor " + taxaSelic.getEstimativa_taxa_selic());
			System.out.println("/n");
		}

	}
}
