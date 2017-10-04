package Kata.tennis.app;

import java.util.Random;

public class RandomPointProvider {

	public int providePoint() {
		if (new Random().nextBoolean())
			return 1;
		return 2;
	}

}
