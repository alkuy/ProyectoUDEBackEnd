package com.ude.logica;

public class Armamento {

	private int codP;
	private int codNave;
	private String nombre;
	private String calibre;
	private String desc;
	private int municion;
	
	public Armamento (int codP, int codNave,int tipo) {
		this.codP = codP;
		this.codNave = codNave;
		switch(tipo)
		{
			case 0:
				this.nombre = "cañonSub";
				this.calibre = "105mm";
				this.desc = "Cañones de cubierta automaticos";
				this.municion = 16;
				break;
			case 1:
				this.nombre = "cañonDes";
				this.calibre = "127mm";
				this.desc = "Cañones de cubierta automaticos";
				this.municion = 30;
				break;
			case 2:
				this.nombre = "carga";
				this.calibre = "S/N";
				this.desc = "Cargas de profundidad para destruir submarinos";
				this.municion = 10;
				break;
			case 3:
				this.nombre = "torpedo";
				this.calibre = "S/N";
				this.desc = "Torpedos submarinos para objetivos maritimos";
				this.municion = 10;
				break;
			default:
				break;
		}
	}
	
	public int getCod() {
		return codP;
	}
	
	public int getCodNave() {
		return codNave;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCod(int cod) {
		this.codP = cod;
	}
	
	public void setCodNave(int codNave) {
		this.codNave = codNave;
	}
	
	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getMunicion() {
		return municion;
	}

	public void setMunicion(int municion) {
		this.municion = municion;
	}
	
	
}
