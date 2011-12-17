/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Model.DAO;

import MFF.Exceptions.*;
import MFF.Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class DAOUser {
	private Connection connection;
	
	public DAOUser() {
		connection = DBConnection.getConnection();
	}
	public void insert(User u) throws DuplicateUser {
		try {
			String sql = "INSERT INTO users(id, pass, admin) VALUES(?, ?, ?)";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, u.getId());
			query.setString(2, u.getPassword());
			int isAdmin=0;
			if (u.getIsAdmin()) { isAdmin=1; }
			query.setInt(3, isAdmin);
			query.executeQuery();
		} catch (SQLException ex) {
			Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
			throw new DuplicateUser();
		}
	}
	public Boolean validate(User u) {
		try {
			String sql = "SELECT id, pass FROM users WHERE id = ?";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, u.getId());
			ResultSet rs = query.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			HashMap row = new HashMap();
			while (rs.next()) { //En este caso sólo debe haber 1 fila
				//results.add(row);
				for(int i=1; i<=columns; i++)
					row.put(md.getColumnName(i),rs.getObject(i));
			}
			String pass=row.get("pass").toString();
			if (u.getPassword().equals(pass)) {
				return true;
			}
			return false;
		} catch (SQLException ex) {
			Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	//Devuelve una lista de usuarios coincidentes
	public ArrayList<User> get(String n) {
		ArrayList<User> toRet=new ArrayList<User>();
		try {
			String sql = "SELECT id, pass, isAdmin FROM users WHERE id LIKE ?";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, "%" + n + "%");
			ResultSet rs = query.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			HashMap row = new HashMap();
			while (rs.next()) {
				for(int i=1; i<=columns; i++)
					row.put(md.getColumnName(i),rs.getObject(i));
				Boolean isAdmin=false;
				if ((Integer)row.get("isAdmin")==1){ isAdmin=true; }
				User toInsert=new User((String)row.get("id"), (String)row.get("pass"), isAdmin);
				toRet.add(toInsert);
			}
			return toRet;
		} catch (SQLException ex) {
			Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	public User getAnUser(String id) {
		User toRet=null;
		try {
			String sql = "SELECT id, pass, isAdmin FROM users WHERE id = ?";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, id);
			ResultSet rs = query.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			HashMap row = new HashMap();
			while (rs.next()) { //En este caso sólo debe haber 1 fila
				for(int i=1; i<=columns; i++)
					row.put(md.getColumnName(i),rs.getObject(i));
				Boolean isAdmin=false;
				if ((Integer)row.get("isAdmin")==1){ isAdmin=true; }
				toRet=new User((String)row.get("id"), (String)row.get("pass"), isAdmin);
			}
			return toRet;
		} catch (SQLException ex) {
			Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
