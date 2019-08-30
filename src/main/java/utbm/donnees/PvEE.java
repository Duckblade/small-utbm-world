package utbm.donnees;
/** 
 * Pouvoir de la faction EE
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
import java.awt.geom.Point2D;

public class PvEE extends PouvoirSpecial {

    Point2D.Double position;

    public PvEE(String name, Point2D.Double position, Faction fac) {
	super(name, fac);
	this.position = position;
    }

    
    
    //
    //
    //	Attention, faut se servir de la variable pour empecher le combat dans la vue TODO TODO TODO TODO TODO TODO :D
    //
    
    @Override
    public void action() {
    	Partie.pacifisme=true;
}}
    

    
