package com.ude.logica;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ude.visualObjects.VONave;

public class Partida 
{
	private int codP;
	private Date fecha;
	private String estado;
	private String ganador;
	private List<nave> naves;
	
	public Partida(int codP) {
		this.codP = codP;
		long now = System.currentTimeMillis();
		this.fecha = new Date(now);
		this.estado = "Iniciada";
		this.ganador = "S/N";
		naves = new ArrayList<>();
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
		if(N != null)
		{
			for(nave nav: N)
			{
				//System.out.println(nav);
				this.naves.add(nav);
			}
		}
		else
		{
			System.out.println("La lista de naves esta vacia");
		}
		
	}
	
	public List<nave> getNaves(){
		return this.naves;
	}
	

}
