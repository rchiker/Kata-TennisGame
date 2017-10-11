package kata.tennisgame.app;

import kata.tennisgame.ScoreFrame;

public class TennisApp {
	
	RandomPointProvider pointProvider = new RandomPointProvider();
	
	public static void main(String... argv) {
			new TennisApp().run();	
	}
	
	public void run() {
		ScoreFrame score = new ScoreFrame();
		while(!score.getGame().endGame()) {
			score.getGame().play(pointProvider.providePoint());
			score.showScore();
		}
	}
}
