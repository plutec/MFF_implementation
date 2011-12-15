/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Model.DAO;

import MFF.Model.*;
import java.sql.Connection;

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
    public void insert(User u) {

    }
    public Boolean validate(User u) {
	return true;
    }
    public User get(String n) {
	return null;
    }
}
