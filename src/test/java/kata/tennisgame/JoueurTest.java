package kata.tennisgame;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;


public class JoueurTest {
	Joueur joueur1;
	Joueur joueur2;

	@Before
	public void init() {
		joueur1 = new Joueur("RCH");
		joueur2 = new Joueur("CGI");
	}
	

	@Test
	public void score_du_joueur_vaut15_quand_joueur_gagne_1point() {
		// When
		joueur1.gagnerPoint();
		// Then
		assertEquals(15, joueur1.getScore().intValue());
	}
	
	@Test
	public void score_du_joueur_vaut40_quand_joueur_gagne_3point() {
		// When
		IntStream.range(0, 3).forEach(i -> joueur1.gagnerPoint());
		// Then
		assertEquals(40, joueur1.getScore().intValue());
	}

}
