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

		while(!Game.endSet(joueur1, joueur2)) {
			if(pointProvider.providePoint() == 1) {
				// joueur 1 qui a gagné le point
				joueur1.gagnerPoint();
				if(joueur1.getPoints()>3 && Math.abs(joueur1.getPoints()-joueur2.getPoints())>1) {
					joueur1.gagnerJeu();
					joueur1.resetScore();
					joueur2.resetScore();
				}
			}
			else {
				// joueur 2 qui a gagné le point
				joueur2.gagnerPoint();
				if(joueur2.getPoints()>3 && Math.abs(joueur2.getPoints()-joueur1.getPoints())>1) {
					joueur2.gagnerJeu();
					joueur2.resetScore();
					joueur1.resetScore();

				}
			}

			System.out.println(joueur1.toString() + " | " + 
					joueur1.getJeux() + " | " + joueur1.getScore());

			System.out.println(joueur2.toString() + " | " + 
					joueur2.getJeux() + " | " + joueur2.getScore());

			System.out.println("--------------------------------");
		}
	}

	private static boolean endSet(Joueur joueur1, Joueur joueur2) {
		// TODO Auto-generated method stub
		return false;
	}
}
