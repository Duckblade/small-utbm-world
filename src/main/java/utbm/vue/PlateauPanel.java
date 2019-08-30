package utbm.vue;

import utbm.donnees.Case;
import utbm.donnees.Plateau;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel du plateau de jeu, contient des CasePanel
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * */
public class PlateauPanel extends JPanel {

    /** Tableau qui liste toutes les cases */
    static List<Case> arrayListCases = new ArrayList<Case>();
    static List<Case> casesInterditesTopList = new ArrayList<Case>();
    static List<Case> casesInterditesBottomList = new ArrayList<Case>();
    static List<Case> casesInterditesRightList = new ArrayList<Case>();
    static List<Case> casesInterditesLeftList = new ArrayList<Case>();

    // Pas vraiment besoin
    static int nombreCases;
    static int nombreJoueurs;
    private Plateau plateau;

    /** Constructeur qui permet l'instanciation de 140 CasePanel */
    public PlateauPanel(Plateau p) {

	this.setBackground(Color.GRAY);
	plateau = p;
	arrayListCases = plateau.vectCases;
	this.setPreferredSize(new Dimension(699, 0));

	/** Nombre de cases a instancier */
	// nombreCases = 140;
	// nombreJoueurs = Plateau.nbJ;

	/** Nouveau CasePanel */
	// CasePanel newCase;

	/** Utilisation du GridLayout pour PlateauPanel */
	this.setLayout(new GridLayout(10, 14));

    }

    static void flush() {
	for (Case c : PlateauPanel.arrayListCases) {
	    InfosCasePanel.setNomJoueur("");
	    InfosCasePanel.setAtkText(0);
	    InfosCasePanel.setDefText(0);
	    InfosCasePanel.setDepText(0);
	    c.getCasePanel().setBorder(BorderFactory.createEmptyBorder());
	    c.getCasePanel().instancierDeplacementUnitesFrame = false;
	    // c.getCasePanel().affichageContourHover=true;
	    c.getCasePanel().isSelected = false;
	    // c.afficherQG=false;
	    // c.getCasePanel().isSelectable=false;
	    c.getCasePanel().isDeplacable = false;
	    // nombreUnitesSurCase=0;
	    c.getCasePanel().isDestinationDeplacement = false;
	    c.getCasePanel().afficherLabel = false;
	    // c.updateUI();
	    // numCase=0;
	}

    }

    static void fflush() {
	for (Case c : PlateauPanel.arrayListCases) {
	    InfosCasePanel.setNomJoueur("");
	    InfosCasePanel.setAtkText(0);
	    InfosCasePanel.setDefText(0);
	    InfosCasePanel.setDepText(0);
	    c.getCasePanel().setBorder(BorderFactory.createEmptyBorder());
	    c.getCasePanel().instancierDeplacementUnitesFrame = false;
	    // c.getCasePanel().affichageContourHover=true;
	    c.getCasePanel().isSelected = false;
	    // c.afficherQG=false;
	    // c.getCasePanel().isSelectable=false;
	    c.getCasePanel().isDeplacable = false;
	    // nombreUnitesSurCase=0;
	    c.getCasePanel().isDestinationDeplacement = false;
	    c.getCasePanel().afficherLabel = false;
	    c.getCasePanel().deplacementDuTourEffectue = false;
	    // c.updateUI();
	    // numCase=0;
	}

    }

    public Plateau getPlateau() {
	return plateau;
    }

    /**
     * Methode permettant de d�finir les cases disponibles comme arriv�e d'un
     * d�placement, par rapport � un case s�lectionn�e
     */
    static void casesDisponiblesAuDeplacement() {

	/** Remplissage des listes */
	for (int i = 1; i < 13; i++) {
	    casesInterditesTopList.add(Plateau.vectCases.get(i));
	}

	for (int i = 127; i < 139; i++) {
	    casesInterditesBottomList.add(Plateau.vectCases.get(i));
	}

	casesInterditesRightList.add(Plateau.vectCases.get(125));
	for (int i = 27; i < 125; i = i + 14) {
	    casesInterditesRightList.add(Plateau.vectCases.get(i));
	}

	casesInterditesLeftList.add(Plateau.vectCases.get(112));
	for (int i = 14; i < 112; i = i + 14) {
	    casesInterditesLeftList.add(Plateau.vectCases.get(i));
	}

	// Parcours toutes les cases du Plateau
	for (Case c : arrayListCases) {

	    // Si la case est selectionnee et ne figure pas parmi les cases
	    // interdites.
	    if (c.getCasePanel().isSelected
		    && !c.getCasePanel().isDestinationDeplacement) {
		int indiceCaseSelectionnee = arrayListCases.indexOf(c); // Recup�ration
									// index
									// case
									// selectionnee
		int nombreUnitesSurCase = c.getCasePanel()
			.getNombreUnitesSurCase();

		// Affichage sp�cial pour les cases des coins
		if (indiceCaseSelectionnee == 0) {

		    arrayListCases.get(indiceCaseSelectionnee + 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee + 14)
			    .getCasePanel().caseDeplacable();
		}
		if (indiceCaseSelectionnee == 13) {

		    arrayListCases.get(indiceCaseSelectionnee - 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee + 14)
			    .getCasePanel().caseDeplacable();
		}
		if (indiceCaseSelectionnee == 126) {

		    arrayListCases.get(indiceCaseSelectionnee + 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee - 14)
			    .getCasePanel().caseDeplacable();
		}
		if (indiceCaseSelectionnee == 139) {

		    arrayListCases.get(indiceCaseSelectionnee - 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee - 14)
			    .getCasePanel().caseDeplacable();
		}

		// Affichage sp�cial pour les cases du haut
		if (casesInterditesTopList.contains(c)) {

		    arrayListCases.get(indiceCaseSelectionnee + 14)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee + 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee - 1)
			    .getCasePanel().caseDeplacable();
		}

		// Affichage sp�cial pour les cases du bas
		if (casesInterditesBottomList.contains(c)) {

		    arrayListCases.get(indiceCaseSelectionnee - 14)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee + 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee - 1)
			    .getCasePanel().caseDeplacable();
		}

		// Affichage sp�cial pour les cases de droite
		if (casesInterditesRightList.contains(c)) {

		    arrayListCases.get(indiceCaseSelectionnee - 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee + 14)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee - 14)
			    .getCasePanel().caseDeplacable();
		}

		// Affichage sp�cial pour les cases de gauche
		if (casesInterditesLeftList.contains(c)) {

		    arrayListCases.get(indiceCaseSelectionnee + 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee + 14)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee - 14)
			    .getCasePanel().caseDeplacable();
		}

		// arrayListCasesDeplacement.add(arrayListCases.get(indiceCaseSelectionnee+1));
		// Dans tous les autres cas
		else if (!casesInterditesLeftList.contains(c)
			&& !casesInterditesRightList.contains(c)
			&& !casesInterditesTopList.contains(c)
			&& !casesInterditesBottomList.contains(c)
			&& indiceCaseSelectionnee != 0
			&& indiceCaseSelectionnee != 13
			&& indiceCaseSelectionnee != 126
			&& indiceCaseSelectionnee != 139) {

		    arrayListCases.get(indiceCaseSelectionnee + 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee - 1)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee + 14)
			    .getCasePanel().caseDeplacable();
		    arrayListCases.get(indiceCaseSelectionnee - 14)
			    .getCasePanel().caseDeplacable();
		}
	    }
	}

    }

}
