package utbm.donnees;
/** 
 * Pouvoir de la faction EDIM
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
import java.awt.geom.Point2D;

public class PvEDIM extends PouvoirSpecial {

    Point2D.Double position;

    public PvEDIM(String name,  Faction fac) {
	super(name, fac);
    }

    @Override
    public void action() {
    	for(int i = 0; i <= Partie.vectJoueurs.size(); i++)
    	{
    	  if(Partie.vectJoueurs.get(i).myFaction.nomFaction=="depEDIM")
    	  {
    		  Partie.vectJoueurs.get(i).setOr( Partie.vectJoueurs.get(i).getOr()+ Partie.vectJoueurs.get(i).vUnite.size()*5);
    		  
    	  }
    	}
    }

}
