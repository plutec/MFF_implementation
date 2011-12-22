
package MFF.Model.DAO;

import MFF.Model.Film;
import MFF.Model.Similarity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
	    String sql = "INSERT INTO similarity(film1, film2, likeness) VALUES(?, ?, ?)";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setInt(1, s.getFilm1().getId());
	    query.setInt(2, s.getFilm2().getId());
	    query.setFloat(3, s.getLikeness());
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOSimilarity.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    //TODO el update no tiene sentido, no? Está sin hacer BIEN.

    public void update(Similarity s) {
	try {
	    String sql = "UPDATE Rattings SET likeness = ?, film1 = ?, film2 = ?";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setFloat(1, s.getLikeness());
	    query.setObject(2, s.getFilm1());
	    query.setObject(3, s.getFilm2());
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOSimilarity.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    //Se borra toda la tabla de similitudes

    public void delete() {
	try {
	    String sql = "DELETE * FROM Ratings"; //Borramos toda la tabla
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DAOSimilarity.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public ArrayList<Similarity> getNN(Film f) {
	try {
	    String sql = "SELECT id, year, title, similarity FROM film, neighbor WHERE film.id=film2 AND film1=? GROUP BY id ORDER BY similarity DESC;";
	    PreparedStatement query = connection.prepareStatement(sql);
	    query.setInt(1, f.getId());
	    ResultSet rs = query.executeQuery();
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    HashMap row = new HashMap();
	    ArrayList<Similarity> toRet = new ArrayList<Similarity>();
	    while (rs.next()) { //En este caso sólo debe haber 1
		for (int i = 1; i <= columns; i++) {
		    row.put(md.getColumnName(i), rs.getObject(i));
		}
		//Creamos el objeto película para devolverlo
		toRet.add(new Similarity(f, new Film((Integer)row.get("id"), (String)row.get("title"), (Integer)row.get("year")), (Float)row.get("similarity")));
	    }
	    return toRet;
	} catch (SQLException ex) {
	    Logger.getLogger(DAOSimilarity.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
}
