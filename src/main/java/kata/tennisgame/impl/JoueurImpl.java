package kata.tennisgame.impl;

import kata.tennisgame.Joueur;

public class JoueurImpl implements Joueur {
	private Integer				points	= 0;
	private Integer				jeu	= 0;
	private Integer				set	= 0;
	private String				pseudo;
	private Integer 			tieBreakPoints = 0;
	private static final int[]	SCORE	= { 0, 15, 30, 40 };
	

	public JoueurImpl(String pseudo) {
		super();		
		this.pseudo = pseudo;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void gagnerPoint() {
		points += 1;
	}

	public Integer getPoints() {
		return points;
	}

	public void resetScore() {
		points = 0;
	}

	public Integer getScore() {
		if (points <= 3)
			return SCORE[points];
		return SCORE[3];
	}

	public void gagnerJeu() {
		jeu++;
	}
	
	public Integer getJeu() {
		return jeu;
	}

	public void setJeu(Integer jeu) {
		this.jeu = jeu;
	}

	public void gagnerSet() {
		set++;		
	}

	public Integer getSet() {
		return set;
	}

	public void setSet(Integer set) {
		this.set = set;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public void gagnerTieBreakPoint() {
		tieBreakPoints += 1;
		
	}

	public Integer getTieBreakPoints() {
		return tieBreakPoints;
	}
}
