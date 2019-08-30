/** 
 * Class représentant la faction IMSI du jeu elle même représentant le département IMSI de l'UTBM
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.DepIMSIIcon;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DepIMSI extends Faction {

    public DepIMSI(ArrayList<Unite> unites) {
	super(2, "DepIMSI", unites);
	nbUnitesDepart = 20;
	IconeFaction = new DepIMSIIcon();
    }

    @Override
    public void pouvoirSpecial(Faction origine, Point2D.Double position) {
    pv = new PvIMSI("AttaqueEclaire",  origine);
    }

}
