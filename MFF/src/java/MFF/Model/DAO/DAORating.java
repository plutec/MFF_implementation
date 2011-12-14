
package MFF.Model.DAO;

import java.sql.Connection;

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
    
}
