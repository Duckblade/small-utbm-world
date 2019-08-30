package utbm.vue;

import utbm.AppliFrame;
import utbm.donnees.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Panel qui affiche le menu principal. Offre cr�ation joueurs. Instancie la
 * partie et toutes les donn�es du jeu.
 * 
 * @author David Hoeffel
 * 
 * */
public class MenuPanel extends JPanel implements ActionListener {

    /** Declaration champs */
    private JButton jouerButton, validerNbJoueurs;
    private static JComboBox nbJoueursList;
    public static JComboBox nomFactionsList;
    public static JTextField nomJoueur;
    private GridBagConstraints constraints;
    File ImageFond = new File(getClass().getResource("/images/MainMenuPic2.png").getPath());

    /**
     * Stocke de facon temporaire les champs de textes instanci�s par nombre de
     * joueurs pour ensuite r�cup�rer le nom des joueurs lorsqu'on appui sur
     * "Jouer"
     */
    public static List<JTextField> arrayListNomJoueurs;
    public static List<JComboBox> arrayListCBFaction;
    public static int nombreJoueurs;

    /** Panels */
    public static ListeJoueursPanel listeJoueursPanel;
    public static TableauBordPanel tableauBordPanel;

    /** Variables statiques pour les donn�es */
    public static Partie partie;
    public static Plateau plateau;

    public static Vector<Joueur> vectJoueurs;
    public static Vector<Pouvoir> vectPouvoirs;
    public static Vector<Faction> vectFactions;

    public static String[] tabFactionsPossibles = { "Infos", "Mecas", "TC",
	    "EDIM", "EE", "IMSI", "Profs" };
    public static Integer[] tabNbJoueursPossibles = { 2, 3, 4 };

