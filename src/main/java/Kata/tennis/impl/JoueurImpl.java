package Kata.tennis.impl;


import Kata.tennis.Joueur;

public class JoueurImpl implements Joueur {
	private Integer				points;
	private Integer				jeux;
	private Integer				sets;
	private Integer				tieBreakPoints;
	private String				pseudo;
	private static final int[]	SCORE	= { 0, 15, 30, 40 };
	
	public JoueurImpl(String pseudo) {
		super();		
		this.pseudo = pseudo;
		this.points	= 0;
		this.jeux = 0;
		this.sets = 0;
		this.tieBreakPoints = 0;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void gagnerPoint() {
		points += 1;
	}
	

	@Override
	public String toString() {
		return "Joueur : " + getPseudo() ;
	}

	public int compareTo(Joueur o) {
		return this.pseudo.compareToIgnoreCase(o.getPseudo());
	}

	public int getPoints() {
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
	
	public String isAvantage(int points2) {
		if(this.points>3 && Math.abs(this.points-points2)>0)
			if(points< points2)
				return "  ";
			else {
				return "Av";
			}
		return "  ";
	}

	public void gagnerJeu(int jeux2) {
		jeux += 1;
		if((jeux == 6 && Math.abs(jeux-jeux2)>1) | jeux > 6) {
			this.gagnerSet();
		}
	}

	public int getJeux() {
		return jeux;
	}

	public void gagnerSet() {
		sets += 1;	
	}

	public int getSet() {
		return sets;
	}

	public void gagnerTieBreakPoint(int tieBreakPoints2) {
		tieBreakPoints += 1;
		if(tieBreakPoints > 6 && Math.abs(tieBreakPoints-tieBreakPoints2) > 1) {
			this.gagnerJeu(0);
		}
		
	}

	public int getTieBreakPoints() {
		return tieBreakPoints;
	}

}
