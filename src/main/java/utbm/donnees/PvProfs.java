package utbm.donnees;
/** 
 * Pouvoir de la faction Profs
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */

public class PvProfs extends PouvoirSpecial {

    public PvProfs(String name, Faction fac) {
	super(name, fac);

    }

    @Override
    public void action() {

	if (!appartientA.getMyUnite().isEmpty()) {

	    for (Unite unit : appartientA.getMyUnite()) {

		unit.setAttaque(unit.getAttaque() + 5);
		unit.setDefense(unit.getDefense() + 5);
		unit.setPortee(unit.getPortee() + 1);
	    }
	}

    }

}
