package kata.tennisgame;



public class Match {

	private Joueur joueur1;
	private Joueur joueur2;

	public Match(String pseudo1, String pseudo2){
		joueur1 = new Joueur(pseudo1);
		joueur2 = new Joueur(pseudo2);
	}

	public boolean endGame() {
		if(joueur1.getSet()==1 || joueur2.getSet()==1)
			return true;
		return false;
	}

	public void play(int joueur) {
		if(joueur == 1)
			gagnerPointsJoueur(this.joueur1);
		else
			gagnerPointsJoueur(this.joueur2);
	}
	
	public void gagnerPointsJoueur(Joueur joueur){
		// TieBreak !
		if(joueur.getJeu() == 6 && joueur1.getJeu() == joueur2.getJeu()) {
			isTieBreak(joueur);
		}
		// Un point de plus pour le joueur1
		else {
			joueur.gagnerPoint();
			playerHasWonGame(joueur);
		}
	}
	
	/**
	 * Verifier si le joueur a gagné son jeu suite au tiebreak
	 * @param joueur
	 */
	private void isTieBreak(Joueur joueur) {
		joueur.gagnerTieBreakPoint();
		if(joueur.getTieBreakPoints() > 6 && Math.abs(joueur1.getTieBreakPoints()-joueur2.getTieBreakPoints()) > 1) {
			joueur.gagnerJeu();
			joueur.gagnerSet();
		}
	}

	/**
	 * tester si le joueur1 a bien gagné son jeu
	 * @param joueur
	 */
	private void playerHasWonGame(Joueur joueur) {
		
		if(joueur.getPoints()>3 && Math.abs(joueur1.getPoints()-joueur2.getPoints())>1) {
			joueur.gagnerJeu();
			joueur1.resetScore();
			joueur2.resetScore();
			playerHasWonSet(joueur);
		}
	}

	/**
	 *  tester si le joueur a bien gagné son set
	 * @param joueur
	 */
	private void playerHasWonSet(Joueur joueur) {
		if((joueur.getJeu() == 6 && Math.abs(joueur1.getJeu()-joueur2.getJeu())>1) | joueur.getJeu() > 6) {
			joueur.gagnerSet();
		}
	}


	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

}
