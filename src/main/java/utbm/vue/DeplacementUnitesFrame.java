package utbm.vue;

import utbm.donnees.Case;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame qui apparait lorsque le joueur veut deplacer ses unites sur le plateau
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane
 *         Abdelouahab
 * */
public class DeplacementUnitesFrame extends JDialog implements ActionListener {

	Image deplacementUnitesFrameIcon = Toolkit.getDefaultToolkit().getImage(
			"Images/icon.png");
	JButton deplacementUnitesButton;
	public JSlider deplacementUnitesSlider;

	/** Case sur laquelle vont etre deplacees les nouvelles unites */
	public Case caseS;
	public Case caseD;
	int nombreUnitesSurCase;
	boolean combat;

	/**
	 * Constructeur avec omme argument le nombre d'unites total present sur la
	 * case
	 */
	public DeplacementUnitesFrame(Case cS, Case cD) {

		// si la case est un mur, le d�placement est annul�
		if (cD.getNomCase() == "Mur")	return;
		else {

			/**
			 * Le CasePanel sur lequel on a clique pour afficher la Frame est
			 * memorise
			 */
			caseD = cD;
			caseS = cS;
			combat = false;
			nombreUnitesSurCase = caseS.getNombreUnites();

			this.setSize(400, 200);
			this.setResizable(false);
			this.setIconImage(deplacementUnitesFrameIcon);
			this.setTitle("Nombre d'unites a deplacer");
			
			/* Si la case selectionne est un ennemi */
			if(caseD.occupePar != caseS.occupePar && caseD.occupePar != null){
				this.setTitle("VOUS ENTREZ EN COMBAT !!!");
				combat = true;
				
			}
			this.setLocationRelativeTo(null);
			/** Centre la fenetre */

			/** Instance du Panel general lie à la frame */
			JPanel deplacementUnitesPanel = new JPanel();
			deplacementUnitesPanel.setLayout(new GridBagLayout());
			this.setContentPane(deplacementUnitesPanel);

			/** Contraintes du GridBagLayout */
			GridBagConstraints constraints = new GridBagConstraints();

			/** Label de la frame qu demande le nombre d'unites a deplacer */
			constraints.gridy = 0;
			JLabel deplacementUnitesLabel = new JLabel(
					"Combien d'unites voulez-vous deplacer ?");
			deplacementUnitesPanel.add(deplacementUnitesLabel, constraints);

			/**
			 * Instance et parametrage du JSlider qui permet de choisir le nombre
			 * d'unites a deplacer
			 */
			constraints.gridy = 1;
			deplacementUnitesSlider = new JSlider(1, (nombreUnitesSurCase - 1));
			deplacementUnitesSlider.setPreferredSize(new Dimension(300, 60));
			deplacementUnitesSlider.setMajorTickSpacing(1);
			// deplacementUnitesSlider.setMinorTickSpacing(1);
			deplacementUnitesSlider.setPaintTicks(true);
			/** Afficher les traits dessous la barre */
			deplacementUnitesSlider.setPaintLabels(true);
			/** Afficher les labels */

			/* Definir la police des labels des MajorTicks */
			// Font font = new Font("Arial", Font.PLAIN, 12);
			// deplacementUnitesSlider.setFont(font);

			/** Ajout du deplacementUnitesSlider au Panel */
			deplacementUnitesPanel.add(deplacementUnitesSlider, constraints);

			/** Instance et placement du bouton de confirmation */
			constraints.gridy = 2;
			deplacementUnitesButton = new JButton("Ok");
			deplacementUnitesButton.addActionListener(this);
			deplacementUnitesPanel.add(deplacementUnitesButton, constraints);

			/** La frame est visible */
			this.setVisible(true);

		}
	}

	/** Gestion des events appui bouton */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == deplacementUnitesButton) {
			/**
			 * On instancie une nouvelle case avec en argument le nombre
			 * d'unites a deplacer
			 */
			// System.out.println(deplacementUnitesSlider.getValue());
			// casee = new CasePanel(deplacementUnitesSlider.getValue());
			
			caseS.setNombreUnitesSurCase(nombreUnitesSurCase
					- (deplacementUnitesSlider.getValue()));
			
			
			/** Gestion des unites lors d'un combat*/
			if(combat==true){
				if(deplacementUnitesSlider.getValue()>caseD.getNombreUnites()){
					caseD.setNombreUnitesSurCase(deplacementUnitesSlider.getValue()-caseD.getNombreUnites());
					caseD.setOccupePar(caseS.occupePar);
				}
				else if(deplacementUnitesSlider.getValue()<caseD.getNombreUnites()){
					caseD.setNombreUnitesSurCase(caseD.getNombreUnites()-deplacementUnitesSlider.getValue());
				}
				else if(deplacementUnitesSlider.getValue()==caseD.getNombreUnites()){
					caseD.setNombreUnitesSurCase(1);
					caseD.setOccupePar(caseS.occupePar);
				}
			}
			else{
				// caseD.occupePar=caseS.occupePar;
				caseD.setNombreUnitesSurCase(caseD.getNombreUnites()+deplacementUnitesSlider.getValue());
				caseD.setOccupePar(caseS.occupePar);
				//caseS.getCasePanel().removeAll();
				
				
				// caseS.afficheNombreUnites();
				// this.casee.calculNombreUnitesRestantesCase();
				
			}
			caseS.getCasePanel().repaint();
			caseD.getCasePanel().repaint();
			PlateauPanel.flush();
			this.dispose();
			
		}

	}

}
