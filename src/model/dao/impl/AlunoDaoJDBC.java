package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import db.DB;
import db.DbException;
import model.dao.AlunoDao;
import model.entities.Aluno;

public class AlunoDaoJDBC implements AlunoDao {

	private Connection conn;

	public AlunoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO aluno " + "(NomeAluno, DataCadastro, Situacao, RgAluno, CpfAluno, "
							+ "DataNascimentoAluno, Sexo, NomeRuaAluno, NumeroRuaAluno, "
							+ "BairroAluno, CepAluno, CelularAluno, TelFixoAluno, "
							+ "EmailAluno, EscolaAluno, PeriodoAluno, AnoEscolarAluno, "
							+ "NomeMae, RgMae, CpfMae, CelularMae, NomePai, RgPai, "
							+ "CpfPai, CelularPai, NomeResponsavel, RgResponsavel, CpfResponsavel, "
							+ "CelularResponsavel, EnderecoTrabalho, NumeroTrabalho, CepTrabalho, "
							+ "Moradia, NumeroPessoasNaMoradia, Alergia, AlergiaQual, Deficiencia, "
							+ "DeficienciaQual, Cirurgia, CirurgiaQual, Doenca, DoencaQual, "
							+ "Remedio, RemedioQual, BolsaFamilia, Beneficio, CadastroUnico, "
							+ "NumeroNIS, Encaminha, EncaminhaOutra, DataMatricula, DataExclusao, "
							+ "TurmaRegular, TurmaEspecial, RendaFamiliar )" + " VALUES "

							+ "(?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?,"
							+ "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNomeAluno());
			st.setDate(2, obj.getDataCadastro());
			st.setString(3, obj.getSituacao());
			st.setString(4, obj.getRgAluno());
			st.setString(5, obj.getCpfAluno());
			st.setDate(6, obj.getDataNascimentoAluno());
			st.setString(7, obj.getSexo());
			st.setString(8, obj.getNomeRuaAluno());
			st.setString(9, obj.getNumeroRuaAluno());
			st.setString(10, obj.getBairroAluno());
			st.setString(11, obj.getCepAluno());
			st.setString(12, obj.getCelularAluno());
			st.setString(13, obj.getTelFixoAluno());
			st.setString(14, obj.getEmailAluno());
			st.setString(15, obj.getEscolaAluno());
			st.setString(16, obj.getPeriodoAluno());
			st.setString(17, obj.getAnoEscolarAluno());
			st.setString(18, obj.getNomeMae());
			st.setString(19, obj.getRgMae());
			st.setString(20, obj.getCpfMae());
			st.setString(21, obj.getCelularMae());
			st.setString(22, obj.getNomePai());
			st.setString(23, obj.getRgPai());
			st.setString(24, obj.getCpfPai());
			st.setString(25, obj.getCelularPai());
			st.setString(26, obj.getNomeResponsavel());
			st.setString(27, obj.getRgResponsavel());
			st.setString(28, obj.getCpfResponsavel());
			st.setString(29, obj.getCelularResponsavel());
			st.setString(30, obj.getEnderecoTrabalho());
			st.setString(31, obj.getNumeroTrabalho());
			st.setString(32, obj.getCepTrabalho());
			st.setString(33, obj.getMoradia());
			st.setString(34, obj.getNumeroPessoasNaMoradia());
			st.setString(35, obj.getAlergia());
			st.setString(36, obj.getAlergiaQual());
			st.setString(37, obj.getDeficiencia());
			st.setString(38, obj.getDeficienciaQual());
			st.setString(39, obj.getCirurgia());
			st.setString(40, obj.getCirurgiaQual());
			st.setString(41, obj.getDoenca());
			st.setString(42, obj.getDoencaQual());
			st.setString(43, obj.getRemedio());
			st.setString(44, obj.getRemedioQual());
			st.setString(45, obj.getBolsaFamilia());
			st.setString(46, obj.getBeneficio());
			st.setString(47, obj.getCadastroUnico());
			st.setString(48, obj.getNumeroNIS());
			st.setString(49, obj.getEncaminha());
			st.setString(50, obj.getEncaminhaOutra());
			st.setDate(51, obj.getDataMatricula());
			st.setDate(52, obj.getDataExclusao());
			st.setString(53, obj.getTurmaRegular());
			st.setString(54, obj.getTurmaEspecial());
			st.setString(55, obj.getRendaFamiliar());
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Sucesso no Cadastro!");
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				} else {
					DB.closeResultSet(rs);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Sucesso no Cadastro!");
				throw new DbException("Unexpected error! No rows affected!");

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro, possível CPF já cadastrado!");
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE aluno SET NomeAluno=?, DataCadastro=?, Situacao=?, RgAluno=?, CpfAluno=?, "
							+ "DataNascimentoAluno=?, Sexo=?, NomeRuaAluno=?, NumeroRuaAluno=?, "
							+ "BairroAluno=?, CepAluno=?, CelularAluno=?, TelFixoAluno=?, EmailAluno=?, "
							+ "EscolaAluno=?, PeriodoAluno=?, AnoEscolarAluno=?, NomeMae=?, RgMae=?, "
							+ "CpfMae=?, CelularMae=?, NomePai=?, RgPai=?, CpfPai=?, CelularPai=?, "
							+ "NomeResponsavel=?, RgResponsavel=?, CpfResponsavel=?, CelularResponsavel=?, "
							+ "EnderecoTrabalho=?, NumeroTrabalho=?, CepTrabalho=?, Moradia=?, "
							+ "NumeroPessoasNaMoradia=?, Alergia=?, AlergiaQual=?, Deficiencia=?, "
							+ "DeficienciaQual=?, Cirurgia=?, CirurgiaQual=?, Doenca=?, DoencaQual=?, "
							+ "Remedio=?, RemedioQual=?, BolsaFamilia=?, Beneficio=?, CadastroUnico=?, "
							+ "NumeroNIS=?, Encaminha=?, EncaminhaOutra=?, "
							+ "DataMatricula=?, DataExclusao=?, TurmaRegular=? ,TurmaEspecial=? , RendaFamiliar=? "
							+ "WHERE id=? ");

