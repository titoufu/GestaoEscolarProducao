package utilAlerts;

import java.text.ParseException;

public class CPF {
	public static String formartCpf(String cpf) {
		
		try {
			cpf=cpf.replaceAll("\\D",""); // removendo caracteres não numéricos.
			return formatNumericString(cpf, "###.###.###-##");
		} catch (ParseException e) {
			return null;
		}
	}

	public static String formatNumericString(String string, String mask) throws java.text.ParseException {
		javax.swing.text.MaskFormatter mf = new javax.swing.text.MaskFormatter(mask);
		mf.setValueContainsLiteralCharacters(false);
		return mf.valueToString(string);
	}

}
