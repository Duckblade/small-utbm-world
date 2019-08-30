package utbm;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import utbm.donnees.Partie;
import utbm.vue.MenuPanel;
import utbm.vue.PartiePanel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

/**
 * Frame principale de l'interface, qui contient toutes les autres classes de la
 * vueSwing.
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * 
 * */

public class AppliFrame extends JFrame {

    /** Chargement de l'icone de la fen�tre */
    public Image frameIcon = Toolkit.getDefaultToolkit().getImage(
	    getClass().getResource("/images/icon.png").getPath());

    /** Panel qui utilisera le cardLayout */
	public static CardLayout cardL;
    public static JPanel cardPanel;

    /** Panel qui correspond � la frame de l'appli. Contient le cardPanel */
    public static JPanel framePanel;

    /** Stocke le joueur courant @disp */
    public static int joueurActif;

    /** Stocke le nombre de joueurs convi�s � la partie @disp */
    public int nbJoueurs;

    /**
     * Panel qui contient les autres panels du jeu : TableauDeBord, Plateau,
     * ListeJoueurs
     */
    public static PartiePanel partiePanel;

    /** Contructeur par defaut */
    public AppliFrame() {

	joueurActif = 1;
	/** Le joueur qui commence est toujours le joueur 1 */
	cardL = new CardLayout();

	framePanel = new JPanel(new BorderLayout());
	cardPanel = new JPanel(cardL);

	this.setSize(986, 620);
	this.setResizable(false);
	this.setIconImage(frameIcon);
	this.setTitle("Small UTBM World");
	this.setLocationRelativeTo(null);
	/** Centre la fen�tre */
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	/** Instance du Panel du Menu et de la partie */
	new MenuPanel();
	// partiePanel = new PartiePanel();

	/** Ajout aux cartes */
	// cardPanel.add(menuPanel,"menuPanel");
	// cardPanel.add(partiePanel,"partiePanel");

	/** Musique d'ambiance */
	playSound(getClass().getResource("/audio/Ecran titre.wav").getPath());

	this.setVisible(true);
	framePanel.setOpaque(false);
	framePanel.add(cardPanel);
	this.setContentPane(framePanel);
	/** La frame est occup�e par le framePanel */

    }

    /**
     * Methode principale avec instanciation de la frame
     * 
     * @param args
     */
    public static void main(String[] args) {
	/** Instance du Look and Feel personnalis� */
	try {
	    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());

	} catch (Exception e) {
	    System.err.println("Look and feel not set.");
	}

	new AppliFrame();
    }

    /**
     * Methode de lecture d'un son au format WAVE. Thread.
     * 
     * @param soundFile
     *            le nom du fichier et son chemin
     */
    public static synchronized void playSound(final String soundFile) 
    {
	new Thread(new Runnable() 
	{
	    public void run() 
	    {
		try {
		    Clip clip = AudioSystem.getClip();
		    AudioInputStream inputStream = AudioSystem
			    .getAudioInputStream(AppliFrame.class
				    .getResourceAsStream(soundFile));
		    clip.open(inputStream);
		    clip.start();
		    while(true)
		    {
		    	try {

		    		if(Partie.getJoueurActif().getFaction().toString()!=null)
		    		{
		    			clip.stop();
		    			break;
		    		}

		    		}

		    		catch (Exception ex) {


		    		}
		    }
		} 
		catch (Exception e) {
		    System.err.println(e.getMessage());
		}
	    }
	}).start();
    }

}
