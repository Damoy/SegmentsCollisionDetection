package com.dzoum.sdc.core;

import java.awt.Color;

import org.eclipse.collections.api.list.ImmutableList;

import com.dzoum.sdc.core.collision.CollisionDetector;
import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.core.model.Segment;
import com.dzoum.sdc.graphics.Screen;
import com.dzoum.sdc.utils.FloatRef;

public class World {

	private Core core;
	private Config config;
	private ImmutableList<Segment> segments;
	private float[] circles;
	
	public World(Core core, Config config) {
		this.core = core;
		this.config = config;
		segments = Generator.generateSegments(config);
		circles = new float[segments.size()];
	}

	public void update() {
		// first update segments
		segments.forEach(s -> s.update());
		
		ImmutableList<Segment> near;
		FloatRef xref = new FloatRef();
		FloatRef yref = new FloatRef();
		
		for(int i = 0; i < segments.size(); ++i) {
			near = select(segments.get(i), segments.get(i).getHeight() << 1);
			
			for(Segment n : near) {
				if(CollisionDetector.intersects(segments.get(i), n, xref, yref)) {
					circles[i >> 1] = xref.value;
					circles[(i >> 1) + 1] = yref.value;
				}
				
				xref.value = FloatRef.NULL;
				yref.value = FloatRef.NULL;
			}
		}
	}
	
	public void render(Screen s) {
		segments.forEach(seg -> seg.render(s));
		
		Color saveColor = s.g().getColor();
		s.g().setColor(Color.BLACK);
		
		for(int i = 0; i < circles.length - 1; ++i) {
			if(circles[i] != FloatRef.NULL && circles[i + 1] != FloatRef.NULL) {
				s.g().fillOval((int) circles[i], (int) circles[i + 1], 5, 5);
			}
		}
		
		s.g().setColor(saveColor);
	}
	
	public ImmutableList<Segment> select(Segment center, float radius){
		return segments.select(s -> s != center &&
				((s.getCx() - center.getCx()) * (s.getCx() - center.getCx())
				+ ((s.getCy() - center.getCy()) * (s.getCy() - center.getCy())) < radius * radius));
	}
}