			st.setString(1, obj.getNomeAluno());
			st.setDate(2, obj.getDataCadastro());
			st.setString(3, obj.getSituacao());
			st.setString(4, obj.getRgAluno());
			st.setString(5, obj.getCpfAluno());
			st.setDate(6, obj.getDataNascimentoAluno());
			st.setString(7, obj.getSexo());
			st.setString(8, obj.getNomeRuaAluno());
			st.setString(9, obj.getNumeroRuaAluno());
			st.setString(10, obj.getBairroAluno());
			st.setString(11, obj.getCepAluno());
			st.setString(12, obj.getCelularAluno());
			st.setString(13, obj.getTelFixoAluno());
			st.setString(14, obj.getEmailAluno());
			st.setString(15, obj.getEscolaAluno());
			st.setString(16, obj.getPeriodoAluno());
			st.setString(17, obj.getAnoEscolarAluno());
			st.setString(18, obj.getNomeMae());
			st.setString(19, obj.getRgMae());
			st.setString(20, obj.getCpfMae());
			st.setString(21, obj.getCelularMae());
			st.setString(22, obj.getNomePai());
			st.setString(23, obj.getRgPai());
			st.setString(24, obj.getCpfPai());
			st.setString(25, obj.getCelularPai());
			st.setString(26, obj.getNomeResponsavel());
			st.setString(27, obj.getRgResponsavel());
			st.setString(28, obj.getCpfResponsavel());
			st.setString(29, obj.getCelularResponsavel());
			st.setString(30, obj.getEnderecoTrabalho());
			st.setString(31, obj.getNumeroTrabalho());
			st.setString(32, obj.getCepTrabalho());
			st.setString(33, obj.getMoradia());
			st.setString(34, obj.getNumeroPessoasNaMoradia());
			st.setString(35, obj.getAlergia());
			st.setString(36, obj.getAlergiaQual());
			st.setString(37, obj.getDeficiencia());
			st.setString(38, obj.getDeficienciaQual());
			st.setString(39, obj.getCirurgia());
			st.setString(40, obj.getCirurgiaQual());
			st.setString(41, obj.getDoenca());
			st.setString(42, obj.getDoencaQual());
			st.setString(43, obj.getRemedio());
			st.setString(44, obj.getRemedioQual());
			st.setString(45, obj.getBolsaFamilia());
			st.setString(46, obj.getBeneficio());
			st.setString(47, obj.getCadastroUnico());
			st.setString(48, obj.getNumeroNIS());
			st.setString(49, obj.getEncaminha());
			st.setString(50, obj.getEncaminhaOutra());
			st.setDate(51, obj.getDataMatricula());
			st.setDate(52, obj.getDataExclusao());
			st.setString(53, obj.getTurmaRegular());
			st.setString(54, obj.getTurmaEspecial());
			st.setString(55, obj.getRendaFamiliar());
			st.setInt(56, obj.getId());

