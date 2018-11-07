package com.dzoum.sdc.core;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.core.model.Segment;
import static com.dzoum.sdc.utils.Factory.*;
import static com.dzoum.sdc.utils.Utils.*;

public final class Generator {

	private Generator() {}
	
	public static ImmutableList<Segment> generateSegments(Config config){
		MutableList<Segment> segments = newList();
		
		int nb = config.getSegmentsCount();
		int width = config.getAppScale();
		int height = (int) (config.getAppHeight() * 0.1);
		
		int x, y, dx, dy;
		double angleDegrees, dangle;
		
		for(int i = 0; i < nb; ++i) {
			x = irand(0, config.getAppWidth() - width);
			y = irand(0, config.getAppHeight() - height);
//			dx = ibool() ? 1 : -1;
//			dy = ibool() ? 1 : -1;
			dx = 0;
			dy = 0;
			angleDegrees = drand(0, 90);
			dangle = drand(-3, 3);
			
			while(dangle == 0) {
				dangle = drand(-3, 3);
			}
			
			segments.add(newSeg(x, y, dx, dy, width, height, angleDegrees, dangle, config.getSegmentsColor()));
		}
		
		return segments.toImmutable();
	}
}
