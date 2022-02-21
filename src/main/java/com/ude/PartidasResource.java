package com.ude;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ude.logica.Armamento;
import com.ude.logica.Partida;
import com.ude.logica.party;
import com.ude.persistencia.DAOPartidas;

@RestController
public class PartidasResource 
{
	@GetMapping("Partidas")
	public List<Partida> getPartidas() throws ClassNotFoundException
	{
		DAOPartidas daoP = new DAOPartidas();	
		return daoP.listarPartidas();
	}
	
	@PostMapping("Partidas")
	public Partida iniciarPartida(@RequestBody Partida P) throws ClassNotFoundException 
	{
		DAOPartidas daoP = new DAOPartidas();
		daoP.insBack(P);
		System.out.println("la partida fue creada con exito");
		return P;
	}
	
}
