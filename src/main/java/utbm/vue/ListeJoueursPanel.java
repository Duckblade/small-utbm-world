package utbm.vue;

import utbm.donnees.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Panel qui affiche les joueurs presents. Contient des InfosJoueurPanel.
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * */
public class ListeJoueursPanel extends JPanel {

    Vector<Joueur> vectJoueurs;
    public static Vector<InfosAdversairePanel> vectorAdversairesPanels;
    File ImageFond = new File(getClass().getResource("/images/d.png").getPath());

    /** Constructeur du ListeJoueursPanel */
    ListeJoueursPanel() {
	// this.setBackground(Color.GREEN);
	vectJoueurs = MenuPanel.vectJoueurs;
	vectorAdversairesPanels = new Vector<InfosAdversairePanel>();
	this.setPreferredSize(new Dimension(288, 0));
	this.setLayout(new GridLayout(4, 0));
	
	for (Joueur j : vectJoueurs) {
	    InfosAdversairePanel newInfAdvPan = new InfosAdversairePanel(j);
	    vectorAdversairesPanels.add(newInfAdvPan);
	    this.add(newInfAdvPan);
	
	}


    }

    /** Methode paintComponent pour l'image de fond */
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

    public void refreshInfosAdversairePanel() {
		for (InfosAdversairePanel i : vectorAdversairesPanels) {
			//System.out.println("REFRSH PANEL");
		    i.refreshNbCasesOccupeesText();
		    i.refreshOrText();
		    i.refreshScoreText();
		}

    }

}
