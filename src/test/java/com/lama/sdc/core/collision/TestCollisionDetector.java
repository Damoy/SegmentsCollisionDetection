package com.lama.sdc.core.collision;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.dzoum.sdc.core.collision.CollisionDetector;
import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.core.model.Segment;

@RunWith(JUnit4.class)
public class TestCollisionDetector {

	private Config config;
	private Segment s1;
	private Segment s2;
	
	@Before
	public void setup() {
		config = new Config(null, 720, 480, 1, 0, 2, null);
	}
	
	@Test
	public void intersectTest() {
		float cx1 = 25.0f;
		float cy1 = 12.0f;
		float cx2 = 36.0f;
		float cy2 = 23.0f;
		int width = 2;
		int height = 40;
		
		s1 = new Segment(config, cx1, cy1, 0, 0, width, height, 40, 1, null);
		s2 = new Segment(config, cx2, cy2, 0, 0, width, height, 20, -1, null);
		s1.update();
		s2.update();
		
		boolean intersects = CollisionDetector.intersects(s1, s2);
		log("cx1: " + cx1 + ", cy1: " + cy1 + ", cx2: " + cx2 + ", width: " + width + ", height: " + height
				+ ", intersects: " + intersects);
		
//		int cpt = 0;
//		
//		while(cpt < 12000) {
//			if(cpt % 60 == 0) {
//				boolean intersects = CollisionDetector.intersects(s1, s2);
//				log("cx1: " + cx1 + ", cy1: " + cy1 + ", cx2: " + cx2 + ", width: " + width + ", height: " + height
//						+ ", intersects: " + intersects);
//			}
//		}
		
	}
	
	private static void log(String msg) {
		System.out.println(msg);
	}
	
}
