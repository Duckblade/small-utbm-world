/** 
 * Class représentant la faction Profs du jeu elle même représentant les professeurs de l'UTBM
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.DepProfsIcon;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DepProfs extends Faction {

    public DepProfs(ArrayList<Unite> unites) {
	super(5, "DepProfs", unites);
	nbUnitesDepart = 10;
	IconeFaction = new DepProfsIcon();
	/** Instance de la classe corresspondante en mode vue */
    }

    @Override
    public void pouvoirSpecial(Faction origine, Point2D.Double position) {
	pv = new PvProfs("InspirationGuerriere", origine);
    }

}