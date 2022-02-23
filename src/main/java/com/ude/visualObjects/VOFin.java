package com.ude.visualObjects;

public class VOFin {

	private int codP;
	private String ganador;
	
	public VOFin (int codP, String ganador) {
		this.codP = codP;
		this.ganador = ganador;
	}

	public int getCodP() {
		return codP;
	}

	public void setCodP(int codP) {
		this.codP = codP;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	
	
}
