package com.ude.logica;

import java.util.ArrayList;
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

	public void setArmas(int codP, List<Armamento> armas) {
		List<Armamento> arm = new ArrayList<>();
		Armamento arma;
		for(Armamento ar: armas)
		{
			switch(ar.getNombre())
			{
				case "cañonDes":
					arma = new Armamento (codP, this.codNave, 1, ar.getMunicion());
					arm.add(arma);
					break;
				case "carga":
					arma = new Armamento (codP, this.codNave, 2, ar.getMunicion());
					arm.add(arma);
					break;
				default:
					break;
			}
			
		}
		
		this.armas = arm;
	}
	
}
