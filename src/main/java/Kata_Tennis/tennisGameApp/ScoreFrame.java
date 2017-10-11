package Kata_Tennis.tennisGameApp;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Kata_Tennis.tennisGame.Jeu;

public class ScoreFrame extends JFrame {

	JLabel jLabel1;
	JLabel jLabel2;
	JLabel jLabel3;
	JLabel jLabel4;
	JLabel jLabel5;

	public ScoreFrame(){
		this.setTitle("Ma première fenêtre Java");
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

	public void showScore(Jeu game) {

		jLabel2.setText("<html> Name | Jeu | Point | TieBreak |");
		this.add(jLabel2, BorderLayout.PAGE_START);

		jLabel1.setText("<html> " + game.getJoueur1().getPseudo() + "   | " + game.getJoueur1().getJeu() + "    | " 
				+ game.getJoueur1().getScore() +" " + avantageJoueur1(game)  + " | " 
						+ game.getJoueur1().getTieBreakPoints() +" | </html>");
		this.add(jLabel1, BorderLayout.CENTER);

		jLabel3.setText("<html> " + game.getJoueur2().getPseudo() + " | " + game.getJoueur2().getJeu() + " | " 
				+ game.getJoueur2().getScore() +" " + avantageJoueur2(game) + " | " 
				+ game.getJoueur2().getTieBreakPoints() + "| </html>");
		this.add(jLabel3, BorderLayout.PAGE_END);

		// affichage de Winner 
		if(game.getJoueur1().getSet()==1) {
			jLabel4.setText("<html> The winner is " + game.getJoueur1().getPseudo());
			this.add(jLabel4, BorderLayout.EAST);
		}
		if(game.getJoueur2().getSet()==1) {
			jLabel5.setText("<html> The winner is " + game.getJoueur2().getPseudo());
			this.add(jLabel5, BorderLayout.EAST);
		}
		// refresh de la fenetre	
		this.revalidate();
	}

	public String avantageJoueur1(Jeu game)
	{
		int pointsJoueur1 = game.getJoueur1().getPoints();
		int pointsJoueur2 = game.getJoueur2().getPoints();
		if(pointsJoueur1>3 && Math.abs(pointsJoueur1-pointsJoueur2)>0)
			if(pointsJoueur1< pointsJoueur2)
				return "";
			else {
				return "Av";
			}
		return "";
	}

	public String avantageJoueur2(Jeu game)
	{
		int pointsJoueur1 = game.getJoueur1().getPoints();
		int pointsJoueur2 = game.getJoueur2().getPoints();
		if(pointsJoueur2>3 && Math.abs(pointsJoueur1-pointsJoueur2)>0)
			if(pointsJoueur2< pointsJoueur1)
				return "";
			else {
				return "Av";
			}
		return "";
	}
}