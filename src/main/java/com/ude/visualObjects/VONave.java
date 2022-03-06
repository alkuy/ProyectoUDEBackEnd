package com.ude.visualObjects;

import java.util.List;

import com.ude.logica.Armamento;
import com.ude.persistencia.DAOPartidas;

public class VONave 
{
	private int codP;
	private int vida;
	private float posX;
	private float posY;
	private int codNave;
	private String clase;
	private List<Armamento> armas;
	
	public VONave (int codP, int vida,  float posX, float posY, int codNave, String clase, List<Armamento> armas) throws ClassNotFoundException
	{
		this.codP = codP;
		this.vida = vida;
		this.posX = posX;
		this.posY = posY;
		this.codNave = codNave;
		this.clase = clase;
		
		DAOPartidas daoP = new DAOPartidas();
		int largo = daoP.Largo();
		int codPartida = largo+1;
		
		if (armas != null) {
			this.armas = armas;
			for (Armamento arm: armas)
			{
				arm.setCod(codPartida);
			}
		}
		
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
