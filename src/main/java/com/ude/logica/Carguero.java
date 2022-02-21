package com.ude.logica;

public class Carguero extends nave
{
	private int codNave;
	private String clase;
	
	public Carguero (int codP, float posX, float posY)
	{
		super(codP, posX, posY);
		this.codNave = 0;
		this.clase = "Liberty";
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


}
