package com.dzoum.sdc.core;

import java.awt.Color;

import org.eclipse.collections.api.list.ImmutableList;

import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.core.model.Segment;
import com.dzoum.sdc.graphics.Screen;

/**
 * Application world.
 * Contain all segments.
 */
public class World {

	private Config config;
	
	// application' segments
	private ImmutableList<Segment> segments;
	
	private int textX;
	private int textY;

	public World(Config config) {
		this.config = config;
		this.textX = config.getTextX();
		this.textY = config.getTextY();
		this.segments = Generator.generateSegments(config, this);
	}

	public void update() {
		segments.forEach(s -> s.update());
	}

	public ImmutableList<Segment> select(Segment center, float radius) {
		return segments.select(s -> s != center
				&& ((s.getCx() - center.getCx()) * (s.getCx() - center.getCx())
				+ ((s.getCy() - center.getCy()) * (s.getCy() - center.getCy())) < radius * radius));
	}
	
	private Color saveColor;
	public void render(Screen s) {
		segments.forEach(seg -> seg.render(s));
		segments.forEach(seg -> seg.renderIntersections(s));
		renderUI(s);
	}
	
	private void renderUI(Screen s) {
		saveColor = s.g().getColor();		
		s.g().setColor(config.getScreenColor());
		s.g().fillRect(textX, 
				textY - (int) (config.getTextFont().getSize() * 0.75f),
				textX + getTextCacheXOffset(),
				textY - (int) (config.getTextFont().getSize() * 1.25f));
		s.render(String.valueOf(config.getCollisionsCount()), textX, textY);
		s.g().setColor(saveColor);
	}
	
	private int getTextCacheXOffset() {
		switch((int) Math.log10(config.getCollisionsCount()) + 1) {
		case 1:
			return (int) (-config.getTextFont().getSize());
		case 2:
			return (int) (-config.getTextFont().getSize() >> 1);
		case 3:
			return (int) (config.getTextFont().getSize() * 0.05f);
		case 4:
			return (int) (config.getTextFont().getSize() * 0.5f);
		}
		
		return (int) (-config.getTextFont().getSize());
	}
	
	public ImmutableList<Segment> getSegments(){
		return segments;
	}

}