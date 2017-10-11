package Kata_Tennis.tennisGameApp;

import Kata_Tennis.tennisGame.Jeu;
import Kata_Tennis.tennisGameImpl.JeuImpl;

public class TennisApp {
	
	RandomPointProvider pointProvider = new RandomPointProvider();
	
	public static void main(String... argv) {
			new TennisApp().run();	
	}
	
	public void run() {
		Jeu game = new JeuImpl("RCH", "CGI");
		ScoreFrame score = new ScoreFrame();
		while(!game.endGame()) {
			game.play(pointProvider.providePoint());
			score.showScore(game);
		}
	}
}
