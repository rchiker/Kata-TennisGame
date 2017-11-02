package kata.tennisgame.impl;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import kata.tennisgame.ScoreFrame;

public class ScoreFrameImpl extends JFrame implements ScoreFrame{
	
	public MatchImpl game;

	JLabel jLabel1;
	JLabel jLabel2;
	JLabel jLabel3;
	
	JLabel jLabel4;
	JLabel jLabel5;

	public ScoreFrameImpl(){
		game = new MatchImpl("RCH", "CGI");
		this.setTitle("Tennis Game");
		this.setSize(250, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
	}

	public void showScore() {

		jLabel2.setText("Name | Jeu | Point | TieBreak |");
		this.add(jLabel2, BorderLayout.PAGE_START);

		jLabel1.setText("" + game.getJoueur1().getPseudo() + "    | " + game.getJoueur1().getJeu() + "      | " 
				+ game.getJoueur1().getScore() +" " + avantageJoueur(game.getJoueur1())  + "     | " 
						+ game.getJoueur1().getTieBreakPoints() +"           | ");
		this.add(jLabel1, BorderLayout.CENTER);

		jLabel3.setText("" + game.getJoueur2().getPseudo() + "    | " + game.getJoueur2().getJeu() + "      | " 
				+ game.getJoueur2().getScore() +" " + avantageJoueur(game.getJoueur2())  + "     | " 
				+ game.getJoueur2().getTieBreakPoints() +"           | ");
		this.add(jLabel3, BorderLayout.PAGE_END);

		// affichage de Winner 
		if(game.getJoueur1().getSet()==1) {
			jLabel4.setText("<html><FONT COLOR=GREEN> The winner is " + game.getJoueur1().getPseudo() + "</FONT></html>");
			this.add(jLabel4, BorderLayout.EAST);
		}
		if(game.getJoueur2().getSet()==1) {
			jLabel5.setText("<html><FONT COLOR=GREEN> The winner is " + game.getJoueur2().getPseudo() + "</FONT></html>");
			this.add(jLabel5, BorderLayout.EAST);
		}
		// refresh de la fenetre	
		this.revalidate();
	}

	public String avantageJoueur(JoueurImpl joueur)
	{
		int pointsJoueur1 = game.getJoueur1().getPoints();
		int pointsJoueur2 = game.getJoueur2().getPoints();
		if(joueur.getPoints()>3 && Math.abs(pointsJoueur1-pointsJoueur2)>0)
			if(joueur.getPoints() < pointsJoueur2 | joueur.getPoints() < pointsJoueur1 )
				return "";
			else {
				return "Av";
			}
		return "";
	}

	public MatchImpl getGame() {
		return game;
	}

	public void setGame(MatchImpl game) {
		this.game = game;
	}
}