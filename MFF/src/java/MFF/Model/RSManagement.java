
package MFF.Model;

import MFF.Model.DAO.*;
import MFF.Exceptions.*;
import java.util.ArrayList;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class RSManagement {
    public RSManagement() {
	
    }
    public void addUser(User u) throws DuplicateUser {
	DAOUser dU=new DAOUser();
	dU.insert(u);
    }
    public User login(User u) throws NotLoginUser {
	DAOUser dU=new DAOUser();
	if (dU.validate(u)) {
	    return u;
	} else {
	    throw new NotLoginUser();
	}
    }
    public ArrayList<Film> getBestRatedFilms(int n) {
	DAOFilm dF=new DAOFilm();
	return dF.getBestRated(n);
    }
    public Film searchFilmById(int id) {
	DAOFilm dF=new DAOFilm();
	return dF.getFilm(id);
    }
    public ArrayList<Film> searchFilm(String s) {
	DAOFilm dF=new DAOFilm();
	return dF.search(s);
    }
    public ArrayList<User> searchUserByNick(String n) {
	DAOUser dU=new DAOUser();
	return dU.get(n);
    }
    public User getAnUser(String id) {
	DAOUser dU=new DAOUser();
	return dU.getAnUser(id);
    }
    public void addFilm(Film f) {
	DAOFilm dF=new DAOFilm();
	dF.insert(f);
    }
}
