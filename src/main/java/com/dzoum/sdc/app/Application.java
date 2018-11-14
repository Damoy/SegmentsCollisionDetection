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
		String appTitle = "Segments intersections visualization";
		
		int appWidth = 720;
		int appHeight = 480;
		int appScale = 1;
		int appImageType = BufferedImage.TYPE_INT_RGB;
		
		int textX = (int) (appWidth * 0.1f);
		int textY = (int) (appHeight * 0.2f);
		
		// milliseconds bounds before collision color update
		int l2bound = 400;
		int l3bound = 800;
		
		// int segmentsCount = (int) Math.pow(2, 10);
		int segmentsCount = 1200;
		float segDx = 2.0f;
		float segDy = 2.0f;
		float segDangle = 2.0f;
		
		Color backgroundColor;
		Color segmentsColor;
		Color l1CollColor;
		Color l2CollColor;
		Color l3CollColor;
		Color textColor;
		
		Theme theme = Theme.PURPLE;
		
		switch(theme) {
		case PURPLE:
			// backgroundColor = new Color(216, 191, 216);
			backgroundColor = new Color(221, 160, 221);
			segmentsColor = Color.DARK_GRAY;
			l1CollColor = new Color(230, 230, 230);
			l2CollColor = Color.CYAN;
			l3CollColor = Color.BLUE;
			textColor = Color.WHITE;
			break;
		case WHITE:
			backgroundColor = Color.WHITE;
			segmentsColor = Color.BLACK;
			l1CollColor = new Color(0, 0, 255);
			l2CollColor = new Color(0, 255, 0);
			l3CollColor = new Color(255, 0, 0);
			textColor = Color.BLACK;
			break;
		case RAW:
			backgroundColor = Color.LIGHT_GRAY;
			segmentsColor = Color.DARK_GRAY;
			l1CollColor = new Color(138, 43, 226);
			l2CollColor = new Color(0, 0, 200);
			l3CollColor = new Color(255, 0, 0);
			textColor = Color.DARK_GRAY;
			break;
		case BLACK_GREEN:
			backgroundColor = Color.BLACK;
			segmentsColor = Color.GREEN;
			l1CollColor = new Color(220, 220, 220);
			l2CollColor = Color.CYAN;
			l3CollColor = Color.RED;
			textColor = Color.WHITE;
			break;
			default:
				backgroundColor = new Color(221, 160, 221);
				segmentsColor = Color.DARK_GRAY;
				l1CollColor = new Color(230, 230, 230);
				l2CollColor = Color.CYAN;
				l3CollColor = Color.BLUE;
				textColor = Color.WHITE;
		}
		
		Font textFont = new Font("Times New Roman", Font.TRUETYPE_FONT, 46);
		Config config = new Config(appTitle, appWidth, appHeight, appScale, appImageType,
				textX, textY,
				l2bound, l3bound,
				segmentsCount, segDx, segDy, segDangle,
				backgroundColor, segmentsColor, l1CollColor, l2CollColor, l3CollColor,
				textColor, textFont);
		
		// Without visualization
		// new LightCore(config).start();
		
		// With visualization
		new Core(config).start();
	}
	
	private static enum Theme {
		BLACK_GREEN, PURPLE, WHITE, RAW;
	}
	
}