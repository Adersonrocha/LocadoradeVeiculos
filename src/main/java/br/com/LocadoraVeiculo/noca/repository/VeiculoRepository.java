package br.com.LocadoraVeiculo.noca.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.LocadoraVeiculo.noca.model.Automovel;


@Repository
@Transactional
public interface VeiculoRepository extends CrudRepository<Automovel, Long>  {

	
	@Query(value = "select * from Automovel AS b where b.disponivel = ?1", nativeQuery = true)
	public List<Automovel> listaVeiculosStatus(boolean status);
}
