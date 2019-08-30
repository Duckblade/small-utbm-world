/** 
 * Class représentant une faction, qui represente les différents peuples jouable du jeu
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class Faction {

    protected int idFaction;
    protected String nomFaction;
    protected int nbUnitesDepart;
    // protected boolean Utilisable;
    // public ArrayList<Bonus> factionBonus;
    public ArrayList<Unite> myUnite;
    public PouvoirSpecial pv;
    protected ImageIcon IconeFaction;

    public Faction(int idF, String nom, /*
					 * boolean valide, ArrayList<Bonus>
					 * bonus,
					 */ArrayList<Unite> unites) {

	idFaction = idF;
	nomFaction = nom;
	// Utilisable = true;
	// factionBonus = new ArrayList<Bonus>();
	myUnite = new ArrayList<Unite>();
    }

    /*
     * public Boolean utilisable() { return Utilisable; }
     */

    public abstract void pouvoirSpecial(Faction origine, Point2D.Double position);

    /** A garder pour l'h�ritage cf DepInfo */
    public ImageIcon getIconeFaction() {
	return IconeFaction;
    }

    public String toString() {

	return nomFaction;
    }

    public PouvoirSpecial getPv() {
		return pv;
	}

	public void setPv(PouvoirSpecial pv) {
		this.pv = pv;
	}

	public ArrayList<Unite> getMyUnite() {
	return myUnite;
    }

    public void setMyUnite(ArrayList<Unite> myUnite) {
	this.myUnite = myUnite;
    }

}