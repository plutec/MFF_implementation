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
public class Similarity {
	float likeness;
	Film film1;
	Film film2;
	public Similarity(Film film1, Film film2, float likeness) {
		this.likeness=likeness;
		this.film1=film1;
		this.film2=film2;
	}
	public float getLikeness() {
		return likeness;
	}
	public Film getFilm(int v) {
		switch(v) {
			case 1: return film1;
			case 2: return film2;
			default: return null;
		}
	}
	public Film getFilm1() {
		return film1;
	}
	public Film getFilm2() {
		return film2;
	}
}
