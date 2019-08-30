package utbm.donnees;
/** 
 * Classe relatives aux unites. Contient ses differents attributs
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
import java.awt.geom.Point2D;

public class Unite {

    protected Integer attaque;

    protected Integer defense;

    protected Integer portee;

    protected Point2D.Double position;

    protected boolean aBouge;

    protected Faction maFaction;

    public Unite(int att, int def, int portee, Point2D.Double pos,
	    boolean aBouger, Faction faction) {

    }

    public int attaque(Case deroulementAtt) {

	int attFinal = attaque * deroulementAtt.getNombreUnites();

	if (deroulementAtt.DonBonus() != null) {

	    attFinal += deroulementAtt.DonBonus().surAttaque;
	}

	return attFinal;
    }

    public int seDefend(int degatRecu, Case deroulementDef) {

	return ((defense * deroulementDef.getNombreUnites() + deroulementDef
		.DonBonus().surDefense) - degatRecu);
    }

    public void deplacement(Point2D.Double position) {
    }

    public Integer getAttaque() {
	return attaque;
    }

    public void setAttaque(Integer attaque) {
	this.attaque = attaque;
    }

    public Integer getDefense() {
	return defense;
    }

    public void setDefense(Integer defense) {
	this.defense = defense;
    }

    public Integer getPortee() {
	return portee;
    }

    public void setPortee(Integer portee) {
	this.portee = portee;
    }

    public Point2D.Double getPosition() {
	return position;
    }

    public void setPosition(Point2D.Double position) {
	this.position = position;
    }

    public boolean isaBouge() {
	return aBouge;
    }

    public void setaBouge(boolean aBouge) {
	this.aBouge = aBouge;
    }

}