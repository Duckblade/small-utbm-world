package utbm.vue;

import javax.swing.ImageIcon;


public class DepMatheuxIcon extends ImageIcon{
	public static String filename = DepIMSIIcon.class.getResource("/images/personnages/dep_matheux.png").getPath();
	public DepMatheuxIcon(){
		super(filename);
	}
}