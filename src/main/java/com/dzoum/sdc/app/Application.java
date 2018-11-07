package com.dzoum.sdc.app;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.dzoum.sdc.core.Core;
import com.dzoum.sdc.core.config.Config;

public class Application {

	public static void main(String[] args){
		new Core(new Config("Collision visualizer", 720, 480, 1,
				BufferedImage.TYPE_INT_ARGB, 100, Color.BLUE)).start();
	}
	
}