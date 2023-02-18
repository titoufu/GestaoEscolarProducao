package telas;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;
import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;
import utilAlerts.Alerts;
import utilAlerts.CPF;
import utilAlerts.Constraints;

public class AlunosCadastroNovoController implements Initializable {
	final String pattern = "dd/MM/yyyy";
	public Aluno aluno = new Aluno();
	
	@FXML
	private ToggleGroup GrupoAlergia;

	@FXML
	private ToggleGroup GrupoBeneficio;

	@FXML
	private ToggleGroup GrupoBolsaFamilia;

	@FXML
	private ToggleGroup GrupoCadUnico;

	@FXML
	private ToggleGroup GrupoCirurgia;

	@FXML
	private ToggleGroup GrupoDeficiencia;

	@FXML
	private ToggleGroup GrupoDoenca;

	@FXML
	private ToggleGroup GrupoEncaminha;

	@FXML
	private ToggleGroup GrupoMoradia;

	@FXML
	private ToggleGroup GrupoRemedio;

	@FXML
	private TextField IdEnderecoTrabalho;

	@FXML
	private TextField IdNomeMae;

	@FXML
	private TextField IdNomePai;

	@FXML
	private TextField IdNumeroRuaAluno;

	@FXML
	private RadioButton IdRemedioControladoNao;

	@FXML
	private TextField IdRemedioControladoQual;

	@FXML
	private RadioButton IdRemedioControladoSim;

	@FXML
	private RadioButton idAlergiaNao;

	@FXML
	private TextField idAlergiaQual;

	@FXML
	private RadioButton idAlergiaSim;

	@FXML
	private ComboBox<String> idAnoEscolarAluno;

	@FXML
	private ComboBox<String> idRenda;

	@FXML
	private TextField idBairroAluno;

	@FXML
	private RadioButton idBeneficioNao;

	@FXML
	private RadioButton idBeneficioSim;

	@FXML
	private RadioButton idBolsaFamiliaNao;

	@FXML
	private RadioButton idBolsaFamiliaSim;

	@FXML
	private Button idButtonLimpar;

	@FXML
	private Button idButtonSalvar;

	@FXML
	private RadioButton idCadastroUnicoNao;

	@FXML
	private RadioButton idCadastroUnicoSim;

	@FXML
	private TextField idCelularAluno;

	@FXML
	private TextField idCelularMae;

	@FXML
	private TextField idCelularPai;

	@FXML
	private TextField idCelularResponsavel;

	@FXML
	private TextField idCepAluno;

	@FXML
	private TextField idCepTrabalho;

	@FXML
	private RadioButton idCirurgiaNao;

	@FXML
	private TextField idCirurgiaQual;

	@FXML
	private RadioButton idCirurgiaSim;

	@FXML
	private TextField idCpfAluno;

	@FXML
	private TextField idCpfMae;

	@FXML
	private TextField idCpfPai;

	@FXML
	private TextField idCpfResponsavel;

	@FXML
	private DatePicker idDataCadastro;

	@FXML
	private DatePicker idDataNascimentoAluno;

	@FXML
	private RadioButton idDeficienciaNao;

	@FXML
	private TextField idDeficienciaQual;

	@FXML
	private RadioButton idDeficienciaSim;

	@FXML
	private RadioButton idDoencaNao;

	@FXML
	private TextField idDoencaQual;

	@FXML
	private RadioButton idDoencaSim;

	@FXML
	private TextField idEmailAluno;

	@FXML
	private RadioButton idEncaminhaBemSocial;

	@FXML
	private RadioButton idEncaminhaCaps;

	@FXML
	private RadioButton idEncaminhaCemaia;

	@FXML
	private RadioButton idEncaminhaConselhoTutelar;
	@FXML
	private RadioButton idEncaminhaOutra;

	@FXML
	private Label idEncaminhaOutraLabel;

	@FXML
	private TextField idEncaminhaOutraTxt;

	@FXML
	private RadioButton idEncaminhaVaraInfancia;

	@FXML
	private RadioButton idEncaminhaVontadePropria;

	@FXML
	private TextField idEscolaAluno;

	@FXML
	private TextField idId;

	@FXML
	private Label idLabelAtualiza;

	@FXML
	private RadioButton idMoradiaAlugada;

	@FXML
	private RadioButton idMoradiaCedida;

	@FXML
	private RadioButton idMoradiaFinanciada;

	@FXML
	private RadioButton idMoradiaPropria;

	@FXML
	private TextField idNomeAluno;

	@FXML
	private TextField idNomeResponsavel;

	@FXML
	private TextField idNumeroNIS;

