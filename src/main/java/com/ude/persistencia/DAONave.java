package com.ude.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.beans.factory.annotation.Value;

import com.ude.logica.Armamento;
import com.ude.logica.Carguero;
import com.ude.logica.Destructor;
import com.ude.logica.Submarino;
import com.ude.logica.nave;

public class DAONave 
{
	@Value("${driver}")
	private String driver = "com.mysql.cj.jdbc.Driver";
	@Value("${url}")
	private String url = "jdbc:mysql://localhost:3306/BPA?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	@Value("${usuario}")
	private String user = "root";
	@Value("${password}")
	private String password  = "root";
	private DAOArmamentos daoA = new DAOArmamentos();
	
	public DAONave () throws ClassNotFoundException 
	{
		Class.forName(driver);
	}
	
	public boolean esVacia (int codP) 
	{
		int cant = 0;
		boolean esV = true;
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			
			String select1 = "Select * from nave where codP = ?;";
			PreparedStatement pstmt = con.prepareStatement(select1);		
			pstmt.setInt(1, codP);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				cant++;
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(cant > 0)
			esV = false;
		
		return esV;
	}
	
	public int Largo(int codP) 
	{
		int cant = 0;
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select1 = "Select * from nave where codP = ?;";
			PreparedStatement pstmt = con.prepareStatement(select1);		
			pstmt.setInt(1, codP);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				cant++;
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return cant;
	}
	
	public void insBack (nave N) 
	{
		int codP = N.getCodP();
		int codNave = N.getCodNave();
		String clase;
		int vida = N.getVida();
		float posX = N.getPosX();
		float posY = N.getPosY();
		List<Armamento> armas;
		String insert;
		
		if(codNave == 1)
		{
			clase = "Fletcher";
		}
		else if (codNave == 2)
		{
			clase = "UBoat";
		}
		else
			clase = "Liberty";
					
		insert = "insert into nave (codP, codNave, clase, vida, posX, posY) values (?,?,?,?,?,?);";			
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			PreparedStatement pstmt = con.prepareStatement(insert);
			
			pstmt.setInt(1, codP);
			pstmt.setInt(2, codNave);
			pstmt.setString(3, clase);
			pstmt.setInt(4, vida);
			pstmt.setFloat(5, posX);
			pstmt.setFloat(6, posY);
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			if(codNave == 1)
			{
				armas = ((Destructor) N).getArmas();
				for(Armamento arm: armas)
				{
					this.daoA.insBack(arm);
				}
			}
			else if (codNave == 2)
			{
				armas = ((Submarino) N).getArmas();
				for(Armamento arm: armas)
				{
					this.daoA.insBack(arm);
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public int carguerosRestante(int codP)
	{
		int cargRest = 0;
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select = "Select * from nave where codP = ? and codNave = ?;";
			PreparedStatement pstmt = con.prepareStatement(select);		
			pstmt.setInt(1, codP);
			pstmt.setInt(2, 0);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				if(rs.getInt("vida")>0)
					cargRest++;
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return cargRest;
	}
	
	public List<nave> listarNaves(int codP)
	{
		List<nave> naves = new ArrayList<>();
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select1 = "Select * from nave where codP = ?;";
			PreparedStatement pstmt = con.prepareStatement(select1);		
			pstmt.setInt(1, codP);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				if(rs.getInt("codNave") == 0)
				{
					Carguero ca = new Carguero(codP,rs.getFloat("posX"),rs.getFloat("posY"));
					naves.add(ca);
				}
				else if (rs.getInt("codNave") == 1)
				{
					Destructor de = new Destructor(codP,rs.getFloat("posX"),rs.getFloat("posY"));
					de.setArmas(this.daoA.listarArmas(codP, rs.getInt("codNave")));
					naves.add(de);
				}
				else
				{
					Submarino su = new Submarino(codP,rs.getFloat("posX"),rs.getFloat("posY"));
					su.setArmas(this.daoA.listarArmas(codP, rs.getInt("codNave")));
					naves.add(su);
				}
			}
						
			rs.close();
			pstmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return naves;
	}
}