    /** Constructeur du MenuPanel */
    public MenuPanel() {

	// AppliFrame.playSound(soundFile);
	this.setLayout(new GridBagLayout());

	/** Instance vector static qui contient toutes les instances de Joueurs */
	vectJoueurs = new Vector<Joueur>();

	/** ArrayList tempo pour les TextFields des Joueurs */
	arrayListNomJoueurs = new ArrayList<JTextField>();
	arrayListCBFaction = new ArrayList<JComboBox>();

	/** Instance de la DDL et Label pour choisir le nombre de joueurs */
	JLabel nbJoueursLabel = new JLabel("Nombre de joueurs : ");

	nbJoueursList = new JComboBox(tabNbJoueursPossibles);

	/** Instance des boutons */
	validerNbJoueurs = new JButton("OK");
	validerNbJoueurs.addActionListener(this);
	jouerButton = new JButton("Jouer !");
	jouerButton.setEnabled(false);
	/** On ne peut pas jouer tant qu'on n'a pas d�fini le nombre de joueurs */
	jouerButton.addActionListener(this);

	/** Positionnement des bouttons */
	constraints = new GridBagConstraints();
	constraints.insets = new Insets(-100, 0, 0, 0);
	/** Permet d'a�rer les champs */

	constraints.gridy = 0;
	constraints.gridx = 0;
	nbJoueursLabel.setFont(new Font("Arial", Font.BOLD, 11));
	this.add(nbJoueursLabel, constraints);

	constraints.gridy = 0;
	constraints.gridx = 1;
	this.add(nbJoueursList, constraints);

	constraints.gridy = 0;
	constraints.gridx = 2;
	this.add(validerNbJoueurs, constraints);

	constraints.insets = new Insets(50, 0, 0, 0);
	/** Permet d'a�rer les champs */
	constraints.gridy = 6;
	constraints.gridx = 1;
	this.add(jouerButton, constraints);
	// constraints.insets = new Insets(-50, 0, 0, 0); /** Permet d'a�rer les
	// champs*/

	/** Ajout de lui meme au cardPanel general */
	AppliFrame.cardPanel.add(this, "menuPanel");

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

    /** Getteurs */
    public static Partie getPartie() {
	return partie;
    }

    public static Plateau getPlateau() {
	return plateau;
    }

    public String getFactionSelectionee(int i) {
	return ((String) arrayListCBFaction.get(i).getSelectedItem());
    }

    public String getNomJoueur(int i) {
	return ((String) arrayListNomJoueurs.get(i).getText());
    }

    public Joueur getJoueur(int i) {
	return (vectJoueurs.get(i));
    }

    /** Gestion des boutons */
    @Override
    public void actionPerformed(ActionEvent arg0) {
	Object source = arg0.getSource();
	/** Recuperation de la source de l'event */

	/** Si il y a appui sur "OK" */
	if (source == validerNbJoueurs) {

	    constraints.gridy = 1;

	    /** Stockage nombre joueurs apres cast du String de DDL en int */
	    nombreJoueurs = (Integer) nbJoueursList.getItemAt(nbJoueursList
		    .getSelectedIndex());

	    // int j=100;
	    // constraints.insets = new Insets (0,0,0,0);

	    /** Instance des DDL et champs de texte */
	    for (int i = 0; i < nombreJoueurs; i++) {

		constraints.insets = new Insets(10, 0, 0, 0);
		/** Permet d'a�rer les champs */
		/** Positionnement et ajout champs */
		constraints.gridy++;
		constraints.gridx = 0;
		JLabel labelJoueur = new JLabel("Nom du Joueur " + (i + 1)
			+ " : ");
		/** On commence � Joueur 1 */
		this.add(labelJoueur, constraints);

		constraints.gridx = 1;
		nomJoueur = new JTextField("Joueur" + (i + 1), 6);
		arrayListNomJoueurs.add(nomJoueur);
		this.add(nomJoueur, constraints);

		constraints.gridx = 2;
		nomFactionsList = new JComboBox(tabFactionsPossibles);
		arrayListCBFaction.add(nomFactionsList);
		this.add(nomFactionsList, constraints);
		// j=j+30;

		/**
		 * Permet d'afficher les champs de textes qu'on vient d'ajouter
		 * au Panel
		 */

	    }
	    this.updateUI();

	    /** On ne modifie plus le nb joueurs, on peut d�buter une partie */
	    validerNbJoueurs.setEnabled(false);
	    nbJoueursList.setEnabled(false);
	    jouerButton.setEnabled(true);

	}

	/** Si il y a appui sur "Jouer" */
	if (source == jouerButton) {
	    vectFactions = new Vector<Faction>();
	    vectPouvoirs = new Vector<Pouvoir>();

	    for (int i = 0; i < nombreJoueurs; i++) {

		vectJoueurs.add(new Joueur(getNomJoueur(i),
			getFactionSelectionee(i), i));

	    }

	    plateau = new Plateau();
	    partie = new Partie(plateau, vectJoueurs, vectPouvoirs,
		    vectFactions);
	   
	 playzik();   
	}
	
    }
	
	
	    public static synchronized void playzik() 
	    {
	    // Musiques du jeu !
	    new Thread(new Runnable() { 
		    public void run() {
		        try {
		        	
		          Clip clip = AudioSystem.getClip();
		          String factionencours=Partie.getJoueurActif().getFaction().toString();System.out.println(factionencours);
		          String factionavant=Partie.getJoueurActif().getFaction().toString();
		          AudioInputStream inputStream;
		          
		      if( factionencours=="DepEDIM") inputStream = AudioSystem.getAudioInputStream(AppliFrame.class.getResourceAsStream("EDIM.wav"));
		      
		      	else if( factionencours=="DepEE") inputStream = AudioSystem.getAudioInputStream(AppliFrame.class.getResourceAsStream("EE.wav"));
		      
		      		else if( factionencours=="DepIMSI") inputStream = AudioSystem.getAudioInputStream(AppliFrame.class.getResourceAsStream("IMSI.wav"));
		      
		      			else if( factionencours=="DepInfo") inputStream = AudioSystem.getAudioInputStream(AppliFrame.class.getResourceAsStream("Info.wav"));
		      
		      				else if( factionencours=="DepProfs") inputStream = AudioSystem.getAudioInputStream(AppliFrame.class.getResourceAsStream("Profs.wav"));
		      
		      					else if( factionencours=="DepTC") inputStream = AudioSystem.getAudioInputStream(AppliFrame.class.getResourceAsStream("TC.wav"));
		      
		      						else  inputStream = AudioSystem.getAudioInputStream(AppliFrame.class.getResourceAsStream("MECA.wav"));
		        			     	    
		          clip.open(inputStream);
		          clip.start(); 
		          
		          while(true)
		          {	  
		        	  factionencours=Partie.getJoueurActif().getFaction().toString();
		        	  if( factionencours=="DepEDIM")
		        	  {
		        		  if(factionavant==factionencours){}else{
		        		  clip.close();
		        		  clip.open(AudioSystem.getAudioInputStream( AppliFrame.class.getResourceAsStream("EDIM.wav")));
		        		  clip.start();
		        		  factionavant=Partie.getJoueurActif().getFaction().toString();
		        	  }}
		        	  if( factionencours=="DepEE")
		        	  {
		        		  if(factionavant==factionencours){}else{
			        	  clip.close();
		        		  clip.open(AudioSystem.getAudioInputStream( AppliFrame.class.getResourceAsStream("EE.wav")));
		        		  clip.start();
		        		  factionavant=Partie.getJoueurActif().getFaction().toString();
		        	  }}
		        	  if( factionencours=="DepIMSI")
		        	  {
		        		  if(factionavant==factionencours){}else{
			        	  clip.close();
		        		  clip.open(AudioSystem.getAudioInputStream( AppliFrame.class.getResourceAsStream("IMSI.wav")));
		        		  clip.start();
		        		  factionavant=Partie.getJoueurActif().getFaction().toString();
		        	  }}
		        	  if( factionencours=="DepInfo")
		        	  {
		        		  if(factionavant==factionencours){}else{
			        	  clip.close();
		        		  clip.open(AudioSystem.getAudioInputStream( AppliFrame.class.getResourceAsStream("Info.wav")));
		        		  clip.start();
		        		  factionavant=Partie.getJoueurActif().getFaction().toString();
		        	  }}
		        	  if( factionencours=="DepProfs")
		        	  {
		        		  if(factionavant==factionencours){}else{
			        	  clip.close();
		        		  clip.open(AudioSystem.getAudioInputStream( AppliFrame.class.getResourceAsStream("Profs.wav")));
		        		  clip.start();
		        		  factionavant=Partie.getJoueurActif().getFaction().toString();
		        	  }}
		        	  if( factionencours=="DepTC")
		        	  {
		        		  if(factionavant==factionencours){}else{
			        	  clip.close();
		        		  clip.open(AudioSystem.getAudioInputStream( AppliFrame.class.getResourceAsStream("TC.wav")));
		        		  clip.start();
		        		  factionavant=Partie.getJoueurActif().getFaction().toString();
		        	  }}
		        	  if( factionencours=="DepMeca")
		        	  {
		        		  if(factionavant==factionencours){}else{
			        	  clip.close();
		        		  clip.open(AudioSystem.getAudioInputStream( AppliFrame.class.getResourceAsStream("MECA.wav")));
		        		  clip.start();
		        		  factionavant=Partie.getJoueurActif().getFaction().toString();
		        	  }}
		          }
		        } catch (Exception e) {
		          System.err.println(e.getMessage());
		        }
		      }
		    }).start();
		  
	}

    

}
