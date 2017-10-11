package kata.tennisgame;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;


public class MatchTest {
	Match tennisGame;


	@Before
	public void init() {
		tennisGame = new Match("RCH", "CGI");
	}

	@Test
	public void score_du_joueur_remit_a_zero_quand_joueur_gagne_plus_que_4points_et_difference_plus_que_un() {
		// When
		IntStream.range(0, 4).forEach(i -> tennisGame.gagnerPointsJoueur(tennisGame.getJoueur1()));
		// Then
		assertEquals(new Integer(0), tennisGame.getJoueur1().getPoints());
	}

	@Test
	public void joueur_gagne_son_jeu_quand_joueur_gagne_plus_que_4points_et_difference_plus_que_un() {
		// le cas ou le joueur1 gagne un jeu 
		// When
		IntStream.range(0, 4).forEach(i -> tennisGame.gagnerPointsJoueur(tennisGame.getJoueur1()));
		// Then
		assertEquals(new Integer(1), tennisGame.getJoueur1().getJeu());
	}

	@Test
	public void joueur_gagne_son_set_quand_joueur_gagne_plus_que_6jeu_et_difference_plus_que_un() {
		// le cas ou le joueur1 gagne un set 
		// Given
		IntStream.range(0, 5).forEach(i -> tennisGame.getJoueur1().gagnerJeu()); // 5-0 pour le J1
		// When
		IntStream.range(0, 4).forEach(i -> tennisGame.gagnerPointsJoueur(tennisGame.getJoueur1()));
		// Then
		assertEquals(new Integer(1), tennisGame.getJoueur1().getSet());
	}

	@Test
	public void joueur_gagne_son_set_suite_au_tiebreak_quand_joueur_gagne_plus_que_6points_et_difference_plus_que_un() {
		// Cas de TieBreak : il faut un score de 6-6
		// Given
		IntStream.range(0, 5).forEach(i -> tennisGame.getJoueur1().gagnerJeu()); // 5-0 pour le J1
		IntStream.range(0, 5).forEach(i -> tennisGame.getJoueur2().gagnerJeu()); // 5-5 pour le J1
		tennisGame.getJoueur1().gagnerJeu(); // 6-5 pour J1
		tennisGame.getJoueur2().gagnerJeu(); //6-6
		IntStream.range(0, 6).forEach(i -> tennisGame.gagnerPointsJoueur(tennisGame.getJoueur1())); // TieBreak 6-0 pour J1
		IntStream.range(0, 6).forEach(i -> tennisGame.gagnerPointsJoueur(tennisGame.getJoueur2())); // TieBreak 6-6
		// When
		tennisGame.gagnerPointsJoueur(tennisGame.getJoueur1()); // 7-6
		tennisGame.gagnerPointsJoueur(tennisGame.getJoueur2()); // 7-7
		// Then
		assertEquals(new Integer(7), tennisGame.getJoueur1().getTieBreakPoints());
		assertEquals(new Integer(7), tennisGame.getJoueur1().getTieBreakPoints());
		// On verifie que les deux joueurs n'ont pas encore gagné un jeu. 
		assertEquals(new Integer(6), tennisGame.getJoueur1().getJeu());
		assertEquals(new Integer(6), tennisGame.getJoueur2().getJeu());
		// When
		tennisGame.gagnerPointsJoueur(tennisGame.getJoueur1()); // 8-7
		tennisGame.gagnerPointsJoueur(tennisGame.getJoueur1()); // 9-7 J1 a gagné
		// Then
		assertEquals(new Integer(7), tennisGame.getJoueur1().getJeu());
		assertEquals(new Integer(1), tennisGame.getJoueur1().getSet());
	}

	@Test
	public void match_se_termine_quand_un_joueur_gagne_un_set() {
		// After playing and won a set
		// When
		tennisGame.getJoueur1().gagnerSet();
		// Then
		assertTrue(tennisGame.endGame());
	}

}
