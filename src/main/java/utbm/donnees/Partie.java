package utbm.donnees;

/** 
 * Place les joueurs sur le carte
 * Gere egalement les nouveaux tours et le calcul des scores
 * Affiche les joueurs, factions, scores, joueurs
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */

import utbm.vue.PartiePanel;

import java.util.Vector;

public class Partie {

	// attributs
	private static Integer nbTours;
	public static Plateau plateau;
	public static Vector<Joueur> vectJoueurs;
	public static Vector<Pouvoir> vectPouvoirs;
	public static Vector<Faction> vectFactions;
	public static Boolean pacifisme;
	//joueur actif @David
	public static int idJoueurActif = 0;
	public static Joueur joueurActif;
	public static PartiePanel myPartiePanel;


	// constructeur par defaut
	public Partie(Plateau p, Vector<Joueur> vJ, Vector<Pouvoir> vP, Vector<Faction> vF) {
		nbTours =0;
		plateau = p;
		idJoueurActif=0;
		vectJoueurs = vJ;
		setJoueurActif();
		vectPouvoirs = vP;
		vectFactions = vF;
		myPartiePanel = new PartiePanel(this);
		
		/** Placement des joueurs sur les cases*/
		plateau.getCaseAt(0).setNombreUnitesSurCase(20);
		plateau.getCaseAt(0).setOccupePar(vectJoueurs.get(0));
		plateau.getCaseAt(0).getCasePanel().afficherQG=true;
		
		plateau.getCaseAt(13).setNombreUnitesSurCase(20);
		plateau.getCaseAt(13).setOccupePar(vectJoueurs.get(1));
		plateau.getCaseAt(13).getCasePanel().afficherQG=true;
					
		if(getNombreJoueurs()>=3){
			plateau.getCaseAt(126).setNombreUnitesSurCase(20);
			plateau.getCaseAt(126).setOccupePar(vectJoueurs.get(2));
			plateau.getCaseAt(126).getCasePanel().afficherQG=true;
				
		}
		if(getNombreJoueurs()>=4){
			plateau.getCaseAt(139).setNombreUnitesSurCase(20);
			plateau.getCaseAt(139).setOccupePar(vectJoueurs.get(3));
			plateau.getCaseAt(139).getCasePanel().afficherQG=true;
		}
	
		
		
		
	}
	

	public int getNombreJoueurs(){
		return vectJoueurs.size();
	}
	
	public static Joueur getJoueurActif(){
		return vectJoueurs.get(idJoueurActif);
	}
	
	public static void setJoueurActif(){
		joueurActif = vectJoueurs.get(idJoueurActif);
	}
	

	public void afficheInfos() {
		//System.out.println(toString());
	}

	public static void nouveauTour() {
		//System.out.println("[Tour : " + nbTours + "]");				
			
			if(idJoueurActif==((vectJoueurs.size()-1))){
				idJoueurActif=0;
			}
			else{
				idJoueurActif++;
			}
			setJoueurActif();
			//System.out.println("ID joueur acti : " + idJoueurActif);

		
		calculerScore();
		nbTours++;
	}

	/*
	 * Pour chaque case, on recupere le joueur qui l'occupe
	 * et on incr�mente le score du joueur
	 */
	public static void calculerScore() {

		for(Case c : Plateau.vectCases){
			Joueur joueurQuiOccupe = c.getOccupePar();
			
			for (Joueur j : vectJoueurs){	// pour chaque joueur
					if (j.equals(joueurQuiOccupe)) {
						//System.out.println("\t+1 pour " + j.getNom() + " (occupation de la case " + c.toString() +")");
						j.setOr(j.getOr() + 1);
						j.setScore(j.getScore() + j.getOr());
					}
			}
		}
		
	}

	// Afficheurs

	void afficheJoueurs() {
		System.out.println("Liste des joueurs : ");
		for (Joueur j : vectJoueurs) {
			System.out.print(j.toString() + "\t");
		}
	}

	void afficheFactions() {
		System.out.println("Faction(s) dispo(s) : ");
		for (Faction f : vectFactions) {
			System.out.print(f.toString() + "\t");
		}
	}

	void affichePouvoirs() {
		System.out.println("Pouvoir(s) dispo(s) : ");
		for (Pouvoir p : vectPouvoirs) {
			System.out.print(p.toString() + "\t");
		}
	}
	
	void afficheScore() {
		System.out.println("Scores :");
		for(Joueur j : vectJoueurs){
			System.out.println("\t" + j.toString() + " - " + j.getScore());
		}
	}


	// Getters, setters et toString

	public static Plateau getPlateau(){
		return plateau;
	}
	
	public static PartiePanel getPartiePanel(){
		return myPartiePanel;
	}
	
	public String toString() {

		String txt = "Partie sur le plateau '" + plateau.getNom();
		txt += "', nombre de tours : " + nbTours + "\n";
		txt += "\t Joueurs : " + vectJoueurs + "\n";
		txt += "\t Pouvoirs : " + vectPouvoirs + "\n";
		txt += "\t Factions restantes : " + vectFactions + "\n";
		return txt;
	}


	public static Integer getNbTours() {
		return nbTours;
	}

	// main !

	/*public static void main(String[] args) {

		int nbJoueurs;
		Vector<Joueur> vectJoueurs = new Vector<Joueur>();
		Vector<Faction> vectFactions = new Vector<Faction>();
		Vector<Pouvoir> vectPouvoirs = new Vector<Pouvoir>();

		// init temporaire
		nbJoueurs = 2;
		vectFactions.add(new DepInfo(0));	
		vectFactions.add(new DepMeca(1));
		vectFactions.add(new DepEE(4));
		vectPouvoirs.add(new Pouvoir("Rush", 0, 1, 2, 3, 4));
		vectPouvoirs.add(new Pouvoir("Rush2"));
		vectPouvoirs.add(new Pouvoir("Rush3"));


		// choix du plateau
		//plateau = new Plateau("Belfort UTBM");
		
		// Lire le nom de chaque joueur, et les ajoute a la liste des joueurs
		//		
		//		for (int i = 0; i < nbJoueurs; i++) {
		//			Scanner sNomJoueur = new Scanner(System.in);
		//			System.out.println("Nom du joueur ? ");
		//			Joueur tmp = new Joueur(sNomJoueur.nextLine());
		//			vectJoueurs.add(tmp);
		//		}

		// version tempo pour ne pas avoir a taper les noms
		Joueur tmp1 = new Joueur("j1");
		Joueur tmp2 = new Joueur("j2");
		vectJoueurs.add(tmp1);
		vectJoueurs.add(tmp2);


		// chaque joueur choisit sa faction
		for (Joueur j : vectJoueurs){
			j.choixFaction(vectFactions);
			j.choixPouvoir(vectPouvoirs);
		}

		// et enfin, on initialise une nouvelle partie
		Partie p = new Partie(plateau, vectJoueurs, vectPouvoirs, vectFactions);
		
	   plateau.affichePlateau();
		
		p.afficheFactions();
		p.afficheInfos();
		
		 crea d'un tour pour la phase de test
		p.nouveauTour();
		 p.nouveauTour();
		
		 p.afficheScore();
	}*/


}