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
	}
}