	@FXML
	private TextField idNumeroPessoasMoradia;

	@FXML
	private TextField idNumeroTrabalho;

	@FXML
	private ComboBox<String> idPeriodoAluno;
	@FXML
	private Label idQualAlergia;

	@FXML
	private Label idQualCirurgia;

	@FXML
	private Label idQualDeficiencia;

	@FXML
	private Label idQualDoenca;

	@FXML
	private Label idQualRemedio;
	@FXML
	private TextField idRgAluno;
	@FXML
	private TextField idRgMae;
	@FXML
	private TextField idRgPai;
    @FXML
    private BorderPane idBorderPane;
	@FXML
	private TextField idRgResponsavel;

	@FXML
	private TextField idRuaAluno;

	@FXML
	private ComboBox<String> idSexoAluno;

	@FXML
	private TextField idTelFixoAluno;

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
	void onCpfFormat(ActionEvent event) {
		final TextField source = (TextField) event.getSource();
		String msg = leString(source.getText(), "CPF");
		if (msg == null) {
			return;
		} else {
			source.setText(CPF.formartCpf(msg));
		}
	}

	private String leString(String id, String msg) {
		if (id == null || id.trim().equals("")) {
			Alerts.showAlert(null, "CAMPO VAZIO", "Entre com o valor do " + msg, AlertType.ERROR);
			return null;
		} else {
			return id;
		}
	}

	@FXML
	void onButtonLimparAction(ActionEvent event) {

		idMoradiaPropria.setSelected(true);

		IdRemedioControladoNao.setSelected(true);
		idDoencaNao.setSelected(true);
		idAlergiaNao.setSelected(true);
		idDeficienciaNao.setSelected(true);
		idCirurgiaNao.setSelected(true);
		idEncaminhaVontadePropria.setSelected(true);
		idBolsaFamiliaNao.setSelected(true);
		idBeneficioNao.setSelected(true);
		idCadastroUnicoNao.setSelected(true);

		idAlergiaQual.clear();
		idBairroAluno.clear();
		idCelularAluno.clear();
		idCelularMae.clear();
		idCelularPai.clear();
		idCelularResponsavel.clear();
		idCepAluno.clear();
		idCepTrabalho.clear();
		idCirurgiaQual.clear();
		idCpfAluno.clear();
		idCpfMae.clear();
		idCpfPai.clear();
		idCpfResponsavel.clear();
		idDeficienciaQual.clear();
		idDoencaQual.clear();
		idEmailAluno.clear();
		idEncaminhaOutraTxt.clear();
		IdEnderecoTrabalho.clear();
		idEscolaAluno.clear();
		idNomeAluno.clear();
		IdNomeMae.clear();
		IdNomePai.clear();
		idNomeResponsavel.clear();
		idNumeroNIS.clear();
		idNumeroPessoasMoradia.clear();
		IdNumeroRuaAluno.clear();
		idNumeroTrabalho.clear();
		IdRemedioControladoQual.clear();
		IdRemedioControladoQual.clear();
		idRgAluno.clear();
		idRgMae.clear();
		idRgPai.clear();
		idRgResponsavel.clear();
		idRuaAluno.clear();
		idTelFixoAluno.clear();
		aluno = new Aluno();
		
	}

