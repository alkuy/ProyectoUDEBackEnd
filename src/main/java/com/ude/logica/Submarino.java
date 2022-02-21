package com.ude.logica;

import java.util.List;

public class Submarino extends nave
{
	private int codNave;
	private String clase;
	private List<Armamento> armas;
	
	public Submarino (int codP, float posX, float posY)
	{
		super(codP, posX, posY);
		this.codNave = 2;
		this.clase = "UBoat";		
	}

	public int getcodNave() {
		return this.codNave;
	}

	public void setCodNave(int codNave) {
		this.codNave = codNave;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public List<Armamento> getArmas() {
		return armas;
	}

	public void setArmas(List<Armamento> armas) {
		this.armas = armas;
	}
	
}
