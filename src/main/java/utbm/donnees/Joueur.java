/** 
 * Class representant un joueur, c'est a dire une entiter (homme ou IA) qui joue au jeu  
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.PartiePanel;


import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Joueur {

    private static final int PRIX_UNITE = 10;
    private static final int PRIX_BATISSE = 100;
    private int numero;
    private Integer nbOr;
    private Integer score;
    private String nom;
    private Integer nbCasesOccupees;

    public Faction myFaction;
    public Vector<Pouvoir> vPouvoir;
    public ArrayList<Unite> vUnite;

    public Joueur(String name, String faction, int num) {

	numero = num;
	nom = name;
	nbOr = 100;
	score = 0;
	nbCasesOccupees = 1;
	vUnite = new ArrayList<Unite>();

	Point2D.Double posDep = null;

	switch (numero) {

	case 1:
	    posDep = new Point2D.Double(0, 0);
	    break;

	case 2:
	    posDep = new Point2D.Double(0, 13);
	    break;

	case 3:
	    posDep = new Point2D.Double(9, 0);
	    break;

	case 4:
	    posDep = new Point2D.Double(9, 13);
	    break;

	default:
	}

	if (faction == "Infos") {
	    myFaction = new DepInfo(vUnite);

	    for (int i = 0; i < myFaction.nbUnitesDepart; i++) {

		myFaction.getMyUnite().add(
			new Unite(2, 2, 2, posDep, false, myFaction));
	    }

	    myFaction.pouvoirSpecial(myFaction, posDep);
	} else if (faction == "Mecas") {
	    myFaction = new DepMeca(vUnite);

	    for (int i = 0; i < myFaction.nbUnitesDepart; i++) {

		myFaction.getMyUnite().add(
			new Unite(2, 2, 2, posDep, false, myFaction));
	    }
	    myFaction.pouvoirSpecial(myFaction, posDep);
	} else if (faction == "TC") {
	    myFaction = new DepTC(vUnite);

	    for (int i = 0; i < myFaction.nbUnitesDepart; i++) {

		myFaction.getMyUnite().add(
			new Unite(1, 1, 2, posDep, false, myFaction));
	    }

	    myFaction.pouvoirSpecial(myFaction, posDep);
	} else if (faction == "EDIM") {
	    myFaction = new DepEDIM(vUnite);

	    for (int i = 0; i < myFaction.nbUnitesDepart; i++) {

		myFaction.getMyUnite().add(
			new Unite(2, 2, 3, posDep, false, myFaction));
	    }

	    myFaction.pouvoirSpecial(myFaction, posDep);
	} else if (faction == "EE") {
	    myFaction = new DepEE(vUnite);

	    for (int i = 0; i < myFaction.nbUnitesDepart; i++) {

		myFaction.getMyUnite().add(
			new Unite(2, 2, 2, posDep, false, myFaction));
	    }

	    myFaction.pouvoirSpecial(myFaction, posDep);
	} else if (faction == "IMSI") {
	    myFaction = new DepIMSI(vUnite);

	    for (int i = 0; i < myFaction.nbUnitesDepart; i++) {

		myFaction.getMyUnite().add(
			new Unite(2, 2, 2, posDep, false, myFaction));
	    }

	    myFaction.pouvoirSpecial(myFaction, posDep);
	} else {
	    // Dernier cas, faction choisi = Profs
	    myFaction = new DepProfs(vUnite);

	    for (int i = 0; i < myFaction.nbUnitesDepart; i++) {

		myFaction.getMyUnite().add(
			new Unite(3, 4, 2, posDep, false, myFaction));
	    }

	    myFaction.pouvoirSpecial(myFaction, posDep);
	}

	vPouvoir = new Vector<Pouvoir>();
    }

    public Vector<Faction> choixFaction(Vector<Faction> vectFactions) {

	// affichage de la liste des factions dispos
	int i = 0;
	System.out.println("[Joueur : " + nom
		+ "]\n\tListe des factions disponibles :");
	for (Faction f : vectFactions) {
	    System.out.print("\t" + i + ". " + f.toString());
	    i++;
	}

	// le joueur effectue le choix de sa faction
	Scanner sChoix = new Scanner(System.in);
	System.out.println("\nNumero de la faction choisie ?");
	int choix = sChoix.nextInt();

	// elle est ajoute a la liste des factions du joueur
	// vFaction.add(vectFactions.get(choix));

	// et elle est supprim� de la liste des factions dispos
	vectFactions.remove(choix);

	return vectFactions;
    }

    public void choixPouvoir(Vector<Pouvoir> vectPouvoirs) {
	// un pouvoir est tire au hasard pour chaque joueur
	int nbAleatoire = (int) (Math.random() * vectPouvoirs.size());
	vPouvoir.add(vectPouvoirs.get(nbAleatoire));
    }

    public void actionTour() {
	System.out.println("Actions disponibles :");
	System.out.print("\t1. Deplacer unite");
	System.out.print("\t2. Acheter unite");
	System.out.print("\t3. Finir tour");

	Scanner sChoix = new Scanner(System.in);
	System.out.println("\nChoix ?");
	int choix = sChoix.nextInt();

	switch (choix) {
	case 1:
	    deplacerUnite();
	case 2:
	    acheterUnite();
	case 3:
	    break;
	default:
	    break;
	}
    }

    public void acheterUnite() {
	setOr(nbOr -= PRIX_UNITE);
	PartiePanel.refreshPanels();
	// faire apparaitre unite dans QG
    }

    public void construireBatisse() {
	nbOr -= PRIX_BATISSE;
	PartiePanel.refreshPanels();
	// faire apparaitre unite dans QG
    }

    private void deplacerUnite() {
	// TODO Auto-generated method stub

    }

    // getters et setters

    public Faction getFaction() {
	return myFaction;
    }

    public void setOr(int s) {
	nbOr = s;
    }

    public Integer getOr() {
	return nbOr;
    }

    public Integer getNbCasesOccupees() {
	return nbCasesOccupees;
    }

    public void incrNbCasesOccupees() {
	nbCasesOccupees++;
    }

    public void setScore(int s) {
	score = s;
    }

    public Integer getScore() {
	return score;
    }

    /*
     * public String toString(){ return nom + "(" + vFaction + " - " + vPouvoir
     * + ")"; }
     */

    public String getNom() {
	return nom;
    }

    public int getID() {
	int i = 0;
	for (Joueur j : Partie.vectJoueurs) {

	    if (j == this) {
		return i;
	    }
	    i++;
	}
	return -1;

    }

    /*
     * public void setFaction(Faction f){ vFaction.add(f); }
     */

    public void setNom(String name) {
	nom = name;
    }

    public int RetourneCombienDeCasesOccupees() {
	int nb = 0;
	for (int i = 0; i < Plateau.getCases().size(); i++) {
	    if (Plateau.getCases().elementAt(i).getOccupePar() == this)
		nb++;
	}
	return nb;
    }

}