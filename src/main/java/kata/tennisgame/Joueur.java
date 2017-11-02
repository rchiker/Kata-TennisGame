package kata.tennisgame;

/**
 * @author Chiker
 *
 */
public interface Joueur {

	public void gagnerPoint();

	public void resetScore();

	public Integer getScore();

	public void gagnerJeu();

	public void gagnerSet() ;
	
	public void gagnerTieBreakPoint() ;

	public Integer getTieBreakPoints();

}
