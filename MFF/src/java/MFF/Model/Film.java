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
public class Film {
    int id;
    String title;
    int year;
    ArrayList<Rating> ratings;
    public Film(int id, String title, int year) {
	this.id=id;
	this.title=title;
	this.year=year;
	ratings=new ArrayList<Rating>();
    }
    //Sets
    public void insertRating(Rating r) {
	ratings.add(r);
    }
    //Gets
    public String getTitle() {
	return title;
    }
    public int getId() {
	return id;
    }
    public int getYear() {
	return year;
    }
}
