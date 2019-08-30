package utbm.vue;

import utbm.donnees.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Panel qui affiche les informations sur les differents Joueurs : score, or et
 * cases occupees.
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * */
public class InfosAdversairePanel extends JPanel {

    /** Fichier qui permet le chargement de l'image du terrain */
    File ImageFond = new File(getClass().getResource("/images/e.png").getPath());
    // ImageIcon ii = new ImageIcon("Images/personnages/dep_ee.png");

    JLabel nomJoueurLabel;
    JLabel imageFactionLabel;
     JLabel scoreLabel;
     JLabel orLabel;
     JLabel casesOccupeesLabel;
    private Joueur joueur;

    /** Constructeur du InfosJoueurPanel */
    InfosAdversairePanel(Joueur j) {
	this.setBackground(Color.lightGray);
	// this.setPreferredSize(new Dimension(250,0));
	this.setLayout(new GridBagLayout());

	joueur = j;

	/** Instance des composants du InfosJoueurPanel */
	nomJoueurLabel = new JLabel(joueur.getNom());
	scoreLabel = new JLabel("Score : ");
	refreshScoreText();
	orLabel = new JLabel("Or : ");
	refreshOrText();
	casesOccupeesLabel = new JLabel("Cases occupees : 1");
	//refreshNbCasesOccupeesText();
	imageFactionLabel = new JLabel(j.getFaction().getIconeFaction());

	/** Affichage de la bordure du Panel */
	// this.setBorder(BorderFactory.createLineBorder(Color.black));

	/** Le nom des joueurs est en italique */
	nomJoueurLabel.setFont(new Font("Arial", Font.ITALIC, 12));

	/** Positionnement des labels */
	GridBagConstraints constraints = new GridBagConstraints();
	// constraints.insets=new Insets(10,0,10,0);

	constraints.gridy = 0;
	constraints.gridx = 1;
	this.add(nomJoueurLabel, constraints);

	// constraints.insets=new Insets(2,0,2,0);
	constraints.gridy = 1;
	constraints.gridx = 1;
	this.add(scoreLabel, constraints);
	constraints.gridx = 0;
	this.add(imageFactionLabel, constraints);

	constraints.gridy = 2;
	constraints.gridx = 1;
	this.add(orLabel, constraints);

	constraints.gridy = 3;
	constraints.gridx = 1;
	this.add(casesOccupeesLabel, constraints);
    }

    /** Setteurs des champs */
    public void refreshScoreText() {
	scoreLabel.setText("Score : " + joueur.getScore());
    }

    public void refreshOrText() {
	orLabel.setText("Or : " + joueur.getOr());
    }

    public void refreshNbCasesOccupeesText() {
	casesOccupeesLabel.setText("Cases occupees : "
		+ joueur.RetourneCombienDeCasesOccupees());
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
}
