package com.ude.logica;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Partida 
{
	private int codP;
	private Date fecha;
	private String estado;
	private String ganador;
	private List<nave> naves;
	
	public Partida(int codP, List<VONave> naves) {
		this.codP = codP;
		long now = System.currentTimeMillis();
		this.fecha = new Date(now);
		this.estado = "Iniciada";
		this.ganador = "S/N";
		
		this.naves = new ArrayList<>();
		if(!naves.isEmpty())
		{
			for(VONave nav: naves)
			{
				switch(nav.getcodNave())
				{
					case 0:
						Carguero ca = new Carguero(nav.getCodP(),nav.getPosX(),nav.getPosY());
						this.naves.add(ca);
						break;
					case 1:
						Destructor de = new Destructor(nav.getCodP(),nav.getPosX(),nav.getPosY());
						de.setArmas(nav.getArmas());
						this.naves.add(de);
						break;
					case 2:
						Submarino su = new Submarino(nav.getCodP(),nav.getPosX(),nav.getPosY());
						su.setArmas(nav.getArmas());
						this.naves.add(su);
						break;
				}
			}
		}
		
		
	}
	
	public int getCodPartida() {
		return this.codP;
	}
	
	public void setCodPartida(int codP) {
		this.codP = codP;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getGanador() {
		return this.ganador;
	}
	
	public void setEstado(String est) {
		this.estado = est;
	}
	
	public void setGanador(String gan) {
		this.ganador = gan;
	}
	
	public void setNaves(List<nave> N)
	{
		naves = N;
	}
	
	public List<nave> getNaves(){
		return this.naves;
	}
	

}
