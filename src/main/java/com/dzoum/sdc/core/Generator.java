package com.dzoum.sdc.core;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.core.model.Segment;
import static com.dzoum.sdc.utils.Factory.*;
import static com.dzoum.sdc.utils.Utils.*;

public final class Generator {

	private Generator() {}
	
	public static ImmutableList<Segment> generateSegments(Config config, World world){
		MutableList<Segment> segments = newList();
		
		int nb = config.getSegmentsCount();
		int width = config.getAppScale();
		int height = (int) (config.getAppHeight() * 0.1);
		
		float x, y, dx, dy, angleDegrees, dangle;
		
		for(int i = 0; i < nb; ++i) {
			x = frand(width, config.getAppWidth() - width);
			y = frand(height, config.getAppHeight() - height);
			dx = ibool() ? 1 : -1;
			dy = ibool() ? 1 : -1;
			
			angleDegrees = frand(0, 90);
			dangle = frand(-3, 3);
			
			while(dangle == 0) {
				dangle = frand(-3, 3);
			}
			
			segments.add(newSeg(config, world, x, y, dx, dy,
					width, height, angleDegrees, dangle));
		}
		
		return segments.toImmutable();
	}
}
