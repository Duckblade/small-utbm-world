package utbm.vue;

import utbm.donnees.Joueur;
import utbm.donnees.Partie;

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
public class InfosJoueurActifPanel extends JPanel {

    File ImageFond = new File(getClass().getResource("/images/a.png").getPath());
    static JButton PouvoirButton;
    static JLabel numeroTourLabel;
    private Joueur joueurActif;
    private JLabel scoreLabel;
    private JLabel orLabel;
    private JLabel casesOccupeesLabel;
    public JLabel nomJoueurActifLabel;

    /** Constructeur du InfosCasePanel */
    InfosJoueurActifPanel(Joueur j) {
	this.setBackground(Color.orange);
	this.setPreferredSize(new Dimension(500, 180));
	this.setLayout(new GridBagLayout());

	joueurActif = j;

	/** Instance des composants du InfosJoueurActifPanel */
	nomJoueurActifLabel = new JLabel(joueurActif.getNom());
	scoreLabel = new JLabel("Score : 0");
	orLabel = new JLabel("Or : 100");
	casesOccupeesLabel = new JLabel("Cases occupees : "
		+ joueurActif.getNbCasesOccupees());
	JLabel pouvoirLabel = new JLabel("NomPouvoir");
	numeroTourLabel = new JLabel("TOUR : " + (Partie.getNbTours() + 1));

	JButton PouvoirButton = new JButton("Pouvoir de faction");
	// ImageIcon imagePouvoir = new ImageIcon("Images/Rush.png");
	// PouvoirButton.setText(null);
	// imagePouvoirLabel.setIcon(imagePouvoir);

	JLabel imageFactionLabel = new JLabel();
	// ImageIcon imageFaction = new ImageIcon("Images/FactionINFO.png");
	imageFactionLabel.setText(null);
	// imageFactionLabel.setIcon(imageFaction);

	/** Affichage de la bordure du Panel */
	// this.setBorder(BorderFactory.createLineBorder(Color.black));

	/** nomJoueur est en italique */
	nomJoueurActifLabel.setFont(new Font("Arial", Font.ITALIC, 14));

	/** Positionnement des labels */
	GridBagConstraints constraints = new GridBagConstraints();

	/** Image de Faction en haut au milieu */
	constraints.gridy = 0;
	constraints.gridx = 1;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	// constraints.weightx = 1;
	// constraints.insets=new Insets(0,70,0,0);
	this.add(imageFactionLabel, constraints);

	/** Nom du joueur au milieu, en dessous de sa faction */
	constraints.gridy = 1;
	constraints.gridx = 1;
	// constraints.insets=new Insets(0,70,15,0);
	this.add(nomJoueurActifLabel, constraints);

	/**
	 * Nom du pouvoir, suivi de l'image du bouton du pouvoir sur la m�me
	 * ligne
	 */
	constraints.gridy = 2;
	constraints.gridx = 0;
	constraints.insets = new Insets(10, 0, 0, 0);
	this.add(pouvoirLabel, constraints);

	constraints.gridy = 2;
	constraints.gridx = 2;
	constraints.insets = new Insets(10, 0, 0, 0);
	this.add(PouvoirButton, constraints);

	/** Score du joueur au milieu */
	constraints.gridy = 3;
	constraints.gridx = 0;
	constraints.insets = new Insets(0, 0, 0, 0);
	this.add(scoreLabel, constraints);

	/** Or du joueur au milieu */
	constraints.gridy = 4;
	constraints.gridx = 0;
	this.add(orLabel, constraints);

	/** Nombre de cases occupees par le joueur au milieu */
	constraints.gridy = 5;
	// constraints.gridx=0;
	this.add(casesOccupeesLabel, constraints);

	constraints.gridy = 6;
	this.add(numeroTourLabel, constraints);

    }

    public static void refreshNumeroTour() {
	numeroTourLabel.setText("TOUR : " + (Partie.getNbTours() + 1));
	// this.updateUI();
    }

    public void refreshScoreText() {
	scoreLabel.setText("Score : " + joueurActif.getScore());
    }

    public void refreshOrText() {
	orLabel.setText("Or : " + joueurActif.getOr());
    }
    
    public void refreshPowText() {
    //	PouvoirButton.setText(Partie.getJoueurActif().getFaction().getPv().getNom());
        }

    public void refreshNbCasesOccupeesText() {
	casesOccupeesLabel.setText("Cases occupees : "
		+ joueurActif.RetourneCombienDeCasesOccupees());
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

    public void refreshNom() {
	nomJoueurActifLabel.setText(Partie.getJoueurActif().getNom());
    }

}
