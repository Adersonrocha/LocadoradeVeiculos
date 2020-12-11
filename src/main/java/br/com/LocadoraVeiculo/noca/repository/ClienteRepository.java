package br.com.LocadoraVeiculo.noca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.LocadoraVeiculo.noca.model.Cliente;

@Repository
@Transactional
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
