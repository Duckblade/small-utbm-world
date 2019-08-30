/** 
 * Class représentant la faction TC du jeu elle même représentant les Tronc Commun de l'UTBM
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.DepTCIcon;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DepTC extends Faction {

    public DepTC(ArrayList<Unite> unites) {
	super(6, "DepTC", unites);
	nbUnitesDepart = 30;
	IconeFaction = new DepTCIcon();
	/** Instance de la classe corresspondante en mode vue */
    }

    @Override
    public void pouvoirSpecial(Faction origine, Point2D.Double position) {
	pv = new PvTC("ReplicationInfernal", this);
    }

}
