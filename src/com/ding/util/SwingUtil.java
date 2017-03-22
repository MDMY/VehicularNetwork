package com.ding.util;

//import static java.awt.Toolkit.getDefaultToolkit;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public class SwingUtil {
	public static Point centreContainer(Dimension size){
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(screenSize.width-size.width)/2;
		int y=(screenSize.height-size.height)/2;
		return new Point(x,y);
	}
}