	@FXML
	void onButtonSalvarAction(ActionEvent event) throws ParseException {
		java.sql.Date data;
		String msg = new String();
		msg = lecampo(idNomeAluno, "Nome do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setNomeAluno(msg);
		}

		data = ledata(idDataCadastro.getValue(), "Data do Cadastro");
		if (data == null) {
			return;
		} else {
			aluno.setDataCadastro(data);
		}
		msg = lecampo(idRgAluno, "RG do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setRgAluno(msg);
		}
		msg = lecampo(idCpfAluno, "CPF do Aluno");
		if (msg == null) {
			return;
		} else {
			idCpfAluno.setText(CPF.formartCpf(msg));
			aluno.setCpfAluno(idCpfAluno.getText());
		}

		data = ledata(idDataNascimentoAluno.getValue(), "Data de Nascimento");
		if (data == null) {
			return;
		} else {
			aluno.setDataNascimentoAluno(data);
		}

		aluno.setSexo(idSexoAluno.getValue());

		aluno.setNomeRuaAluno(lecampo(idRuaAluno, "Rua do Aluno"));

		msg = lecampo(IdNumeroRuaAluno, "Numero da Rua do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroRuaAluno(IdNumeroRuaAluno.getText());
		}
		msg = lecampo(idBairroAluno, "Bairro do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setBairroAluno(msg);
		}
		msg = lecampo(idCepAluno, "CEP do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setCepAluno(msg);
		}
		msg = lecampo(idCelularAluno, "Celular do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setCelularAluno(msg);
		}
		msg = lecampo(idTelFixoAluno, "Telefone Fixo do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setTelFixoAluno(msg);
		}
		msg = lecampo(idEmailAluno, "Email do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setEmailAluno(msg);
		}
		msg = lecampo(idEscolaAluno, "Nome da Escola do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setEscolaAluno(msg);
		}

		aluno.setPeriodoAluno(idPeriodoAluno.getValue());
		aluno.setAnoEscolarAluno(idAnoEscolarAluno.getValue());

		msg = lecampo(IdNomeMae, "Nome da Mãe");
		if (msg == null) {
			return;
		} else {
			aluno.setNomeMae(msg);
		}
		msg = lecampo(idRgMae, "RG da Mãe");
		if (msg == null) {
			return;
		} else {
			aluno.setRgMae(msg);
		}
		msg = lecampo(idCpfMae, "CPF da Mãe");
		if (msg == null) {
			return;
		} else {
			idCpfMae.setText(CPF.formartCpf(msg));
			aluno.setCpfMae(idCpfMae.getText());
		}
		msg = lecampo(idCelularMae, "Celular da Mãe");
		if (msg == null) {
			return;
		} else {
			aluno.setCelularMae(msg);
		}
		msg = lecampo(IdNomePai, "Nome do Pai");
		if (msg == null) {
			return;
		} else {
			aluno.setNomePai(msg);
		}
		msg = lecampo(idRgPai, "RG do Pai");
		if (msg == null) {
			return;
		} else {
			aluno.setRgPai(msg);
		}
		msg = lecampo(idCpfPai, "CPF do Pai");
		if (msg == null) {
			return;
		} else {
			idCpfPai.setText(CPF.formartCpf(msg));
			aluno.setCpfPai(idCpfPai.getText());
		}
		msg = lecampo(idCelularPai, "Celular do Pai");
		if (msg == null) {
			return;
		} else {
			aluno.setCelularPai(msg);
		}
		msg = lecampo(idNomeResponsavel, "Nome do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setNomeResponsavel(msg);
		}
		msg = lecampo(idRgResponsavel, "RG do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setRgResponsavel(msg);
		}
		msg = lecampo(idCpfResponsavel, "CPF do Responsável");
		if (msg == null) {
			return;
		} else {
			idCpfResponsavel.setText(CPF.formartCpf(msg));
			aluno.setCpfResponsavel(idCpfResponsavel.getText());
		}
		msg = lecampo(idCelularResponsavel, "Celular do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setCelularResponsavel(msg);
		}

		msg = lecampo(IdEnderecoTrabalho, "Endereço de Trabalho do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setEnderecoTrabalho(msg);
		}

		msg = lecampo(idNumeroTrabalho, "Número do Endereço de Trabalho do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroTrabalho(idNumeroTrabalho.getText());
		}

		msg = lecampo(idCepTrabalho, "CEP do Responsável de Trabalho");
		if (msg == null) {
			return;
		} else {
			aluno.setCepTrabalho(msg);
		}
		msg = lecampo(idNumeroPessoasMoradia, "Número de Pessoas na Moradia");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroPessoasNaMoradia(idNumeroPessoasMoradia.getText());

		}
		aluno.setRendaFamiliar(idRenda.getValue());

		if (radioResult(GrupoAlergia).equals("SIM")) {
			msg = lecampo(idAlergiaQual, "Tipo de Alergia");
			if (msg == null) {
				return;
			} else {
				aluno.setAlergiaQual(msg);
			}
		}
		if (radioResult(GrupoDeficiencia).equals("SIM")) {
			msg = lecampo(idDeficienciaQual, "Tipo de Dediciência");
			if (msg == null) {
				return;
			} else {
				aluno.setDeficienciaQual(msg);
			}
		}
		;
		if (radioResult(GrupoCirurgia).equals("SIM")) {
			msg = lecampo(idCirurgiaQual, "Tipo de Cirurgia");
			if (msg == null) {
				return;
			} else {
				aluno.setCirurgiaQual(msg);
			}
		}
		;
		if (radioResult(GrupoDoenca).equals("SIM")) {
			msg = lecampo(idDoencaQual, "Tipo de Doença");
			if (msg == null) {
				return;
			} else {
				aluno.setDoencaQual(msg);
			}
		}
		;

