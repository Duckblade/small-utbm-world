package utbm.vue;

import javax.swing.ImageIcon;


public class DepInfoIcon extends ImageIcon{
	public static String filename = DepIMSIIcon.class.getResource("/images/personnages/dep_info.png").getPath();	public DepInfoIcon(){
		super(filename);
		//Faction.vectFactionsImages.add(0,this); 
	}
}
