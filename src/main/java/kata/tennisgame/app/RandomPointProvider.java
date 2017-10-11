package kata.tennisgame.app;

import java.util.Random;

public class RandomPointProvider {

	public int providePoint() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (new Random().nextBoolean())
			return 1;
		return 2;
	}

}

