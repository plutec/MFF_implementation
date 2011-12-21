/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MFF.Model;

import java.util.ArrayList;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class User {

    String id;
    String password;
    Boolean isAdmin;
    ArrayList<Rating> ratings;

    public User(String id, String pass, Boolean isAdmin) {
	this.id = id;
	this.password = pass;
	this.isAdmin = isAdmin;
	this.ratings = new ArrayList<Rating>();
    }

    public User(String id, String pass, Boolean isAdmin, ArrayList<Rating> ratings) {
	this.id = id;
	this.password = pass;
	this.isAdmin = isAdmin;
	this.ratings = ratings;
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

    public void setAsAdmin() {
	isAdmin = true;
    }

    public void insertRating(Rating r) {
	ratings.add(r);
    }

    public ArrayList<Rating> getRatings() {
	return ratings;
    }
}
