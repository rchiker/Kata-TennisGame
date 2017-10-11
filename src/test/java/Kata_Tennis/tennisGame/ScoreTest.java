package Kata_Tennis.tennisGame;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import Kata_Tennis.tennisGameApp.ScoreFrame;
import Kata_Tennis.tennisGameImpl.JeuImpl;

public class ScoreTest {
	ScoreFrame scoreFrame ;
	Jeu tennisGame;


	@Before
	public void init() {
		tennisGame = new JeuImpl(null, null);
		scoreFrame = new ScoreFrame();
	}

	
	@Test
	public void avantageJoueur1Test() {
		IntStream.range(0, 3).forEach(i -> tennisGame.gagnerPointsJoueur1());
		IntStream.range(0, 3).forEach(i -> tennisGame.gagnerPointsJoueur2());
		// le score est 40 - 40
		tennisGame.gagnerPointsJoueur1(); // Avantage joueur 1 !
		assertTrue("Av".equals(scoreFrame.avantageJoueur1(tennisGame)));
		
	}
}
