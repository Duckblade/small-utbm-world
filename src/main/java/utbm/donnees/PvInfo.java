package utbm.donnees;
/** 
 * Pouvoir de la faction
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
import java.awt.geom.Point2D;

public class PvInfo extends PouvoirSpecial {

    Point2D.Double position;

    public PvInfo(String name, Point2D.Double position, Faction fac) {
	super(name, fac);
	this.position = position;
    }

    
    
    //
    //
    //	ATTENTION!
    //  DANS LA CLASE QUI SUIT, plateau.getCase(position) DOIT ETRE REMPLACE PAR 
    //  LA CASE QUE LE JOUEUR CIBLERA! TODO TODO TODO TODO TODO TODO :D
    //
    
    @Override
    public void action() {
	Plateau.getCase(position).removeBatisse();
	for(int i = 0; i <= Plateau.getCase(position).occupePar.vUnite.size(); i++)
	{
		if(Plateau.getCase(position).occupePar.vUnite.get(i).getPosition()==Plateau.getCase(position).getposition())
		{
			Plateau.getCase(position).occupePar.vUnite.remove(i);
		}
	}
	for(int i = 0; i <= Plateau.vectCases.size(); i++)
	{
		if(Plateau.vectCases.get(i).getposition()==Plateau.getCase(position).getposition())
		{
			Point2D.Double position=new Point2D.Double();
			position=Plateau.vectCases.get(i).getposition();
			Case newcase=new Case("Beton",true,1,position, null , false,Partie.plateau);
			Plateau.vectCases.set(i,newcase);
		}
	}
}}
    

    
