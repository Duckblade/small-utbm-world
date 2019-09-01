package utbm.vue;

import javax.swing.ImageIcon;


public class DepProfsIcon extends ImageIcon{
	public static String filename = DepIMSIIcon.class.getResource("/images/personnages/dep_maths.png").getPath();
	public DepProfsIcon(){
		super(filename);
	}
}


