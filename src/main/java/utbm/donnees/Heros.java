/** 
 * Class representant une unite special, car ayant un bonus qu'y aide les autres unites
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import java.awt.geom.Point2D.Double;


public class Heros extends Unite {

	private Aura myAura;
	
	public Heros(int att, int def, int portee, Double pos, boolean aBouger,
			String label, Faction faction, Aura mA) {
		super(att, def, portee, pos, aBouger, faction);
		myAura = mA;
	}


}