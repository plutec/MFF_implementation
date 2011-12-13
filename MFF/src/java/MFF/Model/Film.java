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
public class Film {
    int id;
    String title;
    int year;
    public Film(int id, String title, int year) {
	this.id=id;
	this.title=title;
	this.year=year;
    }
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
