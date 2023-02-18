package utilAlerts;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AlunosEmEsperaController implements Initializable {

	@FXML
	private Button idButtonEspera;

	@FXML
	void onButtonEspera(ActionEvent event) {
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); Connection con =
		 * DriverManager.getConnection("JDBC:MYSQL://localhost:3306/stdinfo", "root",
		 * "1234567"); String sql = "SELECT * FROM aluno"; JasperDesign jdesign =
		 * JRXmlLoader .load(
		 * "C:\\Users\\jribe\\eclipse-workspace\\MariaLobatoGenteJovem\\src\\JasperReports"
		 * ); JRDesignQuery updateQuery = new JRDesignQuery(); updateQuery.setText(sql);
		 * JasperReport jreport = JasperCompileManager.compileReport(jdesign);
		 * JasperPrint jprint = JasperFillManager.fillReport(jreport, null,con);
		 * JasperViewer.viewReport(jprint, false);
		 * 
		 * } catch (Exception e) { JOptionPane.showMessageDialog(null, e); } }
		 * 
		 * 
		 */
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
}