package Kata.tennis.impl;


import Kata.tennis.Joueur;

public class JoueurImpl implements Joueur {
	private Integer				points;
	private Integer				jeux;
	private Integer				sets;
	private String				pseudo;
	private static final int[]	SCORE	= { 0, 15, 30, 40 };
	
	public JoueurImpl(String pseudo) {
		super();		
		this.pseudo = pseudo;
		this.points	= 0;
		this.jeux = 0;
		this.sets = 0;
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

	public int getPoints() {
		return points;
	}

	
	public void gagnerJeu() {
		jeux += 1;
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

	@Override
	public void resetScore() {
		points = 0;
	}

	@Override
	public Integer getScore() {
		if (points <= 3)
			return SCORE[points];
		return SCORE[3];
	}


}
