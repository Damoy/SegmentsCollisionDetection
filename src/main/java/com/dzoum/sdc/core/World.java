package com.dzoum.sdc.core;

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
	
	public void render(Screen s) {
		segments.forEach(seg -> seg.render(s));
		s.render(String.valueOf(config.getCollisionsCount()), textX, textY);
	}
	
	public ImmutableList<Segment> getSegments(){
		return segments;
	}

}