package kata.tennisgame;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import kata.tennisgame.impl.ScoreFrameImpl;

public class ScoreTest {
	ScoreFrameImpl scoreFrame ;

	@Before
	public void init() {
		scoreFrame = new ScoreFrameImpl();
	}
	
	@Test
	public void joueur_est_avantage_quand_joueur_marque_plus_que_4points_et_difference_un_point() {
		// Given
		IntStream.range(0, 3).forEach(i -> scoreFrame.getGame().getJoueur1().gagnerPoint());
		IntStream.range(0, 3).forEach(i -> scoreFrame.getGame().getJoueur2().gagnerPoint());
		// le score est 40 - 40
		// When
		scoreFrame.getGame().getJoueur1().gagnerPoint(); // Avantage joueur 1 !
		// Then
		assertTrue("Av".equals(scoreFrame.avantageJoueur(scoreFrame.getGame().getJoueur1())));
	}
}
