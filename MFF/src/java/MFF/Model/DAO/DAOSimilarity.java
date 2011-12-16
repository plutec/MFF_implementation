/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Model.DAO;

import MFF.Model.Film;
import MFF.Model.Similarity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class DAOSimilarity {
private Connection connection;
    
    public DAOSimilarity() {
	connection = DBConnection.getConnection();
    }
    
    public void insert(Similarity s) {
	try {
            //los objetos los he pasao bien?
	    String sql = "INSERT INTO film(likeness, film1, film2) VALUES(?, ?, ?)";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setFloat(1, s.getLikeness());
	    query.setObject(2, s.getFilm1());
	    query.setObject(3, s.getFilm2());
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public void update(Similarity s) {
	try {
	    String sql = "UPDATE * Rattings SET likeness = ?, film1 = ? film2 = ?";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setFloat(1, s.getLikeness());
	    query.setObject(2, s.getFilm1());
	    query.setObject(3, s.getFilm2());
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public void delete(Similarity s) {
	try {
	    String sql = "DELETE * FROM Ratings"; //Borramos toda la tabla
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setObject(1, s.getLikeness());
            query.setObject(2, s.getFilm1());
            query.setObject(3, s.getFilm2());
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOFilm.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
   public List<Similarity> getNN(Film f) {
	return null;
    }
    
}
