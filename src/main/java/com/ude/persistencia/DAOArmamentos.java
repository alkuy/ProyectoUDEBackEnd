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
import com.ude.logica.Partida;

public class DAOArmamentos {
	
	@Value("${driver}")
	private String driver = "com.mysql.cj.jdbc.Driver";
	@Value("${url}")
	private String url = "jdbc:mysql://localhost:3306/BPA?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	@Value("${usuario}")
	private String user = "root";
	@Value("${password}")
	private String password  = "root";
	
	public DAOArmamentos () throws ClassNotFoundException 
	{
		Class.forName(driver);
	}
	
	public boolean esVacia () 
	{
		int cant = 0;
		boolean esV = true;
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select = "Select * from armamento order by codPartida;";
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
			String select = "Select * from armamento order by codPartida;";
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
	
	/**Precondicion el largo de la secuancia es menor que TAM (Tope <= 1)**/
	public void insBack (Armamento A) 
	{
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insert = "insert into armamento values (?,?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(insert);
			
			pstmt.setInt(1, A.getCod());
			pstmt.setInt(2, A.getCodNave());
			pstmt.setString(3, A.getNombre());
			pstmt.setString(4, A.getCalibre());
			pstmt.setString(5, A.getDesc());
			pstmt.setInt(6, A.getMunicion());
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//Metodo que devuelve la cantidad de municion restante de un armamento dado
	/**Precondicion el armamento debe existir**/
	public int muniRest(int codP, int codNave, String nomArm)
	{
		
		int municion = 0;
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select = "Select municion from armamento where codPartida = ? and codNave = ? and nombre = ?";
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(select);
			
			pstmt.setInt(1, codP);
			pstmt.setInt(2, codNave);
			pstmt.setString(3, nomArm);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				municion = rs.getInt("municion");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}			
	
		return municion;
	}
	
	public List<Armamento> listarArmas(int codP, int codNave)
	{
		List<Armamento> armas = new ArrayList<>();
		Armamento arm;
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String select = "Select * from armamento where codPartida = ? and codNave = ?";
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(select);
			
			pstmt.setInt(1, codP);
			pstmt.setInt(2, codNave);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) 
			{
				String nombre = rs.getString("nombre");
				if(nombre.equals("cañonSub"))
					arm = new Armamento(codP,codNave,0, 16);
				else if(nombre.equals("cañonDes"))
					arm = new Armamento(codP,codNave,1, 30);
				else if(nombre.equals("carga"))
					arm = new Armamento(codP,codNave,2, 10);
				else
					arm = new Armamento(codP,codNave,3, 10);
				armas.add(arm);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return armas;		
	}
	
	public void updateArmamento(int codP, Armamento arm)
	{
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			String update = "update armamento set municion = ? where codPartida = ? and nombre = ?;";
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(update);
			System.out.println(arm.getMunicion());
			pstmt.setInt(1, arm.getMunicion());
			pstmt.setInt(2, codP);
			pstmt.setString(3, arm.getNombre());
			
			pstmt.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}			
	}
}
