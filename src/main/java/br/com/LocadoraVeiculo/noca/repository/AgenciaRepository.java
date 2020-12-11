package br.com.LocadoraVeiculo.noca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.LocadoraVeiculo.noca.model.Agencia;

@Repository
@Transactional
public interface AgenciaRepository extends CrudRepository<Agencia,Long>{

}
