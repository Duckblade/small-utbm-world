/** 
 * Class représentant une batisse, qui est un element d'une case conférant des bonus au unités présent dans la case
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;


public class Batisse 
{

  private Integer coutConstruction;
  private Integer coutEntretien;
  public String typeBatisse;
  public Bonus myBonus;



public Batisse(String nomBatisse)
{
     typeBatisse=nomBatisse;
    
     if(nomBatisse.equals("QG"))
     {
    	 coutConstruction=0;
    	 coutEntretien=0;
    	 myBonus=new Bonus(3,4,0,0,0);
     }
     else if(nomBatisse.equals("fortin"))
     {
    	 coutConstruction=50;
    	 coutEntretien=20;
    	 myBonus=new Bonus(0,2,0,0,0);
     }
     else if(nomBatisse.equals("garage"))
     {
    	 coutConstruction=40;
    	 coutEntretien=15;
    	 myBonus=new Bonus(1,3,0,0,0);
     }
}

}