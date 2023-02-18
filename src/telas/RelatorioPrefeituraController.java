package telas;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import utilAlerts.Alerts;
import utilAlerts.DateUtil;

public class RelatorioPrefeituraController implements Initializable {
	final String pattern = "dd/MM/yyyy";
	@FXML
	private DatePicker idPickerFinal;

	@FXML
	private DatePicker idPickerInicial;

	StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

		@Override
		public String toString(LocalDate date) {
			if (date != null) {
				return dateFormatter.format(date);
			} else {
				return "";
			}
		}

		@Override
		public LocalDate fromString(String string) {
			if (string != null && !string.isEmpty()) {
				return LocalDate.parse(string, dateFormatter);
			} else {
				return null;
			}
		}
	};

	@FXML
	void onButtonGerar(ActionEvent event) {
		LocalDate localDateInicial = idPickerInicial.getValue();
		LocalDate localDateFinal = idPickerFinal.getValue();
		if (localDateInicial == null || localDateFinal == null) {
			Alerts.showAlert("Atenção", "", "Escolha as Datas Corretamente", AlertType.ERROR);
			return;
		}
		Date dataInicial = java.sql.Date.valueOf(localDateInicial);
		Date dataFinal = java.sql.Date.valueOf(localDateFinal);
		if (dataInicial.compareTo(dataFinal) >= 0) {
			Alerts.showAlert("Atenção", "", "Data Inicial deve ser Inferior a Data Final!", AlertType.ERROR);
			return;
		}
		String dataIni = dataInicial.toString();
		String dataFin = dataFinal.toString();
		////////////////
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("JDBC:MYSQL://localhost:3306/gestaoescolar", "root",
					"1234567");

			String sql = "SELECT  NomeAluno,Situacao,DataNascimentoAluno,DataMatricula,DataExclusao,"
					+ "NomeResponsavel,CpfResponsavel,EnderecoTrabalho,NumeroTrabalho,CelularResponsavel"
					+ " FROM aluno WHERE" + " (DataExclusao >'" + dataIni + "' AND DataExclusao < '" + dataFin + "')"
					+ " OR Situacao='Matriculado'" + " ORDER BY Situacao DESC,NomeAluno ASC";

			String path= new File("").getAbsolutePath()+ "\\src\\JasperReports\\RelatorioPrefeitura.jrxml";
			JasperDesign jdesign = JRXmlLoader.load(path);
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(sql);
			jdesign.setQuery(updateQuery);

			// passando parametro para o Java reports

			HashMap<String, Object> hm = new HashMap<String, Object>();
			String dataInicio = DateUtil.dateShort(localDateInicial);
			String dataFim = DateUtil.dateShort(localDateFinal);
			hm.put("dataInicial", dataInicio);
			hm.put("DataFinal", dataFim);

			JasperReport jreport = JasperCompileManager.compileReport(jdesign);
			JasperPrint jprint = JasperFillManager.fillReport(jreport, hm, con);
			JasperViewer.viewReport(jprint, false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		/////////////////

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idPickerInicial.setConverter(converter);
		idPickerInicial.setPromptText(pattern.toLowerCase());
		idPickerFinal.setConverter(converter);
		idPickerFinal.setPromptText(pattern.toLowerCase());
	}
	

}
