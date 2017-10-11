package Kata_Tennis.tennisGame;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import Kata_Tennis.tennisGameImpl.JeuImpl;

public class JeuTest {
	Jeu tennisGame;


	@Before
	public void init() {
		tennisGame = new JeuImpl("RCH", "CGI");
	}

	@Test
	public void gagnerPointsJoueur1Test() {
		IntStream.range(0, 3).forEach(i -> tennisGame.gagnerPointsJoueur1());
		assertEquals(new Integer(3), tennisGame.getJoueur1().getPoints());
	}
	
	@Test
	public void gagnerPointsJoueur1JeuTest() {
		// le cas ou le joueur1 gagne un jeu 
		IntStream.range(0, 4).forEach(i -> tennisGame.gagnerPointsJoueur1());
		assertEquals(new Integer(1), tennisGame.getJoueur1().getJeu());
	}
	
	@Test
	public void gagnerPointsJoueur1SetTest() {
		// le cas ou le joueur1 gagne un set 
		IntStream.range(0, 5).forEach(i -> tennisGame.getJoueur1().gagnerJeu()); // 5-0 pour le J1
		IntStream.range(0, 4).forEach(i -> tennisGame.gagnerPointsJoueur1());
		assertEquals(new Integer(1), tennisGame.getJoueur1().getSet());
	}
	
	@Test
	public void gagnerPointsJoueur1TieBreakTest() {
		// Cas de TieBreak : il faut un score de 6-6
		IntStream.range(0, 5).forEach(i -> tennisGame.getJoueur1().gagnerJeu()); // 5-0 pour le J1
		IntStream.range(0, 5).forEach(i -> tennisGame.getJoueur2().gagnerJeu()); // 5-5 pour le J1
		tennisGame.getJoueur1().gagnerJeu(); // 6-5 pour J1
		tennisGame.getJoueur2().gagnerJeu(); //6-6
		
		IntStream.range(0, 6).forEach(i -> tennisGame.gagnerPointsJoueur1()); // TieBreak 6-0 pour J1
		IntStream.range(0, 6).forEach(i -> tennisGame.gagnerPointsJoueur2()); // TieBreak 6-6
		
		tennisGame.gagnerPointsJoueur1(); // 7-6
		tennisGame.gagnerPointsJoueur2(); // 7-7
		assertEquals(new Integer(7), tennisGame.getJoueur1().getTieBreakPoints());
		assertEquals(new Integer(7), tennisGame.getJoueur1().getTieBreakPoints());
		// On verifie que les deux joueurs n'ont pas encore gagné un jeu. 
		assertEquals(new Integer(6), tennisGame.getJoueur1().getJeu());
		assertEquals(new Integer(6), tennisGame.getJoueur2().getJeu());
		
		tennisGame.gagnerPointsJoueur1(); // 8-7
		tennisGame.gagnerPointsJoueur1(); // 9-7 J1 a gagné
		assertEquals(new Integer(7), tennisGame.getJoueur1().getJeu());
		assertEquals(new Integer(1), tennisGame.getJoueur1().getSet());
	}
	
	@Test
	public void endGameTest() {
		// Avant de commencer le jeu le score vaut 0-0
		assertFalse(tennisGame.endGame());
		
		// After playing and won a set
		tennisGame.getJoueur1().gagnerSet();
		assertTrue(tennisGame.endGame());
	}

}
