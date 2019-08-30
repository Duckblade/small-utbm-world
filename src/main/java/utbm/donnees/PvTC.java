package utbm.donnees;
/** 
 * Pouvoir de la faction TC
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class PvTC extends PouvoirSpecial {

    public PvTC(String name, Faction fac) {
	super(name, fac);
    }

    @Override
    public void action() {

	int de = (int) Math.random() * 10;

	if (de < 9) {

	    for (int i = 0; i < 15; i++) {

		appartientA.getMyUnite().add(
			new Unite(2, 2, 2, new Point2D.Double(0, 0), false,
				appartientA));

	    }

	} else {

	    if (!appartientA.getMyUnite().isEmpty()) {

		ArrayList<Integer> dejaSup = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++) {

		    int hasard = (int) Math.random() * 10;

		    while (dejaSup.contains(hasard)) {

			hasard = (int) Math.random() * 10;
		    }
		    dejaSup.add(hasard);
		    appartientA.getMyUnite().remove(hasard);
		}
	    }

	}

    }
}
