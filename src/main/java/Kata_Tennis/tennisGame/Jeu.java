package Kata_Tennis.tennisGame;

public interface Jeu {
	
	public void gagnerPointsJoueur1();
	
	public void gagnerPointsJoueur2();
	
	public Joueur getJoueur1();
	
	public Joueur getJoueur2();
	
	boolean endGame();
	
	public void play(int joueur);
	

	
}
