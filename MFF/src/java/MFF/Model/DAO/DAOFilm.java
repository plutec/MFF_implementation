
package MFF.Model.DAO;

import MFF.Model.Film;
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
public class DAOFilm {
    private Connection connection;
    
    public DAOFilm() {
	connection = DBConnection.getConnection();
    }
    public ArrayList<Film> search(String s) {
	try {
	    ArrayList<Film> toRet=new ArrayList<Film>();
	    String sql = "SELECT id, year, title FROM film WHERE title='%?%' OR year='%?%'";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setString(1, s);
	    query.setString(2, s);
	    ResultSet rs = query.executeQuery();
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    HashMap row = new HashMap();
	    while (rs.next()) {
		for(int i=1; i<=columns; i++)
		    row.put(md.getColumnName(i),rs.getObject(i));
		toRet.add(new Film((Integer)row.get("id"), (String)row.get("title"), (Integer)row.get("year")));
	    }
	    //Devolvemos
	    return toRet;
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
    public void insert(Film f) {
	try {
	    String sql = "INSERT INTO film(id, title, year) VALUES(?, '?', ?)";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setInt(1, f.getId());
	    query.setString(2, f.getTitle());
	    query.setInt(3, f.getYear());
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    public void update(Film f) {
	try {
	    String sql = "UPDATE film SET title = ?, year = ? WHERE id=?";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setString(1, f.getTitle());
	    query.setInt(2, f.getYear());
	    query.setInt(3, f.getId());
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    public void delete(Film f) {
	try {
	    String sql = "DELETE film WHERE id=?";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setInt(1, f.getId());
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    public Film getFilm(int id) {
	try {
	    String sql = "SELECT id, year, title FROM film WHERE id=?";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setInt(1, id);
	    ResultSet rs = query.executeQuery();
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    HashMap row = new HashMap();
	    while (rs.next()) { //En este caso sólo debe haber 1
		//results.add(row);
		for(int i=1; i<=columns; i++)
		    row.put(md.getColumnName(i),rs.getObject(i));
	    }
	    //Creamos el objeto película para devolverlo
	    return new Film((Integer)row.get("id"), (String)row.get("title"), (Integer)row.get("year"));
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
    public ArrayList<Film> getBestRated(int n) {
	try {
	    ArrayList<Film> toRet=new ArrayList<Film>();
	    String sql = "SELECT film_id, AVG(rate) avg FROM ratings GROUP BY film_id ORDER BY avg DESC LIMIT 0,?";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setInt(1, n);
	    ResultSet rs = query.executeQuery();
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    HashMap row = new HashMap();
	    while (rs.next()) {
		for(int i=1; i<=columns; i++)
		    row.put(md.getColumnName(i),rs.getObject(i));
		Film toInsert=this.getFilm((Integer)row.get("id")); //Creamos la película
		toInsert.setRatingAverage((Float)row.get("avg")); //Insertamos la media
		toRet.add(toInsert);
	    }
	    //Devolvemos
	    return toRet;
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }

}
