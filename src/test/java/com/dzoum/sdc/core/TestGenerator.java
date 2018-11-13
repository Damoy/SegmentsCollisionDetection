package com.dzoum.sdc.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.collections.api.list.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.core.model.Segment;

@RunWith(JUnit4.class)
public class TestGenerator {

	private Config config;
	
	private int appWidth = 720;
	private int appHeight = 480;
	private int appScale = 1;
	private int textX = (int) (appWidth * 0.1f);
	private int textY = (int) (appHeight * 0.1f);
	private int l2bound = 400;
	private int l3bound = 800;
	private	int segmentsCount = (int) Math.pow(2, 10);
	private float segDx = 2.0f;
	private float segDy = 2.0f;
	private  float segDangle = 2.0f;
	
	@Before
	public void setup() {
		appWidth = 720;
		appHeight = 480;
		appScale = 1;
		textX = (int) (appWidth * 0.1f);
		textY = (int) (appHeight * 0.1f);
		l2bound = 400;
		l3bound = 800;
		segmentsCount = (int) Math.pow(2, 10);
		segDx = 2.0f;
		segDy = 2.0f;
		segDangle = 2.0f;
		
		config = new Config(null, appWidth, appHeight, appScale, -1,
				textX, textY, l2bound, l3bound,
				segmentsCount, segDx, segDy, segDangle,
				null, null, null, null, null, null, null);		
	}
	
	@Test
	public void inScreenTest() {
		ImmutableList<Segment> segments = Generator.generateSegments(config, null);
		assertNotNull(segments);
		assertEquals(segments.size(), segmentsCount);
		
		for(Segment s : segments) {
			assertTrue(s.getCx() >= appScale && s.getCy() >= appHeight * 0.1f
					&& s.getCx() <= config.getAppWidth()
					&& s.getCy() <= config.getAppHeight());
		}
	}
	
}
