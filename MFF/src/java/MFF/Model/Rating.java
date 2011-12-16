
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
    User user;
    public Rating (int rate, Date date, User u) {
	this.rate=rate;
	this.date=date;
	this.user=u;
    }
    public int getRate() {
	return rate;
    }
    public Date getDate() {
	return date;
    }
    public User getUser() {
	return user;
    }
}
