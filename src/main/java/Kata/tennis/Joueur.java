package Kata.tennis;


public interface Joueur {
	// il s'agit des points 15 30 40
	void gagnerPoint();
	
	void gagnerTieBreakPoint(int t);
	
	void gagnerJeu(int j);
	
	void gagnerSet();

	int getPoints();
	
	int getJeux();
	
	int getSet();
	
	int  getTieBreakPoints();
	
	Integer getScore();
	
	void resetScore() ;
	
	String isAvantage(int point);
	
	String getPseudo();


}

