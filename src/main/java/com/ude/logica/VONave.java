package com.ude.logica;

import java.util.List;

public class VONave 
{
	private int codP;
	private int vida;
	private float posX;
	private float posY;
	private int codNave;
	private String clase;
	private List<Armamento> armas;
	
	public VONave (int codP, float posX, float posY, int codNave, String clase, List<Armamento> armas)
	{
		this.codP = codP;
		this.vida = 100;
		this.posX = posX;
		this.posY = posY;
		this.codNave = codNave;
		this.clase = clase;
		if (armas != null) {
			//System.out.println("not null");
			this.armas = armas;
		}
		//else
			//System.out.println("null");
			
	}

	public int getCodP() {
		return codP;
	}

	public void setCodP(int codP) {
		this.codP = codP;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
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
