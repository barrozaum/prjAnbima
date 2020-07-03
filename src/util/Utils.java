package util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import vo.MediaTaxaAnual;

public class Utils {

	public static String converterValor(Double valor) {

		return NumberFormat.getCurrencyInstance().format(valor);
	}

	public static Date converterStringParaDate(String data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-DD");
		Date dataConvertida = formato.parse(data);
		return dataConvertida;
	}

	public static String converterDateParaString(Date data) {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
			return formato.format(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String pegarMes(Date data) {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("mm");
			return formato.format(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String pegarAno(Date data) {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("YYYY");
			return formato.format(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
