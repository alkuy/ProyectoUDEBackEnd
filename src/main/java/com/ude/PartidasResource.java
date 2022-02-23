package com.ude;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ude.logica.Armamento;
import com.ude.logica.Carguero;
import com.ude.logica.Destructor;
import com.ude.logica.Partida;
import com.ude.logica.Submarino;
import com.ude.logica.nave;
import com.ude.logica.party;
import com.ude.persistencia.DAOPartidas;
import com.ude.visualObjects.VOFin;
import com.ude.visualObjects.VONave;
import com.ude.visualObjects.VOPartida;

@RestController
public class PartidasResource 
{
	@GetMapping("getPartidas")
	public List<Partida> getPartidas() throws ClassNotFoundException
	{
		DAOPartidas daoP = new DAOPartidas();	
		return daoP.listarPartidas();
	}
	
	@GetMapping("getPartidas/{codP}")
	public Partida getPartida(@PathVariable("codP") int codP) throws ClassNotFoundException 
	{
		DAOPartidas daoP = new DAOPartidas();	
		return daoP.kesimo(codP);
	}
	
	@PostMapping("iniciarPartida")
	public void iniciarPartida(@RequestBody VOPartida P) throws ClassNotFoundException 
	{
		DAOPartidas daoP = new DAOPartidas();
		int largo = daoP.Largo();
		int codP = largo+1;
		List<nave> naves = new ArrayList<>();
		if(!P.getNaves().isEmpty())
		{
			
			for(nave nav: P.getNaves())
			{
				
				if(nav instanceof Carguero)
				{
					
						Carguero ca = new Carguero(codP,nav.getPosX(),nav.getPosY());
						naves.add(ca);
				}
				else if(nav instanceof Destructor)
				{
						Destructor de = new Destructor(codP,nav.getPosX(),nav.getPosY());
						de.setArmas(codP, ((Destructor) nav).getArmas());
						naves.add(de);
				}
				else if(nav instanceof Submarino)
				{
						Submarino su = new Submarino(codP,nav.getPosX(),nav.getPosY());
						su.setArmas(codP, ((Submarino) nav).getArmas());
						naves.add(su);
				}
				
			}
		}

		Partida pa = new Partida(codP);
		pa.setNaves(naves);
		daoP.insBack(pa);
		System.out.println("la partida fue creada con exito");
	}
	
	@PostMapping("guardarPartida")
	public String guardarPartida(@RequestBody VOPartida P) throws ClassNotFoundException {
		
		DAOPartidas daoP = new DAOPartidas();
		daoP.updatePartida(P);
		return "Partida guardada con exito";
	}
	
	@PostMapping("finalizarPartida")
	public String finalizarPartida(@RequestBody VOFin F) throws ClassNotFoundException {
		DAOPartidas daoP = new DAOPartidas();
		daoP.finalizarPartida(F.getCodP(), F.getGanador());
		return "Partida finalizada";
	}
	
}
