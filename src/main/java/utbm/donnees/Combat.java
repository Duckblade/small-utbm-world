/** 
 * Class permettant de definir le deroulement d'un combat
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

public class Combat {

    private Case caseCombat;
    private Unite attaquant; // joueur qui attaque (celui qui ce deplace vers)
    private Unite defenseur; // joueur qui ce defend
    private Unite gagnant; // joueur qui a gagner apres les 4 rounds
    private Unite perdant; // joueur qui a perdu aprs les 4 rounds

    public Combat(Unite attaquant, Unite defenseur, Case caseCombat) {
	this.caseCombat = caseCombat;
	this.attaquant = attaquant;
	this.defenseur = defenseur;
	gagnant = null; // aucun gagnant n'est definie en debut de partie
	perdant = null; // aucun perdant n'est definie en debut de partie

    }

    /**
     * Lance le combat entre les deux pions,attaquant et defenseur dure 4 round
     * 
     * represente le joueur qui attaque (celui qui ce deplace vers) et le
     * defenseur le joueur qui ce defend
     */
    public void lancerOffencive() {
	Unite attaquant = this.attaquant;

	Unite defenseur = this.defenseur;
	int degat; // degat effectuer par l'attaquant
	degat = attaquant.attaque(this.caseCombat);

	if (defenseur.seDefend(degat, this.caseCombat) <= 0) {

	    this.gagnant = attaquant;
	    this.perdant = defenseur;

	} else {
	    this.gagnant = defenseur;
	    this.perdant = attaquant;
	}
    }

    public Unite getGagnant() {
	return gagnant;
    }

    /**
     * Prend le perdant d'un combat
     * 
     * @return le perdant du combat
     */
    public Unite getPerdant() {
	return perdant;
    }

}
