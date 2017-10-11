package Kata_Tennis.tennisGame;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import Kata_Tennis.tennisGameImpl.JoueurImpl;

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
		assertEquals(new Integer(6), joueur1.getPoints());
	}
	
	@Test
	public void getPseudoTest() {
		assertTrue(joueur1.getPseudo().equals("RCH"));
	}
	
	@Test
	public void resetScoreTest() {
		IntStream.range(0, 3).forEach(i -> joueur1.gagnerPoint());
		assertEquals(new Integer(3), joueur1.getPoints());
		
		joueur1.resetScore();
		assertEquals(new Integer(0), joueur1.getPoints());
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
