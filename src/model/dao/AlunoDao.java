/*
 * 
 * Para cada entidade, haverá um objeto responsável por fazer acesso a dados relacionado a esta
   entidade. Por exemplo:
   
		o Aluno: AlunoDao
		o Produto: ProdutoDao
		o Pedido: PedidoDao

  Cada DAO será definido por uma interface.
  
 A injeção de dependência pode ser feita por meio do padrão de projeto Factory
*
* 
*
*/
package model.dao;

import java.util.List;

import model.entities.Aluno;

public interface AlunoDao {

	void insert(Aluno obj);
	void update(Aluno obj);
	void deleteById(Integer id);
	Aluno findById(Integer id);
	Aluno findByCpf(String cpf);
	List<Aluno> findAll();
	List<Aluno> findByAluno(Aluno aluno);
	List<Aluno> findByMatriculado(Aluno aluno);
	void deleteByCpf(String cpf);
}
