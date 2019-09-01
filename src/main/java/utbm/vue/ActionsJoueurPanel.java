/** 
 * Panel qui affiche les informations sur les differents Joueurs : score, or et cases occupees.
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */

package utbm.vue;

import utbm.donnees.Case;
import utbm.donnees.Joueur;
import utbm.donnees.Partie;
import utbm.donnees.Plateau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ActionsJoueurPanel extends JPanel implements ActionListener {

    JButton finirTourButton;
    File ImageFond = new File(getClass().getResource("/images/b.png").getPath());
    static Joueur joueurActif;
    static JButton achatUnitesButton;
    static JButton constrBatisseButton;

    /** Constructeur du ActionsJoueurPanel */
    public ActionsJoueurPanel(Joueur j) {
	joueurActif = j;
	this.setBackground(Color.pink);
	this.setPreferredSize(new Dimension(250, 180));
	this.setLayout(new GridBagLayout());

	/** Instance des composants du InfosJoueurPanel */
	achatUnitesButton = new JButton("Acheter des Unites (10 PO)");
	achatUnitesButton.addActionListener(this);
	
	constrBatisseButton = new JButton("Construire une Batisse (100 PO)");
	constrBatisseButton.addActionListener(this);

	/** Les boutons sont par defaut disabled */
	//constrBatisseButton.setEnabled(false);
	//achatUnitesButton.setEnabled(false);

	finirTourButton = new JButton("FINIR TOUR");
	finirTourButton.addActionListener(this);

	/** Affichage de la bordure du Panel */
	// this.setBorder(BorderFactory.createLineBorder(Color.black));

	/** Positionnement des bouttons */
	GridBagConstraints constraints = new GridBagConstraints();
	constraints.insets = new Insets(10, 0, 10, 0);

	constraints.gridy = 0;
	this.add(achatUnitesButton, constraints);

	// constraints.insets=new Insets(2,0,2,0);
	constraints.gridy = 1;
	this.add(constrBatisseButton, constraints);

	constraints.gridy = 2;
	this.add(finirTourButton, constraints);

    }

    public static void setJoueurActif() {
	joueurActif = Partie.getJoueurActif();
	System.out.println(joueurActif.getNom());
    }

    public static void refreshEtatBoutons() {

		//System.out.println("OCCUPE PAR " +Plateau.getCaseActive().occupePar.getNom());
    	if(Plateau.getCaseActive().occupePar == Partie.getJoueurActif()){
    		constrBatisseButton.setEnabled(true);
    		achatUnitesButton.setEnabled(true);
    		if(Plateau.getCaseActive().getCasePanel().afficherQG){
    			constrBatisseButton.setEnabled(false);
    		}
    	}
    	else if(Plateau.getCaseActive().occupePar != Partie.getJoueurActif()){
    		constrBatisseButton.setEnabled(false);
    		achatUnitesButton.setEnabled(false);
    	}
	
		if (joueurActif.getOr() < 10) {
		    achatUnitesButton.setEnabled(false);
		}
		if (joueurActif.getOr() < 100) {
		    constrBatisseButton.setEnabled(false);
		}

    }

    /** Methode paintComponent pour l'image de fond de chaque case */
    public void paintComponent(Graphics g) {
	BufferedImage img;
	try {
	    img = ImageIO.read(ImageFond);
	    g.drawImage(img, 0, 0, null);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	Object source = arg0.getSource();

	if (source == achatUnitesButton) {
		//PlateauPanel.flush();
	    joueurActif.acheterUnite();
	    refreshEtatBoutons();
	    //Plateau.getCaseActive().getNombreUnitesSurCase();
	    int nbUnitesCases = Plateau.getCaseActive().getNombreUnites();
	    nbUnitesCases++;
	    Plateau.getCaseActive().setNombreUnitesSurCase(nbUnitesCases);
	    //Plateau.getCaseActive().getCasePanel().refreshNombreUnitesSurCase();
	    //getCaseSelectionnee().setNombreUnitesSurCase++;
	}

	if (source == constrBatisseButton) {
		joueurActif.construireBatisse();
		refreshEtatBoutons();
	    PartiePanel.getCaseSelectionnee().afficherBatisse = true;
	    PartiePanel.getCaseSelectionnee().repaint();
	    // getCaseSelectionnee().imageFond=fort.png;
	}

	if (source == finirTourButton) {
	    Partie.nouveauTour();
	    Partie.myPartiePanel.refreshPanels();
	    for (Case c : Plateau.vectCases) {
		c.getCasePanel().initCase();
	    }
	    PlateauPanel.fflush();
	}

    }

    public static void reinitBoutons() {
    	constrBatisseButton.setEnabled(false);
    	achatUnitesButton.setEnabled(false);

    }
}
