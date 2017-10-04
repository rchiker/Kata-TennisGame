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
	
	@Test
	public void avantageTest() {
		joueur1.gagnerPoint();
		joueur1.gagnerPoint();
		joueur1.gagnerPoint();
		
		joueur2.gagnerPoint();
		joueur2.gagnerPoint();
		joueur2.gagnerPoint();
		
		joueur1.gagnerPoint();
		assertTrue(joueur1.isAvantage(joueur2.getPoints()).equals("Av"));
		
		joueur2.gagnerPoint();
		assertFalse(joueur1.isAvantage(joueur2.getPoints()).equals("Av"));
		
		joueur2.gagnerPoint();
		assertTrue(joueur2.isAvantage(joueur1.getPoints()).equals("Av"));
	}
	
	@Test
	public void getSetsTest() {
		joueur1.gagnerJeu(joueur2.getJeux());
		joueur1.gagnerJeu(joueur2.getJeux());
		joueur1.gagnerJeu(joueur2.getJeux());
		
		
		joueur2.gagnerJeu(joueur1.getJeux());
		joueur2.gagnerJeu(joueur1.getJeux());
		joueur2.gagnerJeu(joueur1.getJeux());
		
		joueur1.gagnerJeu(joueur2.getJeux());
		joueur1.gagnerJeu(joueur2.getJeux());
		joueur1.gagnerJeu(joueur2.getJeux());
		
		assertEquals(1, joueur1.getSet());
	}
	
	@Test
	public void gagnerTieBreakPointTest() {
		joueur1.gagnerJeu(joueur2.getJeux());
		assertEquals(1, joueur1.getJeux());
		IntStream.range(0, 7).forEach(i -> joueur1.gagnerTieBreakPoint(0));
		assertEquals(7, joueur1.getTieBreakPoints());
		assertEquals(2, joueur1.getJeux());
	}
	
	@Test
	public void gagnerTieBreakPointEgaliteTest() {
		joueur1.gagnerJeu(joueur2.getJeux());
		assertEquals(1, joueur1.getJeux());
		IntStream.range(0, 6).forEach(i -> joueur1.gagnerTieBreakPoint(0));
		assertEquals(6, joueur1.getTieBreakPoints());
		assertEquals(0, joueur2.getTieBreakPoints());
		IntStream.range(0, 6).forEach(i -> joueur2.gagnerTieBreakPoint(6));
		assertEquals(6, joueur2.getTieBreakPoints());
		assertEquals(6, joueur1.getTieBreakPoints());
		
		joueur1.gagnerTieBreakPoint(6);
		assertEquals(1, joueur1.getJeux());
	}
	


}
