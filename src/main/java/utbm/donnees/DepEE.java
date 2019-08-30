/** 
 * Class représentant la faction EE du jeu elle même représentant le département EE de l'UTBM
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.DepEEIcon;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DepEE extends Faction {

    public DepEE(ArrayList<Unite> unites) {
	super(1, "DepEE", unites);
	nbUnitesDepart = 25;
	IconeFaction = new DepEEIcon();
    }

    @Override
    public void pouvoirSpecial(Faction origine, Point2D.Double position) {
	pv = new PvEE("Pacifisme", position, origine);

    }

}