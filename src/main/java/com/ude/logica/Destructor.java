package com.ude.logica;

import java.util.List;

public class Destructor extends nave
{
	private int codNave;
	private String clase;
	private List<Armamento> armas;
	
	public Destructor(int codP, float posX, float posY)
	{
		super(codP, posX, posY);
		this.codNave = 1;
		this.clase = "Fletcher";		
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
