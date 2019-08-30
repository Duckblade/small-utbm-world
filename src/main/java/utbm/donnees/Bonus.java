/** 
 * Class représentant un bonus c'est à dire qu'il modifie de façon positif certain attribut d'un joueur, d'une faction ou d'une unité
 * @author David Hoeffel, Lorriette Thomas, Marconnet Benjamin, Sefiane Abdelouahab
 * 
 * */
package utbm.donnees;


public class Bonus {
    /* {src_lang=Java} */

    public int surAttaque;

    public int surDefense;

    public int surPortee;

    public int surOr;

    public int surNbrUnites;

    public Bonus(int atk, int def, int por, int or, int nbu) {
	surAttaque = atk;
	surDefense = def;
	surPortee = por;
	surOr = or;
	surNbrUnites = nbu;
    }

    public Bonus() {
	surAttaque = 0;
	surDefense = 0;
	surPortee = 0;
	surOr = 0;
	surNbrUnites = 0;
    }

}