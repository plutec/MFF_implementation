
package MFF.Model;

import MFF.Model.DAO.DAOFilm;
import java.util.ArrayList;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class RSManagement {
    public RSManagement() {
	
    }
    public ArrayList<Film> getBestRatedFilms(int n) {
	DAOFilm dF=new DAOFilm();
	return dF.getBestRated(n);
    }
}
