package com.ude.logica;

public class nave 
{
	private int codP;
	private int vida;
	private float posX;
	private float posY;
	
	public nave (int codP, float posX, float posY)
	{
		this.codP = codP;
		this.vida = 100;
		this.posX = posX;
		this.posY = posY;		
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
	
	public int getCodNave() {
		return 3;
	}

	@Override
	public String toString() {
		return "nave [codP=" + codP + ", vida=" + vida + ", posX=" + posX + ", posY=" + posY + "]";
	}
	
	

}
