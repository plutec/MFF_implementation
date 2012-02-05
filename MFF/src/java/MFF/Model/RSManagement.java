package MFF.Model;

import MFF.Model.DAO.*;
import MFF.Exceptions.*;
import MFF.Utils.HashMapSorting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.Date;

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
		User u = dU.getAnUser(id);
		dR.getRatedFilms(u);
		return u;
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
		Rating rate = new Rating(r, new Date(new java.util.Date().getTime()), f);
		if (dR.get(u, f).getRate() == 0) {
			dR.insert(u, f, rate);
		} else {
			dR.update(u, f, rate);
		}
	}
	
	public Rating getRate(User u, Film f) {
		DAORating dR = new DAORating();
		return dR.get(u, f);
	}
	
	public void deleteRating(User u, Film f) {
		DAORating dR = new DAORating();
		dR.delete(u, f);
	}
	
	public ArrayList<Film> getRecommendations(User u) {
		ArrayList<Film> toRet = new ArrayList<Film>();
		HashMap<Integer, Float> recommendations = new HashMap<Integer, Float>();
		float pred;
		//Obtener las pelis valoradas por un usuario
		DAORating dR = new DAORating();
		DAOFilm dF = new DAOFilm();
		dR.getRatedFilms(u); //Con esto se enlazan las películas valoradas
		HashMap<Integer, Integer> ratedFilms = new HashMap<Integer, Integer>();
		ArrayList<Rating> ratings = u.getRatings();
		for (Rating r : ratings) {
			ratedFilms.put(r.getFilm().getId(), r.getRate());
		}
		//Ya tenemos las películas valoradas, ahora cargamos las vecinas de todas ellas
		DAOSimilarity dS = new DAOSimilarity();
		ArrayList<Similarity> sim = new ArrayList<Similarity>();
		Iterator itr = ratedFilms.keySet().iterator();
		while (itr.hasNext()) {
			
			sim.addAll(dS.getNN(new Film((Integer) itr.next(), null, 0)));
		}
		//Calculamos predicción
		//Para ello:
		//Recorremos todas las películas vecinas y vemos las que no están valoradas por el usuario.
		for (Similarity s : sim) {
			if (!ratedFilms.containsKey(s.getFilm(2).getId())) { //Si no está valorada por el usuario hacemos la predicción
				int filmID = s.getFilm(2).getId();
				//Necesitamos:
				//1ºExtraemos los vecinos de la película a recomendar con sus similitudes
				ArrayList<Similarity> filmNeighbors = dS.getNN(s.getFilm(2));
				//2ºPara el usuario, las valoraciones que ha hecho (ya está en ratedFilms)
				//A calcular!
				float num = 0, den = 0;
				for (Similarity fms : filmNeighbors) { //Aquí recorro los K vecinos
					
					float similarity = fms.getLikeness();//filmNeighbor.get(filmID);
					int thisFilm = fms.getFilm(2).getId();
					//int rating = 0;
					if (ratedFilms.get(thisFilm) != null) {
						int rating = ratedFilms.get(thisFilm);
						
						num += similarity * rating;
						den += similarity;
						
					}
				}
				if (den == 0) {
					pred = 0;
				} else {
					pred = ((float) num / (float) den);
				}
				//La insertamos en las recomendaciones
				recommendations.put(filmID, pred);
			}
		}
		//Una vez hemos hecho las recomendaciones, las ordenamos de mayor a menor
		HashMap<Integer, Float> recommendationsSorted = HashMapSorting.sortHashMap(recommendations);
		//Y ahora extramos los IDs y generamos películas para mandarlas al exterior del mundo del espacio del...
		itr = recommendationsSorted.keySet().iterator();
		while (itr.hasNext()) {
			Integer key = (Integer) itr.next();
			toRet.add(dF.getFilm(key));
		}
		
		return toRet;
	}
	//Devolvemos un usuario pues este tiene una lista de rating y cada rating su película
	
	public User getBestRatedFilmsByUser(User u, int n) {
		//Una vez tengo el usuario, le introduzco las películas valoradas por él
		DAORating dR = new DAORating();
		dR.getNRatedFilms(u, n); //Introduce las N películas dentro del usuario
		return u;
	}
	//Igual que en el anterior, pero en lugar de n películas, con todas
	
	public User getRatedFilmsByUser(User u) {
		//Una vez tengo el usuario, le introduzco las películas valoradas por él
		DAORating dR = new DAORating();
		dR.getRatedFilms(u); //Introduce las películas dentro del usuario
		return u;
	}
}
