
package MFF.Model.DAO;

import MFF.Model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class DAORating {
	private Connection connection;
	
	public DAORating() {
		connection = DBConnection.getConnection();
	}
	public void insert(User u, Film f, Rating r) {
		try {
			String sql = "INSERT INTO ratings(film_id, user_id, rate, rate_date) VALUES(?, ?, ?, ?)";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setInt(1, f.getId());
			query.setString(2, u.getId());
			query.setInt(3, r.getRate());
			query.setDate(4, (Date) r.getDate());
			query.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAORating.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void update(User u, Film f, Rating r) {
		try {
			String sql = "UPDATE ratings SET rate_date = ?, rate = ? WHERE user_id=? AND film_id=?";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setDate(1, (Date) r.getDate());
			query.setInt(2, r.getRate());
			query.setString(3, u.getId());
			query.setInt(4, f.getId());
			query.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	public void delete(User u, Film f) {
		try {
			String sql = "DELETE FROM ratings WHERE user_id=? AND film_id=?";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, u.getId());
			query.setInt(2, f.getId());
			query.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public Rating get(User u, Film f) {
		try {
			String sql = "SELECT rate, rate_date FROM ratings WHERE user_id=? AND film_id=?";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, u.getId());
			query.setInt(2, f.getId());
			ResultSet rs = query.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			HashMap row = new HashMap();
			while (rs.next()) { //En este caso sólo debe haber 1
				for(int i=1; i<=columns; i++)
					row.put(md.getColumnName(i),rs.getObject(i));
			}
			//Creamos el objeto rating para devolverlo
			if (row.size() == 0)
				return new Rating(0, null);
			return new Rating((Integer)row.get("rate"), (Date)row.get("rate_date"));
		} catch (SQLException ex) {
			Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	//Introduce los ratings y las películas dentro del usuario pasado como parámetros
	public void getRatedFilms(User u) {
		DAOFilm dF=new DAOFilm();
		try {
			String sql = "SELECT film_id, rate, rate_date FROM ratings WHERE user_id=?";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, u.getId());
			ResultSet rs = query.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			HashMap row = new HashMap();
			while (rs.next()) { //En este caso sólo debe haber 1
				for(int i=1; i<=columns; i++)
					row.put(md.getColumnName(i),rs.getObject(i));
				//Creamos el objeto rating para devolverlo
				Rating toInsert=new Rating ((Integer)row.get("rate"), (Date)row.get("rate_date"), dF.getFilm((Integer)row.get("film_id")));
				u.insertRating(toInsert);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	public void getNRatedFilms(User u, int n) {
		DAOFilm dF=new DAOFilm();
		try {
			String sql = "SELECT film_id, rate, rate_date FROM ratings WHERE user_id=? LIMIT 0,? ORDER BY rate ASC";
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, u.getId());
			query.setInt(2, n);
			ResultSet rs = query.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			HashMap row = new HashMap();
			while (rs.next()) { //En este caso sólo debe haber 1
				for(int i=1; i<=columns; i++)
					row.put(md.getColumnName(i),rs.getObject(i));
				//Creamos el objeto rating para devolverlo
				Rating toInsert=new Rating ((Integer)row.get("rate"), (Date)row.get("rate_date"), dF.getFilm((Integer)row.get("film_id")));
				u.insertRating(toInsert);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
