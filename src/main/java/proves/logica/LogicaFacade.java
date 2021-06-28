package proves.logica;

import java.sql.*;
import java.util.*;

import proves.connexio.Connexio;
import proves.objectes.Usuari;

public class LogicaFacade {
	
	public LogicaFacade() {
	}

	public String valida(String user, String pwd, Usuari usr) {
		Connection conn = null;
		String error = "";
		try {
			conn = new Connexio().connecta();
			String sql = "select rol from usuari where nomUsuari=? and contrasenya=?";
			PreparedStatement ordre = conn.prepareStatement(sql);
            ordre.setString(1, user);
            ordre.setString(2, pwd);
			ResultSet rs = ordre.executeQuery();
			if(rs.next()) {
				usr.setRol(rs.getString("rol"));
			}else {error="Credencials no vàlides";}
			rs.close();
			ordre.close();
			conn.close();
		} catch(Exception e) {e.printStackTrace();}
		// Seguro per tancar la connexió
		if (conn!=null){
			try {
				conn.close();
			} catch (Exception e){}
		}
		return error;
	}

	public List<String> getPlayers() throws SQLException {
		
		List<String> players = new ArrayList<String>();
		
		Connection connection = new Connexio().connecta();
		String sql = "select nom,nickname,equip from player";
		Statement ordre = connection.createStatement();
		ResultSet rs = ordre.executeQuery(sql);
		
		while(rs.next()) {
			players.add(rs.getString(1)+";"+rs.getString(2)
			+";"+rs.getString(3));
		}
		rs.close();
		ordre.close();
		connection.close();
		return players;

	}
	
	public List<String> getTeams() throws SQLException {
		
		List<String> teams = new ArrayList<String>();
		
		Connection connection = new Connexio().connecta();
		String sql = "select nom from team";
		Statement ordre = connection.createStatement();
		ResultSet rs = ordre.executeQuery(sql);
		
		while(rs.next()) {
			teams.add(rs.getString(1));
		}
		rs.close();
		ordre.close();
		connection.close();
		return teams;

	}
	
	public String getTeamFromPlayer(String nickname) throws SQLException {
		
		String team = "";
		
		Connection connection = new Connexio().connecta();
		String sql = "select equip from player where nickname='"+nickname+"'";
		Statement ordre = connection.createStatement();
		ResultSet rs = ordre.executeQuery(sql);
		
		while(rs.next()) {
			team = rs.getString(1);
		}
		rs.close();
		ordre.close();
		connection.close();
		
		return team;

	}
	
	public void insertPlayer(String nom, String nickname) throws SQLException {
		 String sql = "insert into player(nom,nickname) values(?,?)";
	     Connection connection = new Connexio().connecta();
	     	try {
	            PreparedStatement ordre = connection.prepareStatement(sql);
	            ordre.setString(1, nom);
	            ordre.setString(2, nickname);

	            ordre.executeUpdate();
	            ordre.close();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	     	connection.close();
	}
	
	public int insertTeam(String nom) throws SQLException {
		 String sql = "insert into team(nom) values(?)";
		 int codiSortida = 200;
		 
	     Connection connection = new Connexio().connecta();
	     	try {
	            PreparedStatement ordre = connection.prepareStatement(sql);
	            ordre.setString(1, nom);
	            ordre.executeUpdate();
	            ordre.close();
	            
	        } catch (SQLException throwables) {
	            //throwables.printStackTrace();
	            codiSortida = 400;
	        }
	     	
	     connection.close();
	     return codiSortida;	
	}

	public void actualitzarEquipJugador(String equip, String jugador) throws SQLException {
		String sql = "update player set equip=? where nickname=?"; 
	     Connection connection = new Connexio().connecta();
	     	try {
	            PreparedStatement ordre = connection.prepareStatement(sql);
	            ordre.setString(1, equip);
	            ordre.setString(2, jugador);

	            ordre.executeUpdate();
	            ordre.close();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	     	connection.close();
	}

	public void eliminarEquip(String equip) throws SQLException {
		Connection connection = new Connexio().connecta();
		String sql = "delete from team where nom='"+equip+"'";
		Statement ordre = connection.createStatement();
		ordre.executeUpdate(sql);
		ordre.close();
		connection.close();
	}

	
}
