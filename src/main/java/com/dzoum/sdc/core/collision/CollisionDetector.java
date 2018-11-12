package com.dzoum.sdc.core.collision;

import com.dzoum.sdc.core.model.Segment;
import com.dzoum.sdc.utils.FloatRef;

public final class CollisionDetector {

	private CollisionDetector() {
	}

	// returns true iff the line from (a,b)->(c,d) intersects with (p,q)->(r,s)
	public static boolean intersects(Segment s1, Segment s2) {
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

	// (x - center_x)^2 + (y - center_y)^2 < radius^2
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

}
