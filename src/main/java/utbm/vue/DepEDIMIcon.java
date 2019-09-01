package utbm.vue;

import javax.swing.ImageIcon;


public class DepEDIMIcon extends ImageIcon{
	public static String filename = DepIMSIIcon.class.getResource("/images/personnages/dep_edim.png").getPath();

	public DepEDIMIcon(){
		super(filename);
	}
}


