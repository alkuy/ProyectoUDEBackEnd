package com.ude.visualObjects;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ude.logica.Armamento;
import com.ude.logica.Carguero;
import com.ude.logica.Destructor;
import com.ude.logica.Submarino;
import com.ude.logica.nave;

public class VOPartidaSave {

	private int codP;
	private Date fecha;
	private String estado;
	private String ganador;
	private List<nave> naves;
	
	public VOPartidaSave(int codP, List<VONave> naves) {
		this.codP = codP;
		long now = System.currentTimeMillis();
		this.fecha = new Date(now);
		this.estado = "Pausada";
		this.ganador = "S/N";
		int i;
		this.naves = new ArrayList<>();
		if(!naves.isEmpty())
		{
			for(VONave nav: naves)
			{
				switch(nav.getcodNave())
				{
					case 0:
						Carguero ca = new Carguero(nav.getCodP(),nav.getPosX(),nav.getPosY());
						ca.setVida(nav.getVida());
						this.naves.add(ca);
						break;
					case 1:
						Destructor de = new Destructor(nav.getCodP(),nav.getPosX(),nav.getPosY());
						de.setArmas(codP, nav.getArmas());
						this.naves.add(de);
						break;
					case 2:
						Submarino su = new Submarino(nav.getCodP(),nav.getPosX(),nav.getPosY());
						su.setArmas(codP, nav.getArmas());
						i = 0;
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
