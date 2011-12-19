
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
	float ratingAverage;
	public Film(int id, String title, int year, float ratingAverage) {
		this.id=id;
		this.title=title;
		this.year=year;
		this.ratingAverage=ratingAverage;
	}
	public Film(int id, String title, int year) {
		this.id=id;
		this.title=title;
		this.year=year;
		this.ratingAverage=0;
	}
	//Sets
	public void setId(int id) {
	    this.id=id;
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
	public float getRatingAverage() {
		return ratingAverage;
	}
}
