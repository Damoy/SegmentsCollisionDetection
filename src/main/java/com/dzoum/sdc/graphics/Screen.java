package com.dzoum.sdc.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.dzoum.sdc.core.Core;

public class Screen {
	
	private BufferedImage content;
	private Graphics2D g;
	private Core core;
	private Config config;
	
	public Screen(Core core, Config config) {
		this.core = core;
		this.config = config;
		this.content = new BufferedImage(config.getGameWidth(), config.getGameHeight(), config.getImageType());
		this.g = (Graphics2D) this.content.getGraphics();	
	}
	
	public void render() {
		Graphics g2 = core.getGraphics();
		g2.drawImage(content, 0, 0, config.getGameWidth() * config.getGameScale(), config.getGameHeight() * config.getGameScale(), null);
		g2.dispose();
	}
	
	public void render(BufferedImage image, int x, int y) {
		g.drawImage(image, x, y, null);
	}
	
	public void render(String text, int x, int y) {
		g.drawString(text, x, y);
	}
	
	public void colorize(Color color) {
		g.setColor(color);
		g.fillRect(0, 0, config.getGameWidth(), config.getGameHeight());
	}

}
