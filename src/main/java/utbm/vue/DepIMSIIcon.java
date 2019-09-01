package utbm.vue;

import javax.swing.ImageIcon;



public class DepIMSIIcon extends ImageIcon{

	public static String filename = DepIMSIIcon.class.getResource("/images/personnages/dep_imsi.png").getPath();

	public DepIMSIIcon(){
		super(filename);
		;
	}
}
