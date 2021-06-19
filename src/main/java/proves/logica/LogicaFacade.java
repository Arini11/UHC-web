package proves.logica;

import java.sql.*;
import java.util.*;

import proves.connexio.Connexio;

public class LogicaFacade {
	
	public LogicaFacade() {
	}

	public List<String> getPlayers() throws SQLException {
		
		List<String> players = new ArrayList<String>();
		
		Connection connection = new Connexio().connecta();
		String sql = "select nom,nickname from player";
		Statement ordre = connection.createStatement();
		ResultSet rs = ordre.executeQuery(sql);
		
		while(rs.next()) {
			players.add(rs.getString(1)+";"+rs.getString(2));
		}
		
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
		
		return teams;

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
	            throwables.printStackTrace();
	            codiSortida = 400;
	        }
	     	
	     connection.close();
	     return codiSortida;	
	}
	
}
