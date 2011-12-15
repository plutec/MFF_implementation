
package MFF.Model.DAO;

import MFF.Model.*;
import java.sql.Connection;
import java.util.ArrayList;

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

    }
    public void update(User u, Film f, Rating r) {

    }
    public Rating get(User u, Film f) {
	return null;
    }
    public ArrayList<Rating> getRatedFilms(User u) {
	return null;
    }
}