		if (radioResult(GrupoRemedio).equals("SIM")) {
			msg = lecampo(IdRemedioControladoQual, "Tipo de Remédio");
			if (msg == null) {
				return;
			} else {
				aluno.setRemedioQual(msg);
			}
		}
		msg = lecampo(idNumeroNIS, "Número NIS");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroNIS(idNumeroNIS.getText());
		}

		aluno.setEncaminhaOutra(idEncaminhaOutraTxt.getText());

		if (radioResult(GrupoEncaminha).equals("Outra")) {
			msg = lecampo(idEncaminhaOutraTxt, "Outra Forma de Encaminhamento");
			if (msg == null) {
				return;
			} else {
				aluno.setEncaminhaOutra(msg);
			}
		}
		conectar_salvar(aluno);
	}

	public void conectar_salvar(Aluno aluno) {
		AlunoDao alunodao = DaoFactory.createAlunoDao();
		alunodao.insert(aluno);
	}

	private Date ledata(LocalDate localDate, String msg) throws ParseException {
		if (localDate == null || localDate.equals("")) {
			Alerts.showAlert(null, "CAMPO VAZIO", "Entre com o valor do " + msg, AlertType.ERROR);
			return null;
		} else {
			return java.sql.Date.valueOf(localDate);
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

	public String radioResult(ToggleGroup rB) {
		RadioButton selectedRadioButton = (RadioButton) rB.getSelectedToggle();
		String toogleGroupValue = selectedRadioButton.getText();
		return toogleGroupValue;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {

	
		idSexoAluno.getItems().addAll("Masculino", "Feminino", "Não declarado");
		idSexoAluno.setValue("Masculino");

		idPeriodoAluno.getItems().addAll("Matutino", "Vespertino");
		idPeriodoAluno.setValue("Matutino");

		idRenda.getItems().addAll("Menor que 2.0 SM", "Entre 2.0 e 3.0 SM", "Entre 3.0 e 4.0 SM", "Entre 4.0 e 5.0 SM",
				"Maior que 5.0 SM");
		idRenda.setValue("Menor que 2.0 SM");

		idAnoEscolarAluno.getItems().addAll("Nenhuma", "Primeira", "Segunda", "Terceira", "Quarta", "Quinta", "Sexta",
				"Oitava");
		idAnoEscolarAluno.setValue("Primeira");

		idDataNascimentoAluno.setConverter(converter);
		idDataNascimentoAluno.setPromptText(pattern.toLowerCase());

		idDataCadastro.setConverter(converter);
		idDataCadastro.setPromptText(pattern.toLowerCase());

		idDataCadastro.setValue(LocalDate.now());
		idEncaminhaOutraTxt.setVisible(false);
		
		aluno.setSituacao("Em Espera");
		aluno.setMoradia("Própria");
		
		aluno.setAlergia("NÃo");
		aluno.setDeficiencia("NÃO");
		aluno.setCirurgia("NÃO");
		aluno.setDoenca("NÃO");
		aluno.setRemedio("NÃO");
		aluno.setBolsaFamilia("NÃO");
		aluno.setBeneficio("NÃO");
		aluno.setCadastroUnico("NÃO");
		aluno.setEncaminha("Vontade própria");
		aluno.setTurmaRegular("Nenhuma");
		aluno.setTurmaEspecial("Nenhuma");
		

		Constraints.setTextFieldInteger(IdNumeroRuaAluno);
		Constraints.setTextFieldInteger(idNumeroPessoasMoradia);
		Constraints.setTextFieldInteger(idNumeroTrabalho);
		Constraints.setTextFieldInteger(idNumeroNIS);

		GrupoMoradia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setMoradia(radioResult(GrupoMoradia)));

		GrupoAlergia.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setAlergia(radioResult(GrupoAlergia));
			if (radioResult(GrupoAlergia).equals("SIM")) {
				idQualAlergia.setVisible(true);
				idAlergiaQual.setVisible(true);
			} else {
				idQualAlergia.setVisible(false);
				idAlergiaQual.setVisible(false);
				aluno.setAlergiaQual(null);
				idAlergiaQual.setText(null);
			}
		});

		GrupoDeficiencia.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setDeficiencia(radioResult(GrupoDeficiencia));
			if (radioResult(GrupoDeficiencia).equals("SIM")) {
				idQualDeficiencia.setVisible(true);
				idDeficienciaQual.setVisible(true);
			} else {
				idQualDeficiencia.setVisible(false);
				idDeficienciaQual.setVisible(false);
				aluno.setDeficienciaQual(null);
				idDeficienciaQual.setText(null);
			}
		});

		GrupoCirurgia.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setCirurgia(radioResult(GrupoCirurgia));
			if (radioResult(GrupoCirurgia).equals("SIM")) {
				idQualCirurgia.setVisible(true);
				idCirurgiaQual.setVisible(true);
			} else {
				idQualCirurgia.setVisible(false);
				idCirurgiaQual.setVisible(false);
				aluno.setCirurgiaQual(null);
				idCirurgiaQual.setText(null);
			}
		});

		GrupoDoenca.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setDoenca(radioResult(GrupoDoenca));
			if (radioResult(GrupoDoenca).equals("SIM")) {
				idQualDoenca.setVisible(true);
				idDoencaQual.setVisible(true);
			} else {
				idQualDoenca.setVisible(false);
				idDoencaQual.setVisible(false);
				aluno.setDoencaQual(null);
				idDoencaQual.setText(null);

			}
		});

		GrupoRemedio.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setRemedio(radioResult(GrupoRemedio));
			if (radioResult(GrupoRemedio).equals("SIM")) {
				idQualRemedio.setVisible(true);
				IdRemedioControladoQual.setVisible(true);
			} else {
				idQualRemedio.setVisible(false);
				IdRemedioControladoQual.setVisible(false);
				aluno.setRemedioQual(null);
				IdRemedioControladoQual.setText(null);
			}
		});

		GrupoBolsaFamilia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setBolsaFamilia(radioResult(GrupoBolsaFamilia)));
		GrupoBeneficio.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setBeneficio(radioResult(GrupoBeneficio)));
		GrupoCadUnico.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setCadastroUnico(radioResult(GrupoCadUnico)));

		GrupoEncaminha.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setEncaminha(radioResult(GrupoEncaminha));
			if (radioResult(GrupoEncaminha).equals("Outra")) {
					idEncaminhaOutraTxt.setVisible(true);
			} else {
				idEncaminhaOutraTxt.setVisible(false);
				idEncaminhaOutraTxt.setText(null);
				aluno.setEncaminhaOutra(null);
			}
		}

		);

		// controlando o tamanho dos campos

		Constraints.setTextFieldMaxLength(idNomeAluno, 60);
		Constraints.setTextFieldMaxLength(idRgAluno, 15);
		Constraints.setTextFieldMaxLength(idCpfAluno, 15);
		Constraints.setTextFieldMaxLength(idRuaAluno, 60);
		Constraints.setTextFieldMaxLength(IdNumeroRuaAluno, 4);
		Constraints.setTextFieldMaxLength(idBairroAluno, 60);
		Constraints.setTextFieldMaxLength(idCepAluno, 20);
		Constraints.setTextFieldMaxLength(idCelularAluno, 15);
		Constraints.setTextFieldMaxLength(idTelFixoAluno, 20);
		Constraints.setTextFieldMaxLength(idEmailAluno, 60);
		Constraints.setTextFieldMaxLength(idEscolaAluno, 60);
		Constraints.setTextFieldMaxLength(IdNomeMae, 60);
		Constraints.setTextFieldMaxLength(idRgMae, 15);
		Constraints.setTextFieldMaxLength(idCpfMae, 15);
		Constraints.setTextFieldMaxLength(idCelularMae, 15);
		Constraints.setTextFieldMaxLength(IdNomePai, 60);
		Constraints.setTextFieldMaxLength(idRgPai, 15);
		Constraints.setTextFieldMaxLength(idCpfPai, 15);
		Constraints.setTextFieldMaxLength(idCelularPai, 15);
		Constraints.setTextFieldMaxLength(idNomeResponsavel, 60);
		Constraints.setTextFieldMaxLength(idRgResponsavel, 20);
		Constraints.setTextFieldMaxLength(idCpfResponsavel, 15);
		Constraints.setTextFieldMaxLength(idCelularResponsavel, 15);
		Constraints.setTextFieldMaxLength(IdEnderecoTrabalho, 60);
		Constraints.setTextFieldMaxLength(idNumeroTrabalho, 4);
		Constraints.setTextFieldMaxLength(idCepTrabalho, 20);
		Constraints.setTextFieldMaxLength(idNumeroPessoasMoradia, 2);
		Constraints.setTextFieldMaxLength(idAlergiaQual, 60);
		Constraints.setTextFieldMaxLength(idDeficienciaQual, 60);
		Constraints.setTextFieldMaxLength(idCirurgiaQual, 60);
		Constraints.setTextFieldMaxLength(idDoencaQual, 60);
		Constraints.setTextFieldMaxLength(IdRemedioControladoQual, 60);
		Constraints.setTextFieldMaxLength(idNumeroNIS, 11);
		Constraints.setTextFieldMaxLength(idEncaminhaOutraTxt, 60);

	}

}
