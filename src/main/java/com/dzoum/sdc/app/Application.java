package com.dzoum.sdc.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

import com.dzoum.sdc.core.Core;
import com.dzoum.sdc.core.config.Config;

/**
 * 
 * Generates a new core and launch.<br>
 * 
 * @see Core
 * @see Config
 */
public class Application {

	public static void main(String[] args){
		String appTitle = "Collision visualizer";
		
		int appWidth = 720;
		int appHeight = 480;
		int appScale = 1;
		int appImageType = BufferedImage.TYPE_INT_ARGB;
		
		int textX = (int) (appWidth * 0.1f);
		int textY = (int) (appHeight * 0.1f);
		
		// milliseconds bounds before collision color update
		int l2bound = 400;
		int l3bound = 800;
		
		int segmentsCount = 8;
		float segDx = 0.75f;
		float segDy = 0.75f;
		float segDangle = 2.0f;
		
		Color backgroundColor = Color.LIGHT_GRAY;
		Color segmentsColor = Color.BLACK;
		Color l1CollColor = new Color(138, 43, 226);
		Color l2CollColor = new Color(0, 0, 0);
		Color l3CollColor = new Color(255, 0, 0);
		Color textColor = Color.WHITE;
		Font textFont = new Font("Lato", Font.PLAIN, 32);
		
		new Core(new Config(appTitle, appWidth, appHeight, appScale, appImageType,
				textX, textY,
				l2bound, l3bound,
				segmentsCount, segDx, segDy, segDangle,
				backgroundColor, segmentsColor, l1CollColor, l2CollColor, l3CollColor,
				textColor, textFont)).start();
	}
	
}