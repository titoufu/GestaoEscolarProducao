
package telas;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.dao.AlunoDao;
import model.dao.DaoFactory;
import utilAlerts.Alerts;
import utilAlerts.CPF;

public class AlunosCadastroRemoveController {

	@FXML
	private TextField idRemoveAluno;

	@FXML
	void onRemoverAluno(ActionEvent event) {
		String msg = lecampo(idRemoveAluno, "CPF do Aluno");
		if (msg == null) {
			return;
		} else {
			idRemoveAluno.setText(CPF.formartCpf(msg));
			conectar_Remover(idRemoveAluno.getText());
		}
	}

	private void conectar_Remover(String cpf) {
		AlunoDao alunodao = DaoFactory.createAlunoDao();
		if (alunodao.findByCpf(cpf) == null) {
			Alerts.showAlert("Remover CPF", "", "CPF não cadastrado", AlertType.WARNING);
		} else {
			Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Você está certo que quer remover?");
			if(result.get()==ButtonType.OK) {
				alunodao.deleteByCpf(cpf);
			}
		}
	}

	public String lecampo(TextField id, String msg) {
		if (id.getText() == null || id.getText().trim().equals("")) {
			Alerts.showAlert(null, "CAMPO VAZIO", "Entre com o valor do " + msg, AlertType.ERROR);
			return null;
		} else {
			return id.getText();
		}
	}

}