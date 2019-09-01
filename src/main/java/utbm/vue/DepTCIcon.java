package utbm.vue;

import javax.swing.ImageIcon;


public class DepTCIcon extends ImageIcon{
	public static String filename = DepIMSIIcon.class.getResource("/images/personnages/dep_tc.png").getPath();
	public DepTCIcon(){
		super(filename);
	}
}
