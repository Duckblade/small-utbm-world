package utbm.donnees;

/**
 * 
 * Declaration des pouvoirs, et methode d'activation des factions
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * 
 * */

public abstract class PouvoirSpecial extends Pouvoir {

    protected static Faction appartientA;

    public PouvoirSpecial(String name, Faction fac) {
	super(name);
	appartientA = fac;
    }

    public void activation() {
	utilisable = false;
	action();
    }

    public String getNom() {
    	return nom;
        }
    
    public abstract void action();
}