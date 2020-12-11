package br.com.LocadoraVeiculo.noca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.LocadoraVeiculo.noca.model.Funcionario;

@Repository
@Transactional
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}
