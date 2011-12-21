package MFF.Model;

import MFF.Model.DAO.*;
import MFF.Exceptions.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class RSManagement {

    public RSManagement() {
    }

    public void addUser(User u) throws DuplicateUser {
	DAOUser dU = new DAOUser();
	dU.insert(u);
    }

    public User login(User u) throws NotLoginUser {
	DAOUser dU = new DAOUser();
	if (dU.validate(u)) {
	    return u;
	} else {
	    throw new NotLoginUser();
	}
    }

    public ArrayList<Film> getBestRatedFilms(int n) {
	DAOFilm dF = new DAOFilm();
	return dF.getBestRated(n);
    }

    public Film searchFilmById(int id) {
	DAOFilm dF = new DAOFilm();
	return dF.getFilm(id);
    }

    public ArrayList<Film> searchFilm(String s) {
	DAOFilm dF = new DAOFilm();
	return dF.search(s);
    }

    public ArrayList<User> searchUserByNick(String n) {
	DAOUser dU = new DAOUser();
	return dU.get(n);
    }

    public User getAnUser(String id) {
	DAOUser dU = new DAOUser();
	return dU.getAnUser(id);
    }
    public User getAnUserWithRatings(String id) {
	DAOUser dU = new DAOUser();
	DAORating dR = new DAORating();
	User toRet=dU.getAnUser(id);
	dR.getRatedFilms(toRet);
	return toRet;
    }

    public void addFilm(Film f) {
	DAOFilm dF = new DAOFilm();
	dF.insert(f);
    }
    public void editFilm(Film f) {
        DAOFilm dF = new DAOFilm();
	dF.update(f);
    }
    public void deleteFilm(Film f) {
        DAOFilm dF = new DAOFilm();
	dF.delete(f);
    }
    public void rate(User u, Film f, int r) {
        DAORating dR = new DAORating();
        Rating rate=new Rating (r, new Date(), f);
        dR.insert(u, f, rate);
    }
    public void editRate(User u, Film f, Rating r) {
        DAORating dR = new DAORating();
        dR.update(u, f, r);
    }
    public ArrayList<Film> getRecommendations(User u, int n) {
        return null;
    }
    //Devolvemos un usuario pues este tiene una lista de rating y cada rating su película
    public User getBestRatedFilmsByUser(User u, int n) {
        //Una vez tengo el usuario, le introduzco las películas valoradas por él
        DAORating dR=new DAORating();
        dR.getNRatedFilms(u, n); //Introduce las N películas dentro del usuario
        return u;
    }
    //Igual que en el anterior, pero en lugar de n películas, con todas
    public User getRatedFilmsByUser(User u) {
        //Una vez tengo el usuario, le introduzco las películas valoradas por él
        DAORating dR=new DAORating();
        dR.getRatedFilms(u); //Introduce las películas dentro del usuario
        return u;
    }
}
