package com.dzoum.sdc.core.collision;

import com.dzoum.sdc.core.model.Segment;
import com.dzoum.sdc.utils.FloatRef;

/**
 * Collision detection related.
 */
public final class CollisionDetector {

	private CollisionDetector() {
		
	}
	
	/**
	 * Detects intersection between two segments and set references values to 
	 * collision position if there is one. 
	 */
	public static boolean intersects(Segment s1, Segment s2, FloatRef cx, FloatRef cy) {
		float p0_x = s1.getX1();
		float p0_y = s1.getY1();
		float p1_x = s1.getX2();
		float p1_y = s1.getY2();

		float p2_x = s2.getX1();
		float p2_y = s2.getY1();
		float p3_x = s2.getX2();
		float p3_y = s2.getY2();

		float s1_x = p1_x - p0_x;
		float s1_y = p1_y - p0_y;
		float s2_x = p3_x - p2_x;
		float s2_y = p3_y - p2_y;

		float s = (-s1_y * (p0_x - p2_x) + s1_x * (p0_y - p2_y)) / (-s2_x * s1_y + s1_x * s2_y);
		float t = (s2_x * (p0_y - p2_y) - s2_y * (p0_x - p2_x)) / (-s2_x * s1_y + s1_x * s2_y);

		if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
			// Collision detected
			cx.value = p0_x + (t * s1_x);
			cy.value = p0_y + (t * s1_y);
			return true;
		}

		// No collision
		return false;
	}
	
	// ---- Below: old or unused
	
	// returns true iff the line from (a,b)->(c,d) intersects with (p,q)->(r,s)
	public static boolean oldIntersect(Segment s1, Segment s2, FloatRef cx, FloatRef xy) {
		float det, gamma, lambda;
		float a = s1.getX1();
		float b = s1.getY1();
		float c = s1.getX2();
		float d = s1.getY2();
		float p = s2.getX1();
		float q = s2.getY1();
		float r = s2.getX2();
		float s = s2.getY2();

		det = (c - a) * (s - q) - (r - p) * (d - b);
		if (det == 0) {
			return false;
		} else {
			lambda = ((s - q) * (r - a) + (p - r) * (s - b)) / det;
			gamma = ((b - d) * (r - a) + (c - a) * (s - b)) / det;
			return (0 < lambda && lambda < 1) && (0 < gamma && gamma < 1);
		}
	}

	private static boolean onSegment(float x1, float y1, float x2, float y2, float x3, float y3) {
		return (x2 <= max(x1, x3) && x2 >= min(x1, x3) && y2 <= max(y1, y3) && y2 >= min(y1, y3));
	}

	private static float max(float v1, float v2) {
		return v1 > v2 ? v1 : v2;
	}

	private static float min(float v1, float v2) {
		return v1 < v2 ? v1 : v2;
	}

	private static int orientation(float x1, float y1, float x2, float y2, float x3, float y3) {
		int val = (int) ((y2 - y1) * (x3 - x2) - (x2 - x1) * (y3 - y2));

		if (val == 0)
			return 0; // colinear

		// orientationValue = val;
		return (val > 0) ? 1 : 2; // clock or counterclock wise
	}
	
	// private static int orientationValue = 0;

	public static boolean intersectsDontKnowWhere(Segment s1, Segment s2) {
		// Find the four orientations needed for general and
		// special cases
		float x1 = s1.getX1();
		float y1 = s1.getY1();
		float x2 = s1.getX2();
		float y2 = s1.getY2();
		float x3 = s2.getX1();
		float y3 = s2.getY1();
		float x4 = s2.getX2();
		float y4 = s2.getY2();

		int o1 = orientation(x1, y1, x2, y2, x3, y3);
		// int o1value = orientationValue;
		
		int o2 = orientation(x1, y1, x2, y2, x4, y4);
		// int o2value = orientationValue;
		
		int o3 = orientation(x3, y3, x4, y4, x1, y1);
		// int o3value = orientationValue;
		
		int o4 = orientation(x3, y3, x4, y4, x2, y2);
		// int o4value = orientationValue;

		// General case
		if (o1 != o2 && o3 != o4)
			return true;

		// Special Cases
		if (o1 == 0 && onSegment(x1, y1, x2, y2, x3, y3))
			return true;

		if (o2 == 0 && onSegment(x1, y1, x4, y4, x2, y2))
			return true;

		if (o3 == 0 && onSegment(x3, y3, x1, y1, x4, y4))
			return true;

		if (o4 == 0 && onSegment(x3, y3, x2, y2, x4, y4))
			return true;

		return false;
	}

}