			st.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algo deu errado, atualize  os campos!");
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		JOptionPane.showMessageDialog(null, "Sucesso na Atualização!");
	}

	@Override
	public void deleteByCpf(String cpf) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM aluno WHERE cpfAluno= ?");
			st.setString(1, cpf);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Sucesso na Remoção do Aluno!");
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Aluno findByCpf(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM gestaoescolar.aluno WHERE aluno.CpfAluno= ?");
			st.setString(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				Aluno obj = new Aluno();
				obj.setId(rs.getInt("id"));
				obj.setNomeAluno(rs.getString("NomeAluno"));
				obj.setDataCadastro(rs.getDate("DataCadastro"));
				obj.setSituacao(rs.getString("Situacao"));
				obj.setRgAluno(rs.getString("RgAluno"));
				obj.setCpfAluno(rs.getString("CpfAluno"));
				obj.setDataNascimentoAluno(rs.getDate("DataNascimentoAluno"));
				obj.setSexo(rs.getString("Sexo"));
				obj.setNomeRuaAluno(rs.getString("NomeRuaAluno"));
				obj.setNumeroRuaAluno(rs.getString("NumeroRuaAluno"));
				obj.setBairroAluno(rs.getString("BairroAluno"));
				obj.setCepAluno(rs.getString("CepAluno"));
				obj.setCelularAluno(rs.getString("CelularAluno"));
				obj.setTelFixoAluno(rs.getString("TelFixoAluno"));
				obj.setEmailAluno(rs.getString("EmailAluno"));
				obj.setEscolaAluno(rs.getString("EscolaAluno"));
				obj.setPeriodoAluno(rs.getString("PeriodoAluno"));
				obj.setAnoEscolarAluno(rs.getString("AnoEscolarAluno"));
				obj.setNomeMae(rs.getString("NomeMae"));
				obj.setRgMae(rs.getString("RgMae"));
				obj.setCpfMae(rs.getString("CpfMae"));
				obj.setCelularMae(rs.getString("CelularMae"));
				obj.setNomePai(rs.getString("NomePai"));
				obj.setRgPai(rs.getString("RgPai"));
				obj.setCpfPai(rs.getString("CpfPai"));
				obj.setCelularPai(rs.getString("CelularPai"));
				obj.setNomeResponsavel(rs.getString("NomeResponsavel"));
				obj.setRgResponsavel(rs.getString("RgResponsavel"));
				obj.setCpfResponsavel(rs.getString("CpfResponsavel"));
				obj.setCelularResponsavel(rs.getString("CelularResponsavel"));
				obj.setEnderecoTrabalho(rs.getString("EnderecoTrabalho"));
				obj.setNumeroTrabalho(rs.getString("NumeroTrabalho"));
				obj.setCepTrabalho(rs.getString("CepTrabalho"));
				obj.setMoradia(rs.getString("Moradia"));
				obj.setNumeroPessoasNaMoradia(rs.getString("NumeroPessoasNaMoradia"));
				obj.setAlergia(rs.getString("Alergia"));
				obj.setAlergiaQual(rs.getString("AlergiaQual"));
				obj.setDeficiencia(rs.getString("Deficiencia"));
				obj.setDeficienciaQual(rs.getString("DeficienciaQual"));
				obj.setCirurgia(rs.getString("Cirurgia"));
				obj.setCirurgiaQual(rs.getString("CirurgiaQual"));
				obj.setDoenca(rs.getString("Doenca"));
				obj.setDoencaQual(rs.getString("DoencaQual"));
				obj.setRemedio(rs.getString("Remedio"));
				obj.setRemedioQual(rs.getString("RemedioQual"));
				obj.setBolsaFamilia(rs.getString("BolsaFamilia"));
				obj.setBeneficio(rs.getString("Beneficio"));
				obj.setCadastroUnico(rs.getString("CadastroUnico"));
				obj.setNumeroNIS(rs.getString("NumeroNIS"));
				obj.setEncaminha(rs.getString("Encaminha"));
				obj.setEncaminhaOutra(rs.getString("EncaminhaOutra"));
				obj.setDataMatricula(rs.getDate("DataMatricula"));
				obj.setDataExclusao(rs.getDate("DataExclusao"));
				obj.setTurmaEspecial(rs.getString("TurmaEspecial"));
				obj.setTurmaRegular(rs.getString("TurmaRegular"));
				obj.setRendaFamiliar(rs.getString("RendaFamiliar"));
				return obj;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Aluno> findByMatriculado(Aluno aluno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Aluno findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findByAluno(Aluno aluno) {
		// TODO Auto-generated method stub
		return null;
	}

}
