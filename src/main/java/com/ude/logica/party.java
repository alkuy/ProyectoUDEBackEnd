package com.ude.logica;

import java.util.Date;
import java.util.List;

public class party {
	
	private int codP;
	private Date fecha;
	private String estado;
	private String ganador;
	private List<String> Nombres;
	
	public party() {
		/*this.codP = codP;
		this.fecha = new Date();
		this.estado = "Iniciada";
		this.ganador = "S/N";
		this.Nombres = nombres;*/
	}
	
	public int getCodP() {
		return codP;
	}
	public void setCodP(int codP) {
		this.codP = codP;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getGanador() {
		return ganador;
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public List<String> getNombres() {
		return Nombres;
	}

	public void setNombres(List<String> nombres) {
		Nombres = nombres;
	}

	@Override
	public String toString() {
		return "party [codP=" + codP + ", fecha=" + fecha + ", estado=" + estado + ", ganador=" + ganador + ", Nombres="
				+ Nombres + "]";
	}
	

}
