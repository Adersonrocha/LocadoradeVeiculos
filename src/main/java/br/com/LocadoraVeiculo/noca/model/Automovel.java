package br.com.LocadoraVeiculo.noca.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Automovel extends Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	
	
	private  boolean ar;
	
	private boolean vidro;
	
	private boolean gps;
	
	private boolean roteador;

	public boolean isRoteador() {
		return roteador;
	}

	public void setRoteador(boolean roteador) {
		this.roteador = roteador;
	}

	public boolean isGps() {
		return gps;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}

	public boolean isVidro() {
		return vidro;
	}

	public void setVidro(boolean vidro) {
		this.vidro = vidro;
	}

	public boolean isAr() {
		return ar;
	}

	public void setAr(boolean ar) {
		this.ar = ar;
	}
	
	
	
}
