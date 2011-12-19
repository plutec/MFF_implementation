
package MFF.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class Rating {
    int rate;
    Date date;
    Film film;
    public Rating (int rate, Date date) {
	this.rate=rate;
	this.date=date;
        this.film=null;
    }
    public Rating (int rate, Date date, Film film) {
	this.rate=rate;
	this.date=date;
        this.film=film;
    }
    public int getRate() {
	return rate;
    }
    public Date getDate() {
	return date;
    }
    public void setFilm(Film f) {
        film = f;
    }
    public Film getFilm() {
        return film;
    }
}
