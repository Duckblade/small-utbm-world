/** 
 * Class représentant la faction Info du jeu elle même représentant le département Info de l'UTBM
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.DepInfoIcon;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DepInfo extends Faction {

    public DepInfo(ArrayList<Unite> unites) {
	super(3, "DepInfo", unites);
	nbUnitesDepart = 20;
	IconeFaction = new DepInfoIcon();
    }

    @Override
    public void pouvoirSpecial(Faction origine, Point2D.Double position) {
    pv = new PvInfo("Terrorisme Num�rique", position, origine);
	
    }

   

}