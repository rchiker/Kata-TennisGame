package kata.tennisgame;

import kata.tennisgame.impl.JoueurImpl;
/**
 * 
 * @author Chiker
 *
 */
public interface ScoreFrame {
	
	public void showScore() ;

	public String avantageJoueur(JoueurImpl joueur) ;

}
