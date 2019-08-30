package utbm.vue;

import utbm.AppliFrame;
import utbm.donnees.Partie;

import javax.swing.*;
import java.awt.*;

/**
 * Panel qui contient tous les autres panels de la partie : plateau, tableau de
 * bord, liste joueurs
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * 
 * */
public class PartiePanel extends JPanel {

    public static Partie partie;
    static TableauBordPanel tabBordPanel;
    static ListeJoueursPanel listeJoueursPanel;
    public static CasePanel caseSelectionnee;

    /** Constructeur du ListeJoueursPanel */
    public PartiePanel(Partie p) {

	partie = p;
	caseSelectionnee = null;
	this.setOpaque(false);
	this.setLayout(new BorderLayout());

	/** Ajout du PlateauPanel, ListeJoueursPanel et TableauBordPanel */
	tabBordPanel = new TableauBordPanel();
	listeJoueursPanel = new ListeJoueursPanel();

	this.add(partie.getPlateau().getPlateauPanel(), BorderLayout.WEST);
	this.add(listeJoueursPanel, BorderLayout.EAST);
	this.add(tabBordPanel, BorderLayout.SOUTH);
	AppliFrame.cardPanel.add(this, "partiePanel");

	/** Ajout a la frame de la vue "Partie" */
	AppliFrame.cardL.last(AppliFrame.cardPanel);

    }

    public TableauBordPanel getTabBordPanel() {
	return tabBordPanel;
    }

    /** Methode de rafraichissement des donn�es sur les panels */
    public static void refreshPanels() {
	listeJoueursPanel.refreshInfosAdversairePanel();
	tabBordPanel.refreshInfosJoueurActifPanel();
	TableauBordPanel.refreshActionsJoueurPanel();

    }

    public static CasePanel getCaseSelectionnee() {
	return caseSelectionnee;
    }

}
