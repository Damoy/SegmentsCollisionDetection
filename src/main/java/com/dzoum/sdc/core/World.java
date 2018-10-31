package com.dzoum.sdc.core;

import org.eclipse.collections.api.list.ImmutableList;

import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.core.model.Segment;
import com.dzoum.sdc.graphics.Screen;

import java.awt.Color;
import static com.dzoum.sdc.utils.Factory.*;

public class World {

	private Core core;
	private Config config;
	private ImmutableList<Segment> segments;
	
	public World(Core core, Config config) {
		this.core = core;
		this.config = config;
		segments = newiList(newSeg(0, 0, 1, 20, Color.MAGENTA));
	}

	public void update() {
		segments.forEach(s -> s.update());
	}

	public void render(Screen s) {
		segments.forEach(seg -> seg.render(s));
	}
	
}
