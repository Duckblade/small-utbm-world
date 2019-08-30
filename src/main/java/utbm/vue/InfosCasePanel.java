package utbm.vue;

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
 * 
 * */
public class InfosCasePanel extends JPanel {

    static JLabel joueurLabel;
    static JLabel attaqueLabel;
    static JLabel defenseLabel;
    static JLabel deplacementLabel;
    File ImageFond = new File(getClass().getResource("/images/c.png").getPath());

    /** Constructeur du InfosCasePanel */
    InfosCasePanel() {
	this.setBackground(Color.cyan);
	this.setPreferredSize(new Dimension(230, 180));
	this.setLayout(new GridBagLayout());

	/** Instance des composants du InfosJoueurPanel */
	joueurLabel = new JLabel("");
	attaqueLabel = new JLabel("ATK : ");
	defenseLabel = new JLabel("DEF : ");
	deplacementLabel = new JLabel("MOV : ");

	/** Affichage de la bordure du Panel */
	// this.setBorder(BorderFactory.createLineBorder(Color.black));

	/** Unite est en italique */
	joueurLabel.setFont(new Font("Arial", Font.BOLD, 12));
	attaqueLabel.setFont(new Font("Arial", Font.BOLD, 13));
	defenseLabel.setFont(new Font("Arial", Font.BOLD, 13));
	deplacementLabel.setFont(new Font("Arial", Font.BOLD, 13));

	/** Positionnement des labels */
	GridBagConstraints constraints = new GridBagConstraints();
	constraints.insets = new Insets(10, 0, 10, 0);

	constraints.gridy = 0;
	this.add(joueurLabel, constraints);

	constraints.insets = new Insets(2, 0, 2, 0);
	constraints.gridy = 1;
	this.add(attaqueLabel, constraints);

	constraints.gridy = 2;
	this.add(defenseLabel, constraints);

	constraints.gridy = 3;
	this.add(deplacementLabel, constraints);
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

    /** Set et get pour uniteLabel */

    static void setNomJoueur(String s) {
	joueurLabel.setText(s);
    }

    /** Set et get pour attaqueLabel */

    static void setAtkText(int u) {
	attaqueLabel.setText("ATK : " + u);
    }

    /** Set et get pour defenseLabel */

    static void setDefText(int u) {
	defenseLabel.setText("DEF : " + u);
    }

    /** Set et get pour deplacementLabel */

    static void setDepText(int u) {
	deplacementLabel.setText("MOV : " + u);
    }

}
