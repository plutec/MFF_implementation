
package MFF.Model;

import java.util.Date;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class Rating {
    int rate;
    Date date;
    public Rating (int rate, Date date) {
	this.rate=rate;
	this.date=date;
    }
    public int getRate() {
	return rate;
    }
    public Date getDate() {
	return date;
    }
}
