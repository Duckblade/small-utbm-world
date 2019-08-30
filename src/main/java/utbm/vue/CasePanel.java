package utbm.vue;

import utbm.donnees.Case;
import utbm.donnees.Joueur;
import utbm.donnees.Partie;
import utbm.donnees.Plateau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Panel qui repr�sente une case du plateau
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * 
 * */
public class CasePanel extends JPanel implements MouseListener {

	/** Fichier qui permet le chargement de l'image du terrain */
	File ImageFond = new File("Images/QG.png");
	File ImageBatisse = new File("Images/fort.png");
	File ImageFondTerrain;
	ImageIcon imageUnite = new ImageIcon("Images/personnages/dep_tc.png");

	/** num�ro de la case */
	int numCase;

	static Case caseSource;
	static Case caseDest;

	/** Nombre d'unites a d�placer */
	static int nombreUnitesADeplacer;

	/** A quel joueur appartient la case */
	int idJoueurSurCase;
	public static Joueur joueurActif;

	/** Case cliqu�e ou non */
	boolean isSelected;
	boolean afficherLabel;

	/** Case cliquable seulement s'il y a des unit�s dessus */
	boolean isSelectable;
	boolean afficherDeplacementsPossibles;

	/** Case ouverte a la sestination d'un d�placement ou non */
	boolean isDeplacable;

	/** Affichage du contour grossi de la case au survol */
	boolean affichageContourHover;

	/**
	 * Verrou sur l'instanciation de la fen�tre qui demande le nombre d'unit�s �
	 * d�placer
	 */
	boolean instancierDeplacementUnitesFrame;

	/** Doit-on afficher le QG sur la case ou non ? */
	public boolean afficherQG;
	public boolean afficherBatisse;

	/** La case est cliqu�e comme destination d'un d�placement */
	boolean isDestinationDeplacement;
	static boolean deplacementDuTourEffectue;

	/** Recuperation du nombre d'unites sur la case */
	public int nombreUnitesSurCase;
	static JDialog deplacementUnitesFrame;
	private Case casee;
	private PlateauPanel plateauP;

	JLabel nbUnitesLabel;

	/** Constructeur d'un CasePanel, pourvu d'une image de fond */
	public CasePanel(Case c) {

		casee = c;
		plateauP = casee.getPlateau().getPlateauPanel();

		if (casee.getNomCase() == "TD") {
			ImageFondTerrain = new File("Images/TD.png");
		}
		if (casee.getNomCase() == "Amphi") {
			ImageFondTerrain = new File("Images/Amphi.png");
		}
		if (casee.getNomCase() == "Beton") {
			ImageFondTerrain = new File("Images/Beton.png");
		}
		if (casee.getNomCase() == "Mur") {
			ImageFondTerrain = new File("Images/Mur.png");
		}

		instancierDeplacementUnitesFrame = false;
		//affichageContourHover=true;
		isSelected = false;

		if (casee.getEstQG() == true) {
			afficherQG = true;
		}

		afficherQG = false;
		afficherBatisse = false;

		isDeplacable = false;
		nombreUnitesSurCase = casee.getNombreUnites();
		isDestinationDeplacement = false;
		deplacementDuTourEffectue = false;
		numCase = 0;
		setIdOccupant();
		// idJoueurSurCase=-1;

		/** Ajout de la gestion des events souris */
		addMouseListener(this);

		/** Fond, layout et taille du CasePanel */
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(40, 40));
		this.setLayout(new GridBagLayout());

		/** Affichage de la bordure du Panel */
		// this.setBorder(BorderFactory.createLineBorder(Color.black));

		/** Instance des GridBagConstraints */
		// GridBagConstraints constraints = new GridBagConstraints();

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx=2;
		constraints.gridy=0;
		//constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets=new Insets(-15,35,0,0);
		nbUnitesLabel = new JLabel(""+nombreUnitesSurCase);
		nbUnitesLabel.setFont(new Font("Arial",Font.BOLD,12));
		nbUnitesLabel.setVisible(false);
		this.add(nbUnitesLabel,constraints);

