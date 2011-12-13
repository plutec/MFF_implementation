/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Model;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class User {
    String id;
    String password;
    Boolean isAdmin;
    public User(String id, String pass, Boolean isAdmin) {
	this.id=id;
	this.password=pass;
	this.isAdmin=isAdmin;
    }
    public String getId() {
	return id;
    }
    public String getPassword() {
	return password;
    }
    public Boolean getIsAdmin() {
	return isAdmin;
    }
}
