//package com.dzoum.sdc.core.model;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//
//import org.eclipse.collections.api.list.ImmutableList;
//import org.eclipse.collections.api.map.MutableMap;
//
//import com.dzoum.sdc.core.World;
//import com.dzoum.sdc.core.collision.CollisionDetector;
//import com.dzoum.sdc.core.config.Config;
//import com.dzoum.sdc.graphics.Screen;
//import com.dzoum.sdc.utils.Factory;
//import com.dzoum.sdc.utils.FloatRef;
//
//public class SegmentSave {
//	
//	private static class Pair<K, V> {
//		public Config config;
//		public K key;
//		public V value;
//		public long startTime;
//		
//		public Pair(Config config, K k, V v) {
//			this.config = config;
//			this.key = k;
//			this.value = v;
//			this.startTime = System.currentTimeMillis();
//		}
//		
//		public Color getColor() {
//			long collTime = System.currentTimeMillis() - startTime;
//			if(collTime > config.getL3bound())
//				return config.getL3CollColor();
//			if(collTime > config.getL2bound())
//				return config.getL2CollColor();
//			return config.getL1CollColor();
//		}
//	}
//
//	private Config config;
//	private World world;
//	private Color color;
//	private MutableMap<SegmentSave, Pair<Float, Float>> collisions;
//	private ImmutableList<SegmentSave> near;
//	private FloatRef xCollisionRef;
//	private FloatRef yCollisionRef;
//
//	// center x, y
//	private float cx;
//	private float cy;
//	
//	// keep trace of extremities
//	private float x1;
//	private float x2;
//	private float y1;
//	private float y2;
//
//	// center variations
//	private float dx;
//	private float dy;
//	
//	// sizes
//	private int width;
//	private int height;
//	private int circleRadius;
//	private int circlePosOffset;
//
//	private float angleDegrees;
//	private float dangle;
//
//	public SegmentSave(Config config, World world, float cx, float cy, float dx, float dy,
//			int width, int height, float angleDegrees, float dangle) {
//		this.config = config;
//		this.world = world;
//		this.cx = cx;
//		this.cy = cy;
//		this.dx = dx;
//		this.dy = dy;
//		this.width = width;
//		this.height = height;
//		this.circleRadius = height >> 3;
//		this.circlePosOffset = this.circleRadius >> 1;
//		this.angleDegrees = angleDegrees;
//		this.dangle = dangle;
//		this.color = config.getSegmentsColor();
//		this.collisions = Factory.newMap();
//		this.near = null;
//		this.xCollisionRef = new FloatRef();
//		this.yCollisionRef = new FloatRef();
//	}
//	
//	public void update() {
//		angleDegrees += dangle;
//		double angleRads = Math.toRadians(angleDegrees);
//		
//		checkBounds();
//		
//		cx += dx;
//		cy += dy;
//		
//		float saveCx = cx;
//		float saveCy = cy;
//		
//		cx = (-width >> 1);
//		cy = (-height >> 1);
//
//		x1 = (float) (cx * Math.cos(angleRads) - cy * Math.sin(angleRads));
//		y1 = (float) (cy * Math.cos(angleRads) + cx * Math.sin(angleRads));
//		
//		cx = -cx;
//		cy = -cy;
//		
//		x2 = (float) (cx * Math.cos(angleRads) - cy * Math.sin(angleRads));
//		y2 = (float) (cy * Math.cos(angleRads) + cx * Math.sin(angleRads));
//		
//		cx = saveCx;
//		cy = saveCy;
//		
//		x1 += cx;
//		y1 += cy;
//		x2 += cx;
//		y2 += cy;
//		
//		near = world.select(this, getHeight());
//		
//		for(SegmentSave segment : near) {
//			if(world.entryExistAlready(this, segment)) continue;
//			
//			xCollisionRef.reset();
//			yCollisionRef.reset();
//			
//			if(CollisionDetector.intersects(this, segment, xCollisionRef, yCollisionRef)) {
//				if(collisions.containsKey(segment)){
//					collisions.get(segment).key = xCollisionRef.value;
//					collisions.get(segment).value = yCollisionRef.value;
//				} else {
//					collisions.put(segment, new Pair<>(config, xCollisionRef.value, yCollisionRef.value));
//					world.addCollisionEntry(this, segment);
//					config.incCollisionsCount();
//				}
//			} else if(collisions.containsKey(segment)) {
//				collisions.remove(segment);
//				world.removeCollisionEntry(this, segment);
//				config.decCollisionsCount();
//			}
//		}
//	}
//	
//	// Check walls collisions
//	private void checkBounds() {
//		if(x1 <= 0) {
//			x1 = 0;
//			dx = -dx;
//		} else if(x1 + width >= config.getAppWidth()) {
//			x1 = config.getAppWidth() - width;
//			dx = -dx;
//		} else if(x2 <= 0) {
//			x2 = 0;
//			dx = -dx;
//		} else if(x2 + width >= config.getAppWidth()) {
//			x2 = config.getAppWidth() - width;
//			dx = -dx;
//		} 
//		
//		if(y1 <= 0) {
//			y1 = 0;
//			dy = -dy;
//		} else if(y1 >= config.getAppHeight()) {
//			y1 = config.getAppHeight() - height;
//			dy = -dy;
//		} else if(y2 <= 0) {
//			y2 = 0;
//			dy = -dy;
//		} else if(y2 >= config.getAppHeight()) {
//			y2 = config.getAppHeight();
//			dy = -dy;
//		}
//	}
//	
//	public void render(Screen s) {
//		Graphics2D g = s.g();
//		Color savedColor = g.getColor();
//		g.setColor(color);
//		g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
//		
//		collisions.values().forEach(p -> {
//			g.setColor(p.getColor());
//			g.fillOval((int) p.key.floatValue() - circlePosOffset, (int) p.value.floatValue() - circlePosOffset,
//				circleRadius, circleRadius);});
//				
//		g.setColor(savedColor);
//	}
//	
//	public Color getColor() {
//		return color;
//	}
//
//	public void setColor(Color color) {
//		this.color = color;
//	}
//
//	public float getCx() {
//		return cx;
//	}
//
//	public void setCx(float cx) {
//		this.cx = cx;
//	}
//
//	public float getCy() {
//		return cy;
//	}
//
//	public void setCy(float cy) {
//		this.cy = cy;
//	}
//
//	public float getX1() {
//		return x1;
//	}
//
//	public void setX1(float x1) {
//		this.x1 = x1;
//	}
//
//	public float getX2() {
//		return x2;
//	}
//
//	public void setX2(float x2) {
//		this.x2 = x2;
//	}
//
//	public float getY1() {
//		return y1;
//	}
//
//	public void setY1(float y1) {
//		this.y1 = y1;
//	}
//
//	public float getY2() {
//		return y2;
//	}
//
//	public void setY2(float y2) {
//		this.y2 = y2;
//	}
//
//	public float getDx() {
//		return dx;
//	}
//
//	public void setDx(float dx) {
//		this.dx = dx;
//	}
//
//	public float getDy() {
//		return dy;
//	}
//
//	public void setDy(float dy) {
//		this.dy = dy;
//	}
//
//	public int getWidth() {
//		return width;
//	}
//
//	public void setWidth(int width) {
//		this.width = width;
//	}
//
//	public int getHeight() {
//		return height;
//	}
//
//	public void setHeight(int height) {
//		this.height = height;
//	}
//
//	public float getAngleDegrees() {
//		return angleDegrees;
//	}
//
//	public void setAngleDegrees(float angleDegrees) {
//		this.angleDegrees = angleDegrees;
//	}
//
//	public float getDangle() {
//		return dangle;
//	}
//
//	public void setDangle(float dangle) {
//		this.dangle = dangle;
//	}
//
//}