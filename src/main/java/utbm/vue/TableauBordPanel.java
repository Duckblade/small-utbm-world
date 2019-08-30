package utbm.vue;

import utbm.donnees.Joueur;
import utbm.donnees.Partie;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Panel qui represente le tableau de controle du joueur. Il contient les Panels
 * InfosCasePanel et
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * */
public class TableauBordPanel extends JPanel {

    public static Vector<JPanel> vectTabBordPanels;
    public static InfosJoueurActifPanel infosJoueurActifPanel;
    public static ActionsJoueurPanel actionsJoueurPanel;
    public static InfosCasePanel infosCasePanel;
    public static Joueur joueurActif;

    /** Constructeur du TableauBordPanel */
    public TableauBordPanel() {

	// this.setBackground(Color.DARK_GRAY);
	this.setPreferredSize(new Dimension(1000, 180));
	this.setLayout(new GridBagLayout());

	/** Instanciation des composants du tableau de bord */
	vectTabBordPanels = new Vector<JPanel>();
	infosJoueurActifPanel = new InfosJoueurActifPanel(Partie.getJoueurActif());
	actionsJoueurPanel = new ActionsJoueurPanel(
		MenuPanel.vectJoueurs.get(0));
	infosCasePanel = new InfosCasePanel();

	vectTabBordPanels.add(infosJoueurActifPanel);
	vectTabBordPanels.add(actionsJoueurPanel);
	vectTabBordPanels.add(infosCasePanel);

	/** Placement des composants */
	GridBagConstraints constraints = new GridBagConstraints();
	// constraints.insets=new Insets(-10,0,10,0);
	constraints.gridx = 0;
	this.add(infosJoueurActifPanel);
	constraints.gridx = 1;
	this.add(actionsJoueurPanel);
	constraints.gridx = 2;
	this.add(infosCasePanel);
    }

    public void refreshInfosJoueurActifPanel() {
	infosJoueurActifPanel.refreshNom();
	InfosJoueurActifPanel.refreshNumeroTour();
	infosJoueurActifPanel.refreshNbCasesOccupeesText();
	infosJoueurActifPanel.refreshOrText();
	infosJoueurActifPanel.refreshScoreText();
	infosJoueurActifPanel.refreshPowText();

    }

    public static void refreshActionsJoueurPanel() {
	ActionsJoueurPanel.reinitBoutons();
	ActionsJoueurPanel.setJoueurActif();
    }

    public ActionsJoueurPanel getActionsJoueurPanel() {
	return actionsJoueurPanel;
    }
}
