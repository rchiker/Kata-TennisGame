package Kata_Tennis.tennisGameImpl;

import Kata_Tennis.tennisGame.Jeu;
import Kata_Tennis.tennisGame.Joueur;

public class JeuImpl implements Jeu {

	private Joueur joueur1;
	private Joueur joueur2;

	public JeuImpl(String pseudo1, String pseudo2){
		joueur1 = new JoueurImpl(pseudo1);
		joueur2 = new JoueurImpl(pseudo2);
	}

	public void gagnerPointsJoueur1(){
		// TieBreak 
		if(joueur1.getJeu() == 6 && joueur1.getJeu() == joueur2.getJeu()) {
			joueur1.gagnerTieBreakPoint();
			if(joueur1.getTieBreakPoints() > 6 && Math.abs(joueur1.getTieBreakPoints()-joueur2.getTieBreakPoints()) > 1) {
				joueur1.gagnerJeu();
				joueur1.gagnerSet();
			}
		}
		// un point de plus pour le joueur1
		else {
			joueur1.gagnerPoint();
			// tester si le joueur1 a bien gagné son jeu
			if(joueur1.getPoints()>3 && Math.abs(joueur1.getPoints()-joueur2.getPoints())>1) {
				joueur1.gagnerJeu();
				joueur1.resetScore();
				joueur2.resetScore();
				// tester si le joueur1 a bien gagné son set
				if((joueur1.getJeu() == 6 && Math.abs(joueur1.getJeu()-joueur2.getJeu())>1) | joueur1.getJeu() > 6) {
					joueur1.gagnerSet();
				}
			}
		}
	}


	public void gagnerPointsJoueur2() {
		// TieBreak 
		if(joueur2.getJeu() == 6 && joueur1.getJeu() == joueur2.getJeu()) {
			joueur2.gagnerTieBreakPoint();
			if(joueur2.getTieBreakPoints() > 6 && Math.abs(joueur1.getTieBreakPoints()-joueur2.getTieBreakPoints()) > 1) {
				joueur2.gagnerJeu();
				joueur1.gagnerSet();
			}
		}

		// un point de plus pour le joueur2
		else {
			joueur2.gagnerPoint();
			// tester si le joueur2 a bien gagné son jeu
			if(joueur2.getPoints()>3 && Math.abs(joueur2.getPoints()-joueur1.getPoints())>1) {
				joueur2.gagnerJeu();
				joueur1.resetScore();
				joueur2.resetScore();
				// tester si le joueur2 a bien gagné son set
				if((joueur2.getJeu() == 6 && Math.abs(joueur1.getJeu()-joueur2.getJeu())>1) | joueur2.getJeu() > 6) {
					joueur2.gagnerSet();
				}
			}
		}
	}

	public boolean endGame() {
		if(joueur1.getSet()==1 || joueur2.getSet()==1)
			return true;
		return false;
	}

	public void play(int joueur) {
		if(joueur == 1)
			gagnerPointsJoueur1();
		else
			gagnerPointsJoueur2();
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

}
