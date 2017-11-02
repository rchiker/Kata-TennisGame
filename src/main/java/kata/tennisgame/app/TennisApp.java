package kata.tennisgame.app;

import kata.tennisgame.impl.ScoreFrameImpl;

public class TennisApp {
	
	RandomPointProvider pointProvider = new RandomPointProvider();
	
	public static void main(String... argv) {
			new TennisApp().run();	
	}
	
	public void run() {
		ScoreFrameImpl score = new ScoreFrameImpl();
		while(!score.getGame().endGame()) {
			score.getGame().play(pointProvider.providePoint());
			score.showScore();
		}
	}
}
