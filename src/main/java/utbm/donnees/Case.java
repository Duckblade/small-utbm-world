/** 
 * Class représentant un terrain a conquérir et ou ce déroule les combats
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;

import utbm.vue.CasePanel;

import java.awt.geom.Point2D;

public class Case 
{

	private String nomCase;
	private Boolean estAccessible;
	private Integer porteeNecessaire;
	public Joueur occupePar;
	public int idJoueurOccupe;
	private Point2D.Double position;
	private CasePanel myCasePanel;
	private int nombreUnitesSurCase;
	private boolean estQG;
	private Plateau myPlateau;
	private Batisse myBatisse;
	private Plateau plateau;
	public Bonus myBonus;

	
	
	
	public Case(String nom, Boolean ea, Integer p, Point2D.Double point, Joueur estOccupePar, Boolean estQG, Plateau pl)
	{
		plateau = pl; 
		this.estQG = estQG;
		this.nomCase=nom;
		this.estAccessible=ea;
		this.porteeNecessaire=p;
		this.position=point;
		this.occupePar = estOccupePar;
		nombreUnitesSurCase=0;
		
	    if(nom.equals("TD"))
	     {
	    	 myBonus=new Bonus(0,1,0,0,0);
	     }
	    if(nom.equals("Amphi"))
	     {
	    	 myBonus=new Bonus(1,0,0,0,0);
	     }
	    if(nom.equals("Beton"))
	     {
	    	 myBonus=new Bonus(0,0,0,0,0);
	     }
	    if(nom.equals("Mur"))
	     {
	    	 myBonus=null;
	     }
	    
	    //occupePar=null;
		//nombreUnitesSurCase=1;

		myCasePanel = new CasePanel(this);
	    
	    
	    
	}
	
	
	
	
	public Bonus DonBonus()
	{
		if (this.myBatisse != null) 
		{
			return this.myBatisse.myBonus;
		} 
		else 
		{
			return this.myBonus;
		}
	}

	public void ajoutBatisse(String nomBatisse)
	{
		
		this.myBatisse=new Batisse(nomBatisse);
		myCasePanel.afficherBatisse=true;
	}

	public void removeBatisse()
	{
		this.myBatisse=null;
	}

	/* Methode definissant nombre Unit�s*/
	public void setNombreUnitesSurCase(int u){
		nombreUnitesSurCase =u;
		myCasePanel.refreshNombreUnitesSurCase();
	}


	/* Retourne l'ID de la faction qui occupe la case */
	public int getIdFactionQuiOccupe() {
		/*if (occupePar != null)
			return occupePar.getIdFaction();
		else*/
		return -1;
	}

	public Joueur getOccupePar() {
		return occupePar;
	}

	public void setOccupePar(Joueur occupePar) {
		this.occupePar = occupePar;
		this.occupePar.incrNbCasesOccupees();
		myCasePanel.setIdOccupant();
	}

	public String toString(){
		return "("+position.x+";"+position.y+")";
	}
	
	public String getNomCase(){
		return this.nomCase;
	}
	
	public  Point2D.Double getposition(){
		return this.position;
	}
	
	
	public boolean getEstQG(){
		return estQG;
	}
	
	public int getNombreUnites(){
		return nombreUnitesSurCase;
	}
	
	
	public CasePanel getCasePanel(){
		return myCasePanel;
	}
	
	public Plateau getPlateau(){
		return plateau;
	}


	

}