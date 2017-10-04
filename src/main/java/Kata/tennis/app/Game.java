package Kata.tennis.app;

import Kata.tennis.Joueur;
import Kata.tennis.impl.JoueurImpl;


/**
 * Hello world!
 *
 */
public class Game 
{

	public static void main(String... argv) {
		new Game().run();	
	}

	public void run() {
		Joueur joueur1 = new JoueurImpl("rchiker");
		Joueur joueur2 = new JoueurImpl("  CGI  ");
		RandomPointProvider pointProvider = new RandomPointProvider();

		while(!this.endSet(joueur1, joueur2)) {
			if(pointProvider.providePoint() == 1) {
				
				if(joueur1.getJeux() == 6 && joueur1.getJeux() == joueur2.getJeux()) {
					joueur1.gagnerTieBreakPoint(joueur2.getTieBreakPoints());
				}
				else {
					joueur1.gagnerPoint();
					if(joueur1.getPoints()>3 && Math.abs(joueur1.getPoints()-joueur2.getPoints())>1) {
						joueur1.gagnerJeu(joueur2.getJeux());
						joueur1.resetScore();
						joueur2.resetScore();
					}
				}
			}
			else {
				
				if(joueur1.getJeux() == 6 && joueur1.getJeux() == joueur2.getJeux()) {
					joueur2.gagnerTieBreakPoint(joueur1.getTieBreakPoints());
				}
				else {
					joueur2.gagnerPoint();
					if(joueur2.getPoints()>3 && Math.abs(joueur2.getPoints()-joueur1.getPoints())>1) {
						joueur2.gagnerJeu(joueur1.getJeux());
						joueur2.resetScore();
						joueur1.resetScore();
					}
				}
			}
			
			System.out.println(joueur1.toString() + " | " + 
					joueur1.getJeux() + " | " + joueur1.getScore() + " " + 
					joueur1.isAvantage(joueur2.getPoints())+ " " + joueur1.getTieBreakPoints());
			
			System.out.println(joueur2.toString() + " | " + 
					joueur2.getJeux() + " | " + joueur2.getScore() + " " + 
					joueur2.isAvantage(joueur1.getPoints()) + " " + joueur2.getTieBreakPoints());
			
			System.out.println("--------------------------------");
		}
		if(joueur1.getJeux()<joueur2.getJeux())
			System.out.println("-------------The winner is " + joueur2.getPseudo() + "-----------");
		else
			System.out.println("-------------The winner is " + joueur1.getPseudo() + "-----------");
		 
	}

	public boolean endSet(Joueur joueur1, Joueur joueur2) {
		if(joueur1.getSet()==1 || joueur2.getSet()==1)
			return true;
		return false;
	}
}
