/** 
 * Class représentant la faction Meca du jeu elle même représentant le département Meca de l'UTBM
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.DepMecaIcon;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DepMeca extends Faction {

    public DepMeca(ArrayList<Unite> unites) {
	super(4, "DepMeca", unites);
	nbUnitesDepart = 15;
	IconeFaction = new DepMecaIcon();
	/** Instance de la classe corresspondante en mode vue */
    }

    @Override
    public void pouvoirSpecial(Faction origine, Point2D.Double position) {
	pv = new PvMeca("ConstructionArtisanale", position, origine);

    }

}