package utbm.donnees;
/** 
 * Pouvoir de la faction
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
import java.awt.geom.Point2D;

public class PvMeca extends PouvoirSpecial {

    Point2D.Double position;

    public PvMeca(String name, Point2D.Double position, Faction fac) {
	super(name, fac);
	this.position = position;
    }

    @Override
    public void action() {
	Plateau.getCase(position).removeBatisse();
	Plateau.getCase(position).ajoutBatisse("garage");
    }

}
