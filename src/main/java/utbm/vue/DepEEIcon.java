package utbm.vue;

import javax.swing.ImageIcon;



public class DepEEIcon extends ImageIcon{
	public static String filename = DepIMSIIcon.class.getResource("/images/personnages/dep_ee.png").getPath();
	public DepEEIcon(){
		super(filename);
	}
}