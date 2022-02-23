package com.ude.logica;

import java.util.ArrayList;
import java.util.List;

import com.ude.visualObjects.VONave;

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

	public void setArmas(int codP, List<Armamento> armas) {
		List<Armamento> arm = new ArrayList<>();
		Armamento arma;
		for(Armamento ar: armas)
		{
			switch(ar.getNombre())
			{
				case "cañonSub":
					arma = new Armamento (codP, this.codNave, 0, ar.getMunicion());
					arm.add(arma);
					break;
				case "torpedo":
					arma = new Armamento (codP, this.codNave, 3, ar.getMunicion());
					arm.add(arma);
					break;
				default:
					break;
			}
			
		}
		
		this.armas = arm;
	}
	
}
