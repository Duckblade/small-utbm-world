package utbm.vue;

import javax.swing.ImageIcon;


public class DepMecaIcon extends ImageIcon{
	public static String filename = DepIMSIIcon.class.getResource("/images/personnages/dep_meca.png").getPath();
	public DepMecaIcon(){
		super(filename);
	}
}
