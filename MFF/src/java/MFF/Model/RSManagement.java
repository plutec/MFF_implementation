
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
}
