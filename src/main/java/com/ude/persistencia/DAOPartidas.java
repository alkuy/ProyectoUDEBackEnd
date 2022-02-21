package com.ude.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.ude.logica.Armamento;
import com.ude.logica.Carguero;
import com.ude.logica.Partida;
import com.ude.logica.VONave;
import com.ude.logica.nave;

public class DAOPartidas {
	
	@Value("${driver}")
	private String driver = "com.mysql.cj.jdbc.Driver";
	@Value("${url}")
	private String url = "jdbc:mysql://localhost:3306/BPA?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	@Value("${usuario}")
	private String user = "root";
	@Value("${password}")
	private String password  = "root";
	private DAONave daoN;
	
	public DAOPartidas() throws ClassNotFoundException {
		daoN = new DAONave();
		Class.forName(driver);
	}
	
	public boolean esVacia () 
	{
		int cant = 0;
		boolean esV = true;
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select = "Select * from partidas order by codigo;";
			Statement stmt = con.createStatement();			
			ResultSet rs = stmt.executeQuery(select);
			
			while (rs.next()) 
			{
				cant++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(cant > 0)
			esV = false;
		
		return esV;
	}
	
	public int Largo() 
	{
		int cant = 0;
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select = "Select * from partidas order by codigo;";
			Statement stmt = con.createStatement();			
			ResultSet rs = stmt.executeQuery(select);
			
			while (rs.next()) 
			{
				cant++;
			}
			
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return cant;
	}
	
	
	public void insBack (Partida P) 
	{
		List<nave> naves;
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insert = "insert into partida values (?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(insert);
			
			pstmt.setInt(1, P.getCodPartida());
			pstmt.setDate(2, P.getFecha());
			pstmt.setString(3, P.getGanador());
			pstmt.setString(4, P.getEstado());
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			naves = P.getNaves();
			for(nave nav: naves)
			{
				this.daoN.insBack(nav);
			}
			
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Partida kesimo(int codP)
	{
		Partida P = null;
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insert = "slect * from partida where codP = ?);";
			PreparedStatement pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, codP);
			ResultSet rs = pstmt.executeQuery();
			List<VONave> voN = new ArrayList<>();
			if (rs.next()) 
			{
				P = new Partida(codP,voN);
				P.setGanador(rs.getString("ganador"));
				P.setFecha(rs.getDate("fecha"));
				P.setEstado(rs.getString("estado"));
				P.setNaves(this.daoN.listarNaves(codP));
			}
			
			pstmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return P;
	}
	
	public List<Partida> listarPartidas(){
		List<Partida> partidas = new ArrayList<>();
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select = "Select * from partida order by codP;";
			Statement stmt = con.createStatement();			
			ResultSet rs = stmt.executeQuery(select);
			List<VONave> voN = new ArrayList<>();
			while (rs.next()) 
			{
				Partida P = new Partida(rs.getInt("codP"),voN);
				P.setGanador(rs.getString("ganador"));
				P.setFecha(rs.getDate("fecha"));
				P.setEstado(rs.getString("estado"));
				P.setNaves(this.daoN.listarNaves(rs.getInt("codP")));
				
				partidas.add(P);
			}
			
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return partidas;
	}

}
