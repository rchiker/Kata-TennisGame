package kata.tennis;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import Kata.tennis.Joueur;
import Kata.tennis.impl.JoueurImpl;

public class JoueurTest {
	Joueur joueur1;
	Joueur joueur2;

	@Before
	public void init() {
		joueur1 = new JoueurImpl("RCH");
		joueur2 = new JoueurImpl("CGI");
	}

	@Test
	public void gagnerPointsTest() {
		IntStream.range(0, 6).forEach(i -> joueur1.gagnerPoint());
		assertEquals(joueur1.getPoints(), 6);
	}
	
	@Test
	public void getPseudoTest() {
		assertTrue(joueur1.getPseudo().equals("RCH"));
	}
	
	@Test
	public void resetScoreTest() {
		joueur1.gagnerPoint();
		joueur1.gagnerPoint();
		joueur1.gagnerPoint();
		assertEquals(3, joueur1.getPoints());
		joueur1.resetScore();
		assertEquals(0, joueur1.getPoints());
	}

	@Test
	public void getScoreTest() {
		assertEquals(0, joueur1.getScore().intValue());
		joueur1.gagnerPoint();
		assertEquals(15, joueur1.getScore().intValue());
		joueur1.gagnerPoint();
		assertEquals(30, joueur1.getScore().intValue());
		joueur1.gagnerPoint();
		assertEquals(40, joueur1.getScore().intValue());
		joueur1.gagnerPoint();
		assertEquals(40, joueur1.getScore().intValue());
		joueur1.gagnerPoint();
		assertEquals(40, joueur1.getScore().intValue());
	}


}
