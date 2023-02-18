package telas;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import db.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatoriosTurmasController implements Initializable {
	String turmaRegularSelected = "Manhã(M1)", turmaEspecialSelected = "Manhã(ME1)";

	@FXML
	private ToggleGroup TurmaEspecial;

	@FXML
	private ToggleGroup TurmaRegular;

	@FXML
	void onButtonGerarRelatorioRegular(ActionEvent event) {
		try {
			Connection con=DB.getConnection(); // conectando com o Banco de Dados.
			String sql = "SELECT * FROM gestaoescolar.aluno WHERE TurmaRegular='" + turmaRegularSelected
					+ "' order by NomeAluno";
			JasperDesign jdesign = JRXmlLoader.load(".\\src\\JasperReports\\ReportTurmasRegular.jrxml");
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(sql);
			jdesign.setQuery(updateQuery);

			JasperReport jreport = JasperCompileManager.compileReport(jdesign);
			JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
			JasperViewer.viewReport(jprint, false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	@FXML
	void onButtonGerarRelatoriorEspecial(ActionEvent event) {
		try {
			Connection con=DB.getConnection(); // conectando com o Banco de Dados.
			String sql = "SELECT * FROM gestaoescolar.aluno WHERE TurmaEspecial='" + turmaEspecialSelected
					+ "' order by NomeAluno";
			JasperDesign jdesign = JRXmlLoader.load(".\\src\\JasperReports\\ReportTurmasEspecial.jrxml");
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(sql);
			jdesign.setQuery(updateQuery);

			JasperReport jreport = JasperCompileManager.compileReport(jdesign);
			JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
			JasperViewer.viewReport(jprint, false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public String radioResult(ToggleGroup rB) {
		RadioButton selectedRadioButton = (RadioButton) rB.getSelectedToggle();
		String toogleGroupValue = selectedRadioButton.getText();
		return toogleGroupValue;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TurmaRegular.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			turmaRegularSelected = radioResult(TurmaRegular);

		});
		TurmaEspecial.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			turmaEspecialSelected = radioResult(TurmaEspecial);

		});

	}
}
