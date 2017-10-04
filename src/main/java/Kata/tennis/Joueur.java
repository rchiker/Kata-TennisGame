package Kata.tennis;


public interface Joueur {
	
	// il s'agit des points 15 30 40
	void gagnerPoint();

	void gagnerJeu();
	
	void gagnerSet();

	int getPoints();
	
	int getJeux();
	
	int getSet();

	String getPseudo();


}

