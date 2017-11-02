/**
 * 
 */
package kata.tennisgame;

import kata.tennisgame.impl.JoueurImpl;

/**
 * @author Chiker
 *
 */
public interface Match {

	public boolean endGame() ;

	public void play(int joueur) ;
	
	public void gagnerPointsJoueur(JoueurImpl joueur) ;
	



}
