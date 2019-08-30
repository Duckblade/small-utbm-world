package utbm.donnees;
/** 
 * Pouvoir de la faction IMSI
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
public class PvIMSI extends PouvoirSpecial {

    public PvIMSI(String name, Faction fac) {
	super(name, fac);

    }

    @Override
    public void action() {

	if (!appartientA.getMyUnite().isEmpty()) {

	    for (Unite unit : appartientA.getMyUnite()) {

		unit.setPortee(unit.getPortee() + 3);
	    }
	}

    }

}
