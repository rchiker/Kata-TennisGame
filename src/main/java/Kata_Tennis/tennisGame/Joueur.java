package Kata_Tennis.tennisGame;


public interface Joueur {
	
	void gagnerPoint();
	
	void gagnerJeu();
	
	void gagnerSet();
	
	void gagnerTieBreakPoint();
	
	void resetScore();

	String getPseudo();
	
	Integer getPoints();

	Integer getJeu();
	
	Integer getSet();
	
	Integer getScore();
	
	Integer getTieBreakPoints();

}
