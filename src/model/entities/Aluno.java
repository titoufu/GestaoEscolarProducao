package model.entities;

import java.io.Serializable;
import java.sql.Date;



public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomeAluno;
	private Date dataCadastro;
	private String situacao;
	private String rgAluno;
	private String cpfAluno;
	private Date dataNascimentoAluno;
	private String sexo;
	private String nomeRuaAluno;
	private String numeroRuaAluno;
	private String bairroAluno;
	private String cepAluno;
	private String celularAluno;
	private String telFixoAluno;
	private String emailAluno;
	private String escolaAluno;
	private String periodoAluno;
	private String anoEscolarAluno;
	private String nomeMae;
	private String rgMae;
	private String cpfMae;
	private String celularMae;
	private String nomePai;
	private String rgPai;
	private String cpfPai;
	private String celularPai;
	private String nomeResponsavel;
	private String rgResponsavel;
	private String cpfResponsavel;
	private String celularResponsavel;
	private String enderecoTrabalho;
	private String numeroTrabalho;
	private String cepTrabalho;
	private String moradia;
	private String numeroPessoasNaMoradia;
	private String alergia;
	private String alergiaQual;
	private String deficiencia;
	private String deficienciaQual;
	private String cirurgia;
	private String cirurgiaQual;
	private String doenca;
	private String doencaQual;
	private String remedio;
	private String remedioQual;
	private String bolsaFamilia;
	private String beneficio;
	private String cadastroUnico;
	private String numeroNIS;
	private String encaminha;
	private String encaminhaOutra;
	private Date DataMatricula;
	private Date DataExclusao;
	private String TurmaRegular;  
	private String TurmaEspecial;
	private String RendaFamiliar;
	public Aluno() {
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getRgAluno() {
		return rgAluno;
	}
	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}
	public String getCpfAluno() {
		return cpfAluno;
	}
	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}
	public Date getDataNascimentoAluno() {
		return dataNascimentoAluno;
	}
	public void setDataNascimentoAluno(Date dataNascimentoAluno) {
		this.dataNascimentoAluno = dataNascimentoAluno;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNomeRuaAluno() {
		return nomeRuaAluno;
	}
	public void setNomeRuaAluno(String nomeRuaAluno) {
		this.nomeRuaAluno = nomeRuaAluno;
	}
	public String getNumeroRuaAluno() {
		return numeroRuaAluno;
	}
	public void setNumeroRuaAluno(String numeroRuaAluno) {
		this.numeroRuaAluno = numeroRuaAluno;
	}
	public String getBairroAluno() {
		return bairroAluno;
	}
	public void setBairroAluno(String bairroAluno) {
		this.bairroAluno = bairroAluno;
	}
	public String getCepAluno() {
		return cepAluno;
	}
	public void setCepAluno(String cepAluno) {
		this.cepAluno = cepAluno;
	}
	public String getCelularAluno() {
		return celularAluno;
	}
	public void setCelularAluno(String celularAluno) {
		this.celularAluno = celularAluno;
	}
	public String getTelFixoAluno() {
		return telFixoAluno;
	}
	public void setTelFixoAluno(String telFixoAluno) {
		this.telFixoAluno = telFixoAluno;
	}
	public String getEmailAluno() {
		return emailAluno;
	}
	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	public String getEscolaAluno() {
		return escolaAluno;
	}
	public void setEscolaAluno(String escolaAluno) {
		this.escolaAluno = escolaAluno;
	}
	public String getPeriodoAluno() {
		return periodoAluno;
	}
	public void setPeriodoAluno(String periodoAluno) {
		this.periodoAluno = periodoAluno;
	}
	public String getAnoEscolarAluno() {
		return anoEscolarAluno;
	}
	public void setAnoEscolarAluno(String anoEscolarAluno) {
		this.anoEscolarAluno = anoEscolarAluno;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getRgMae() {
		return rgMae;
	}
	public void setRgMae(String rgMae) {
		this.rgMae = rgMae;
	}
	public String getCpfMae() {
		return cpfMae;
	}
	public void setCpfMae(String cpfMae) {
		this.cpfMae = cpfMae;
	}
	public String getCelularMae() {
		return celularMae;
	}
	public void setCelularMae(String celularMae) {
		this.celularMae = celularMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getRgPai() {
		return rgPai;
	}
	public void setRgPai(String rgPai) {
		this.rgPai = rgPai;
	}
	public String getCpfPai() {
		return cpfPai;
	}
	public void setCpfPai(String cpfPai) {
		this.cpfPai = cpfPai;
	}
	public String getCelularPai() {
		return celularPai;
	}
	public void setCelularPai(String celularPai) {
		this.celularPai = celularPai;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getRgResponsavel() {
		return rgResponsavel;
	}
	public void setRgResponsavel(String rgResponsavel) {
		this.rgResponsavel = rgResponsavel;
	}
	public String getCpfResponsavel() {
		return cpfResponsavel;
	}
	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}
	public String getCelularResponsavel() {
		return celularResponsavel;
	}
	public void setCelularResponsavel(String celularResponsavel) {
		this.celularResponsavel = celularResponsavel;
	}
	public String getEnderecoTrabalho() {
		return enderecoTrabalho;
	}
	public void setEnderecoTrabalho(String enderecoTrabalho) {
		this.enderecoTrabalho = enderecoTrabalho;
	}
	public String getNumeroTrabalho() {
		return numeroTrabalho;
	}
	public void setNumeroTrabalho(String numeroTrabalho) {
		this.numeroTrabalho = numeroTrabalho;
	}
	public String getCepTrabalho() {
		return cepTrabalho;
	}
	public void setCepTrabalho(String cepTrabalho) {
		this.cepTrabalho = cepTrabalho;
	}
	public String getMoradia() {
		return moradia;
	}
	public void setMoradia(String moradia) {
		this.moradia = moradia;
	}
	public String getNumeroPessoasNaMoradia() {
		return numeroPessoasNaMoradia;
	}
	public void setNumeroPessoasNaMoradia(String numeroPessoasNaMoradia) {
		this.numeroPessoasNaMoradia = numeroPessoasNaMoradia;
	}
	public String getAlergia() {
		return alergia;
	}
	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}
	public String getAlergiaQual() {
		return alergiaQual;
	}
	public void setAlergiaQual(String alergiaQual) {
		this.alergiaQual = alergiaQual;
	}
	public String getDeficiencia() {
		return deficiencia;
	}
	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}
	public String getDeficienciaQual() {
		return deficienciaQual;
	}
	public void setDeficienciaQual(String deficienciaQual) {
		this.deficienciaQual = deficienciaQual;
	}
	public String getCirurgia() {
		return cirurgia;
	}
	public void setCirurgia(String cirurgia) {
		this.cirurgia = cirurgia;
	}
	public String getCirurgiaQual() {
		return cirurgiaQual;
	}
	public void setCirurgiaQual(String cirurgiaQual) {
		this.cirurgiaQual = cirurgiaQual;
	}
	public String getDoenca() {
		return doenca;
	}
	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}
	public String getDoencaQual() {
		return doencaQual;
	}
	public void setDoencaQual(String doencaQual) {
		this.doencaQual = doencaQual;
	}
	public String getRemedio() {
		return remedio;
	}
	public void setRemedio(String remedio) {
		this.remedio = remedio;
	}
	public String getRemedioQual() {
		return remedioQual;
	}
	public void setRemedioQual(String remedioQual) {
		this.remedioQual = remedioQual;
	}
	public String getBolsaFamilia() {
		return bolsaFamilia;
	}
	public void setBolsaFamilia(String bolsaFamilia) {
		this.bolsaFamilia = bolsaFamilia;
	}
	public String getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	public String getCadastroUnico() {
		return cadastroUnico;
	}
	public void setCadastroUnico(String cadastroUnico) {
		this.cadastroUnico = cadastroUnico;
	}
	public String getNumeroNIS() {
		return numeroNIS;
	}
	public void setNumeroNIS(String numeroNIS) {
		this.numeroNIS = numeroNIS;
	}
	public String getEncaminha() {
		return encaminha;
	}
	public void setEncaminha(String encaminha) {
		this.encaminha = encaminha;
	}
	public String getEncaminhaOutra() {
		return encaminhaOutra;
	}
	public void setEncaminhaOutra(String encaminhaOutra) {
		this.encaminhaOutra = encaminhaOutra;
	}
	public Date getDataMatricula() {
		return DataMatricula;
	}
	public void setDataMatricula(Date dataMatricula) {
		DataMatricula = dataMatricula;
	}
	public Date getDataExclusao() {
		return DataExclusao;
	}
	public void setDataExclusao(Date dataExclusao) {
		DataExclusao = dataExclusao;
	}
	public String getTurmaRegular() {
		return TurmaRegular;
	}
	public void setTurmaRegular(String turmaRegular) {
		TurmaRegular = turmaRegular;
	}
	public String getTurmaEspecial() {
		return TurmaEspecial;
	}
	public void setTurmaEspecial(String turmaEspecial) {
		TurmaEspecial = turmaEspecial;
	}
	public String getRendaFamiliar() {
		return RendaFamiliar;
	}
	public void setRendaFamiliar(String rendaFamiliar) {
		RendaFamiliar = rendaFamiliar;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nomeAluno=" + nomeAluno + ", dataCadastro=" + dataCadastro + ", situacao="
				+ situacao + ", rgAluno=" + rgAluno + ", cpfAluno=" + cpfAluno + ", dataNascimentoAluno="
				+ dataNascimentoAluno + ", sexo=" + sexo + ", nomeRuaAluno=" + nomeRuaAluno + ", numeroRuaAluno="
				+ numeroRuaAluno + ", bairroAluno=" + bairroAluno + ", cepAluno=" + cepAluno + ", celularAluno="
				+ celularAluno + ", telFixoAluno=" + telFixoAluno + ", emailAluno=" + emailAluno + ", escolaAluno="
				+ escolaAluno + ", periodoAluno=" + periodoAluno + ", anoEscolarAluno=" + anoEscolarAluno + ", nomeMae="
				+ nomeMae + ", rgMae=" + rgMae + ", cpfMae=" + cpfMae + ", celularMae=" + celularMae + ", nomePai="
				+ nomePai + ", rgPai=" + rgPai + ", cpfPai=" + cpfPai + ", celularPai=" + celularPai
				+ ", nomeResponsavel=" + nomeResponsavel + ", rgResponsavel=" + rgResponsavel + ", cpfResponsavel="
				+ cpfResponsavel + ", celularResponsavel=" + celularResponsavel + ", enderecoTrabalho="
				+ enderecoTrabalho + ", numeroTrabalho=" + numeroTrabalho + ", cepTrabalho=" + cepTrabalho
				+ ", moradia=" + moradia + ", numeroPessoasNaMoradia=" + numeroPessoasNaMoradia + ", alergia=" + alergia
				+ ", alergiaQual=" + alergiaQual + ", deficiencia=" + deficiencia + ", deficienciaQual="
				+ deficienciaQual + ", cirurgia=" + cirurgia + ", cirurgiaQual=" + cirurgiaQual + ", doenca=" + doenca
				+ ", doencaQual=" + doencaQual + ", remedio=" + remedio + ", remedioQual=" + remedioQual
				+ ", bolsaFamilia=" + bolsaFamilia + ", beneficio=" + beneficio + ", cadastroUnico=" + cadastroUnico
				+ ", numeroNIS=" + numeroNIS + ", encaminha=" + encaminha + ", encaminhaOutra=" + encaminhaOutra
				+ ", DataMatricula=" + DataMatricula + ", DataExclusao=" + DataExclusao + ", TurmaRegular="
				+ TurmaRegular + ", TurmaEspecial=" + TurmaEspecial + ", RendaFamiliar=" + RendaFamiliar + "]";
	}
	
}
