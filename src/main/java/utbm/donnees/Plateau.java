package utbm.donnees;


/** 
 * Initialisation de toutes les cases du tableau et le plateau.
 * Permet de l'afficher, et de renvoyer ses cases.
 * 
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */


import utbm.vue.MenuPanel;
import utbm.vue.PlateauPanel;

import java.awt.geom.Point2D;
import java.util.Vector;

public class Plateau {

	// Plateau 10x14
	private String nom;
	public static Vector<Case>  vectCases;
	private PlateauPanel myPlateauPanel;
	public static int nbJ;
	public static Case caseActive;

	public Plateau() {

		initPlateau();
		
		
	}




	/* Methode qui initialise un plateau de 140 cases vides */

	public void initPlateau(){
		vectCases = new Vector<Case>();
		myPlateauPanel = new PlateauPanel(this);
		/*public Case(String nom, Boolean ea, Integer p, Point2D.Double point, Joueur estOccupePar, Boolean estQG)*/

		/*for (int i=0;i<140;i++){
			vectCases.add(new Case("TD",true,1,new Point2D.Double(0,0), null , false, this));
		}*/

		//Vector<Case> vCases = new Vector<Case>();
		
		
		for (int i = 0; i < 10; i++) {	
			for (int j = 0; j < 14; j++) {// en partant du principe qu'il y a bien 140 cases

				/** i c'est la ligne       j la colonne */
				if((i==0)&&(j==0)){
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , true, this));
				}			
				else if((i==0)&&(j==13)){
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , true, this));
				}					
				else if(MenuPanel.nombreJoueurs>=3 && ((i==9)&&(j==0))){
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , true, this));
				}
				else if(MenuPanel.nombreJoueurs==4 && ((i==9)&&(j==13))){
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , true, this));
				}
				
				
				
				else if(((j==0)||(j==1)||(j==2)||(j==11)||(j==12)||(j==13))&&(i!=3)&&(i!=4)&&(i!=5)&&(i!=6))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));

				else if((i==0)&&(j==3))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((i==1)&&(j==3))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));
				else if((i==2)&&(j==3))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((i==3)&&(j==3))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((i==3)&&(j==2))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((i==3)&&(j==1))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));
				else if((i==3)&&(j==0))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));

				else if((j==10)&&(i==3))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==11)&&(i==3))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==12)&&(i==3))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));
				else if((j==13)&&(i==3))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==10)&&(i==2))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==10)&&(i==1))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));
				else if((j==10)&&(i==0))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));

				else if((j==0)&&(i==6))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==1)&&(i==6))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));
				else if((j==2)&&(i==6))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==3)&&(i==6))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==3)&&(i==7))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==3)&&(i==8))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));
				else if((j==3)&&(i==9))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));

				else if((j==10)&&(i==6))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==11)&&(i==6))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==12)&&(i==6))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));
				else if((j==13)&&(i==6))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==10)&&(i==7))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				else if((j==10)&&(i==8))
					vectCases.add(new Case("TD",true,1,new Point2D.Double(i,j), null , false, this));
				else if((j==10)&&(i==9))
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));

				else if(j==4)
					vectCases.add(new Case("Beton",true,1,new Point2D.Double(i,j), null , false, this));
				else if(j==9)
					vectCases.add(new Case("Beton",true,1,new Point2D.Double(i,j), null , false, this));

				else if(j==6)
					vectCases.add(new Case("Amphi",true,1,new Point2D.Double(i,j), null , false, this));
				else if(j==7)
					vectCases.add(new Case("Amphi",true,1,new Point2D.Double(i,j), null , false, this));

				else 	if((((j>=0)&&(j<=4))||((j>=9)&&(j<=13)))&&((i==4)||(i==5)))
					vectCases.add(new Case("Beton",true,1,new Point2D.Double(i,j), null , false, this));

				else if(j==5)
				{
					if((i==1)||(i==8))
						vectCases.add(new Case("Amphi",true,1,new Point2D.Double(i,j), null , false, this));
					else
						vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				}

				else if(j==8)
				{
					if((i==1)||(i==8))
						vectCases.add(new Case("Amphi",true,1,new Point2D.Double(i,j), null , false, this));
					else
						vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));
				}
				else
					vectCases.add(new Case("Mur",false,1,new Point2D.Double(i,j), null , false, this));

				//myPlateauPanel.ajoutCasesPanel();


			}
		}

	}

	
	public static Case getCaseActive(){
		for (Case c : vectCases){
			if(c.getCasePanel().getSelectedStatus()==true){
				//System.out.println("Case active :"+c.occupePar.getNom());
				return caseActive = c;
			}
		}
		return null;
		
	}
	
	
	public static Case getCase(Point2D.Double position)
	{
		for (int i = 0; i < 140; i++) {
			if(vectCases.get(i).getposition()==position)
				return vectCases.get(i);

		}

		return null;
	}


	public PlateauPanel getPlateauPanel(){
		return myPlateauPanel;
	}
	
	public static Vector<Case> getCases() {
		return vectCases;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Case getCaseAt(int i){
		return vectCases.get(i);
	}

	/* Methode qui affiche le plateau, avec un chiffre pour representer la faction qui occupe la case */
	public void affichePlateau(){
		for (int i = 0; i < 140; i++){
			if(i%14 == 0)	System.out.println();
			System.out.print(vectCases.get(i).getIdFactionQuiOccupe());
		}
	}


}