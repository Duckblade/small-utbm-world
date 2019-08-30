package utbm.donnees;

/** 
 * Initialise les bonus
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */

public class Pouvoir {

    protected String nom;
    protected boolean utilisable;
    // protected int tempsRecharge;
    // protected int recharge; temps de recharche a decrémanter à 0 repasse au
    // temps max
    protected Bonus bonus;

    public Pouvoir(String name) {
	nom = name;
	utilisable = true;
	bonus = new Bonus();
    }

    public Pouvoir(String name, int atk, int def, int p, int or, int nbu) {
	nom = name;
	utilisable = true;
	bonus = new Bonus(atk, def, p, or, nbu);
    }

    public String getNom() {
	return nom;
    }

    public String toString() {
	return nom;
    }

}