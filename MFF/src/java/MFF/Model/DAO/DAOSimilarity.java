/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Model.DAO;

import MFF.Model.*;
import java.sql.Connection;
import java.util.List;

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

    }
    public void update(Similarity s) {

    }
    public void delete(Similarity s) {
	
    }
    public List<Similarity> getNN(Film f) {
	return null;
    }
}
