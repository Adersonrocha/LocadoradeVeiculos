package br.com.LocadoraVeiculo.noca.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contrato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	

	private Long agenciaId;	
	
	
	private Long clienteid;
	
	private Long numeroContrato;
	
	private Long qtdedias;
	
	private Long veiculoId;
	
	private Double valortotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgenciaId() {
		return agenciaId;
	}

	public void setAgenciaId(Agencia agenciaId) {
		this.agenciaId = agenciaId.getId();
	}

	public Long getClienteid() {
		return clienteid;
	}

	public void setClienteid(Cliente clienteid) {
		this.clienteid = clienteid.getId();
	}

	public Long getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Long getQtdedias() {
		return qtdedias ;
	}

	public void setQtdedias(Long qtdedias) {
		this.qtdedias = qtdedias;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Veiculo veiculoId) {
		this.veiculoId = veiculoId.getId();
	}

	public Double getValortotal() {
		return valortotal = (double) (qtdedias * 50);
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}
	
	
	
}
