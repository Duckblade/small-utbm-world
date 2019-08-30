/** 
 * Class représentant la faction EDIM du jeu elle même représentant le département EDIM de l'UTBM
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.DepEDIMIcon;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DepEDIM extends Faction {

    public DepEDIM(ArrayList<Unite> unites) {
	super(1, "DepEDIM", unites);
	nbUnitesDepart = 20;
	IconeFaction = new DepEDIMIcon();
	/** Instance de la classe corresspondante en mode vue */
    }

    @Override
    public void pouvoirSpecial(Faction origine, Point2D.Double position) {
	pv = new PvEDIM("Cupidite", origine);

    }

}
