
package telas;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import db.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem idAtualizarAluno;

	@FXML
	private BorderPane idBorderPane;

	@FXML
	private Button idButtonSair;

	@FXML
	private Button idButtonVoltar;

	@FXML
	private MenuItem idCadastrarAluno;

	@FXML
	private ImageView idImage;

	@FXML
	private MenuItem idMatricularAluno;

	@FXML
	private MenuItem idRemoverAluno;

	@FXML
	private MenuBar myMenuBar;
	///// começo ////////
	@FXML
	private MenuItem idRelAlunosDesligados;

	@FXML
	private MenuItem idRelAlunosEspera;

	@FXML
	private MenuItem idRelAlunosMatriculados;

	@FXML
	private MenuItem idRelPMU;

	@FXML
	private MenuItem idRelTurmas;
	///// FIM ////

	///// COMECO ///
	@FXML
	void onMenuRelAlunosEmEspera(ActionEvent event) {
		CenaCentral("/telas/TelaAbertura.fxml");
		try {

			Connection con = DB.getConnection(); // conectando com o Banco de Dados.
			String sql = "SELECT * FROM aluno  WHERE Situacao = 'Em espera' ORDER BY NomeAluno";
			JasperDesign jdesign = JRXmlLoader.load(".\\src\\JasperReports\\ReportAlunoEmEspera.jrxml");
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
	void onMenuRelAlunosMatriculados(ActionEvent event) {
		CenaCentral("/telas/TelaAbertura.fxml");
		try {
			Connection con = DB.getConnection(); // conectando com o Banco de Dados.
			String sql = "SELECT * FROM aluno  WHERE Situacao = 'Matriculado' ORDER BY NomeAluno";
			JasperDesign jdesign = JRXmlLoader.load(".\\src\\JasperReports\\ReportAlunoMatriculado.jrxml");
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
	void onMenuRelDesligados(ActionEvent event) {
		CenaCentral("/telas/TelaAbertura.fxml");
		try {
			CenaCentral("/telas/TelaAbertura.fxml");
			Connection con = DB.getConnection(); // conectando com o Banco de Dados.
			String sql = "SELECT * FROM aluno  WHERE Situacao = 'Desligado' ORDER BY NomeAluno";
			JasperDesign jdesign = JRXmlLoader.load(".\\src\\JasperReports\\ReportAlunoDesligado.jrxml");
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
	void onMenuRelPMU(ActionEvent event) {
		CenaCentral("/telas/TelaAbertura.fxml");
		CenaCentral("/telas/RelatorioPrefeitura.fxml");
	}

	@FXML
	void onMenuRelTurmas(ActionEvent event) {
		CenaCentral("/telas/TelaAbertura.fxml");
		CenaCentral("/telas/RelatorioTurmas.fxml");
	}

	//// FIM ////

	@FXML
	void onMenuCadastrarAluno(ActionEvent event) {
		CenaCentral("/telas/AlunosCadastroNovo.fxml");

	}

	@FXML
	void onMenuAtualizarAluno(ActionEvent event) {
		CenaCentral("/telas/AlunosCadastroAtualiza.fxml");

	}

	@FXML
	void omMenuRemoverAluno(ActionEvent event) {
		CenaCentral("/telas/AlunosCadastroRemove.fxml");
	}

	@FXML
	void onMenuMatricularAluno(ActionEvent event) {
		CenaCentral("/telas/AlunosMatricula.fxml");
	}

	@FXML
	void onButtonSair(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void onButtonVoltar(ActionEvent event) {
		CenaCentral("/telas/TelaAbertura.fxml");
	}

	private void CenaCentral(String cena) {
		try {
			idBorderPane.setCenter(FXMLLoader.load(getClass().getResource(cena)));
			idBorderPane.setPrefWidth(900);
			idBorderPane.setPrefHeight(600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			idImage.setPreserveRatio(true);
			idBorderPane.setPrefWidth(900);
			idBorderPane.setPrefHeight(600);
			idBorderPane.setCenter(idImage);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}