		plateauP.add(this);

	}

	/** Methode qui permet d'afficher le nombre d'unit�s sur la case */
	void afficheNombreUnites() {
		if(nombreUnitesSurCase>0){	
			nbUnitesLabel.setText(""+nombreUnitesSurCase);
			nbUnitesLabel.setVisible(true);
		}
	}

	/** Methode retournant le nombre d'unit�s sur la case */
	int getNombreUnitesSurCase() {
		return (nombreUnitesSurCase);
	}

	/** Methode retournant la case s�lectionn�e */
	CasePanel getCaseSelectionee() {
		// if(this.isSelected){
		return (this);
		// }
	}

	/** Methode retournant la case s�lectionn�e */
	void caseDeplacable() {
		if(casee.getNomCase().equals("Mur")) {}
		else { this.setBorder(BorderFactory.createLineBorder(Color.green, 3)); }
		isDeplacable = true;
		isDestinationDeplacement = true;
	}


	/** Methode retournant la case s�lectionn�e */
	public void refreshNombreUnitesSurCase() {
		nombreUnitesSurCase = casee.getNombreUnites();
		afficheNombreUnites();
		this.repaint();
	}

	/** Methode retournant la case s�lectionn�e */
	public void setIdOccupant() {
		if (casee.getOccupePar() != null) {
			idJoueurSurCase = casee.getOccupePar().getID();
			initCase();
		} else {
			idJoueurSurCase = -1;
		}

		// this.repaint();
	}


	public boolean getSelectedStatus(){
		//System.out.println("INST "+isSelectable);
		return isSelected;
	}

	public void setSelectedStatus(boolean b){
		//System.out.println("INST "+isSelectable);
		isSelected = b;
	}

	public void initCase() {
		// System.out.println("INITCASE JA: "+MenuPanel.partie.idJoueurActif);
		// System.out.println("INITCASE JC: "+idJoueurSurCase);
		if (nombreUnitesSurCase > 0) {
			isSelectable = true;
			/** La case peut etre selectionn�e pour un d�placement */
			if (idJoueurSurCase == MenuPanel.partie.idJoueurActif
					&& nombreUnitesSurCase > 1) {
				afficherDeplacementsPossibles = true;
			} else {
				afficherDeplacementsPossibles = false;
			}
		} else {
			isSelectable = false;
			afficherDeplacementsPossibles = false;
		}

	}

	public boolean getSelectableStatus() {
		// System.out.println("INST "+isSelectable);
		return isSelectable;
	}

	/** Methode paintComponent pour l'image de fond de chaque case */
	public void paintComponent(Graphics g) {
		// System.out.println("IIOUHIUHIUHIUHH");
		super.paintComponent(g);
		BufferedImage img;

		/** Afficher l'image du QG */
		if (afficherQG == true) {
			try {
				img = ImageIO.read(ImageFond);
				g.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/** Sinon, afficher un terrain */
		else {
			try {
				img = ImageIO.read(ImageFondTerrain);
				g.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (afficherQG == false && afficherBatisse == true) {
			try {
				img = ImageIO.read(ImageBatisse);
				g.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/** Afficher le sprite des unit�s s'il y en a sur la case */
		if (nombreUnitesSurCase > 0) {

			// afficheNombreUnites();
			// try {
			casee.getOccupePar().getFaction().getIconeFaction()
			.paintIcon(this, g, 0, 0);
			// g.drawImage(img,0,0,null);
			// } //catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}

	}

	/** Impl�mentation des events souris */
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		/** Gestion de l'affichage des coutours au survol en entree de la case */
		for (Case c : Plateau.vectCases) {
			if (c.getCasePanel().isSelected) {
				affichageContourHover = false;
			}
		}
		if (affichageContourHover) {
			// JeuFrame.playSound("beep.wav"); /** Son au survol*/
			this.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		/** Gestion de l'affichage des coutours au survol en sortie de la case */
		for (Case c : Plateau.vectCases) {
			if (c.getCasePanel().isSelected) {
				affichageContourHover = false;
			}
		}
		if (affichageContourHover) {
			this.setBorder(BorderFactory.createLineBorder(Color.black, 0));
		}
	}

	/**
	 * Gestion du clic sur une case : changement de couleur des bordures et
	 * popup
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		/** Si la case est selectionnable */
		// System.out.println("JA"+MenuPanel.partie.idJoueurActif);
		// System.out.println("JC"+idJoueurSurCase);
		// System.out.println("SEL "+getSelectableStatus());

		
		if (isDestinationDeplacement) {
			// setNombreUnitesSurCase(deplacementUnitesFrame.deplacementUnitesSlider.getValue());
			// setNombreUnitesSurCase(3);
			// this.imageUnite.
			// this.validate();
			// this.nbUnitesLabel.setText(String.valueOf(this.nombreUnitesSurCase-4));
			// this.repaint();
			// deplacementUnitesFrame.casee;
			// deplacementUnitesFrame.setVisible(true);
			// this.setOpaque(false);
			deplacementDuTourEffectue = true;
			deplacementUnitesFrame = new DeplacementUnitesFrame(caseSource,
					casee);
		}
		
		
		if (getSelectableStatus() == true) {
			// System.out.println(this.joueur);
			plateauP.flush();
			InfosCasePanel.setNomJoueur(casee.occupePar.getNom());
			InfosCasePanel.setAtkText(2);
			InfosCasePanel.setDefText(2);
			InfosCasePanel.setDepText(2);
			// new InfosCasePanel(this);
			// InfosCasePanel.ajouterInfos(this);

			/** Mise � jour du statut de la case une fois qu'on clique dessus */
			this.isSelected = true;
			PartiePanel.caseSelectionnee = this;
			// nombreUnitesADeplacer=this.nombreUnitesSurCase;
			caseSource = this.casee;
			// deplacementUnitesFrame = new
			// DeplacementUnitesFrame(this,nombreUnitesSurCase);
			// deplacementUnitesFrame.setVisible(false);

			/** La case source du d�placement doit contenir des unit�s */
			// if(nombreUnitesSurCase>1){
			/** Emission d'un son a chaque clic, et passage de la case en rouge */
			// AppliFrame.playSound("sonAppuiBouton.wav");
			this.setBorder(BorderFactory.createLineBorder(Color.red, 3));

			if (deplacementDuTourEffectue != true
					&& afficherDeplacementsPossibles) {
				plateauP.casesDisponiblesAuDeplacement();
			}

			if (casee.occupePar == Partie.getJoueurActif()) {
				ActionsJoueurPanel.refreshEtatBoutons();
			} else if (casee.occupePar != Partie.getJoueurActif()) {
				ActionsJoueurPanel.reinitBoutons();
			}

		}

		

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
