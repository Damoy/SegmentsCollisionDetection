package com.dzoum.sdc.core.model;

import java.awt.Color;
import java.awt.Graphics2D;

import com.dzoum.sdc.graphics.Screen;

public class SaveSegment {

	private Color color;

	// center x, y
	private float cx;
	private float cy;
	
	// keep trace of extremities
	private float x1;
	private float x2;
	private float y1;
	private float y2;

	// center variations
	private float dx;
	private float dy;
	
	// sizes
	private int width;
	private int height;

	private float angleDegrees;
	private float dangle;

	public SaveSegment(float cx, float cy, float dx, float dy,
			int width, int height, float angleDegrees, float dangle, Color color) {
		this.cx = cx;
		this.cy = cy;
		this.dx = dx;
		this.dy = dy;
		this.width = width;
		this.height = height;
		this.angleDegrees = angleDegrees;
		this.dangle = dangle;
		this.color = color;
		
		// this.computeEdges();
		// System.out.println("x:" + cx + ",y:" + cy);
	}
	
	// https://stackoverflow.com/questions/12161277/how-to-rotate-a-vertex-around-a-certain-point
	
//	A translation that brings point 1 to the origin
//	Rotation around the origin by the required angle
//	A translation that brings point 1 back to its original position
	
	// https://academo.org/demos/rotation-about-point/
	// https://www.siggraph.org/education/materials/HyperGraph/modeling/mod_tran/2drota.htm
//	x' = x cos f - y sin f
//	y' = y cos f + x sin f
//	x′=xcosθ−ysinθ
//	y′=ycosθ+xsinθ
	
	

	// AntiClockwise ? 
//	newX = centerX + (point2x-centerX)*Math.cos(x) - (point2y-centerY)*Math.sin(x);
//	newY = centerY + (point2x-centerX)*Math.sin(x) + (point2y-centerY)*Math.cos(x);
	// Clockwise ? 
//	newX = centerX + ( cosX * (point2X-centerX) + sinX * (point2Y -centerY))
//	newY = centerY + ( -sinX * (point2X-centerX) + cosX * (point2Y -centerY))
	
	// Rotation anticlockwise point around point
	// p = [x, y] ; c = [a, b]
	// new point = [a + b - 1 ; x + b - a]
	// T = [cos θ; sinθ ; − sin θ ; cosθ]
	// https://math.stackexchange.com/questions/2138328/90-degree-counter-clockwise-rotation-around-a-point
	
//	x = r cos q 
//	y = r sin q
	
	public void update() {
//		double beforeAngleRads = Math.toRadians(angleDegrees);
//		x1 = (float) (height * Math.cos(beforeAngleRads));
//		y1 = (float) (height * Math.sin(beforeAngleRads));
		
		angleDegrees += dangle;
		double angleRads = Math.toRadians(angleDegrees);
		
		cx += dx;
		cy += dy;
		
		float saveCx = cx;
		float saveCy = cy;
		
		cx = (-width >> 1);
		cy = (-height >> 1);

		x1 = (float) (cx * Math.cos(angleRads) - cy * Math.sin(angleRads));
		y1 = (float) (cy * Math.cos(angleRads) + cx * Math.sin(angleRads));
		
		cx = (width >> 1);
		cy = (height >> 1);
		
		x2 = (float) (cx * Math.cos(angleRads) - cy * Math.sin(angleRads));
		y2 = (float) (cy * Math.cos(angleRads) + cx * Math.sin(angleRads));
		
		cx = saveCx;
		cy = saveCy;
		
		x1 += cx;
		y1 += cy;
		x2 += cx;
		y2 += cy;
		
		// two lines below seem good
//		x2 = (float) (cx * Math.cos(angleRads) - cy * Math.sin(angleRads)) + (width >> 1);
//		y2 = (float) (cy * Math.cos(angleRads) + cx * Math.sin(angleRads)) + (height >> 1);
//		
		
		
//		x1 = (float) (cx * -Math.cos(angleRads) + cy * -Math.sin(angleRads)) - (width >> 1);
//		y1 = (float) (cy * -Math.cos(angleRads) - cx * -Math.sin(angleRads)) - (height >> 1);
		
//		cx = (float) (cx * Math.cos(angleRads) - cy * Math.sin(angleRads));
//		cy = (float) (cy * Math.cos(angleRads) + cx * Math.sin(angleRads));
		
//		x1 = cx - (width >> 1);
//		y1 = cy - (height >> 1);
//		x2 = cx + (width >> 1);
//		y2 = cy + (height >> 1);
		
//		cx += dx;
//		cy += dy;
//		
//		double angleRads = Math.toRadians(angleDegrees);
//		float point2x = cx + dx;
//		float point2y = cy + dy;
//		
//		cx = (float) (cx + (point2x - cx) * Math.cos(angleRads) - (point2y - cy) * Math.sin(angleRads));
//		cy = (float) (cy + (point2x - cy) * Math.sin(angleRads) + (point2y - cy) * Math.cos(angleRads));
//		
//		x1 = cx - (width >> 1);
//		y1 = cy - (height >> 1);
//		x2 = cx + (width >> 1);
//		y2 = cy + (height >> 1);
		
	}
	
	private void computeEdges() {
//		double angleRads = Math.toRadians(angleDegrees);
//
//		float point2x = 
//		
//		cx = cx + (point2x - centerX) * Math.cos(x) - (point2y-centerY) * Math.sin(x);
//		cy = cy + (point2x - centerX) * Math.sin(x) + (point2y-centerY) * Math.cos(x);
		
		// left edge
//		x1 = (float) (x1 - Math.cos(angleRads) - (width >> 1));
//		y1 = (float) (y1 - Math.sin(angleRads) - (height >> 1));
//		
//		// right edge
//		x2 = (float) (x2 + Math.cos(angleRads) + (width >> 1));
//		y2 = (float) (y2 + Math.sin(angleRads) + (height >> 1));
		
		// System.out.println("x1:" + x1 + ",y1:" + y1 + ",x2:" + x2 + ",y2:" + y2);
	}
	
	public void render(Screen s) {
		Graphics2D g = s.g();
		Color savedColor = g.getColor();
		g.setColor(color);
		g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
		// g.drawLine((int) cx - width / 2, (int) cy - height / 2, (int) cx + width / 2, (int) cy + height / 2);
		g.setColor(savedColor);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getCx() {
		return cx;
	}

	public void setCx(float cx) {
		this.cx = cx;
	}

	public float getCy() {
		return cy;
	}

	public void setCy(float cy) {
		this.cy = cy;
	}

	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getX2() {
		return x2;
	}

	public void setX2(float x2) {
		this.x2 = x2;
	}

	public float getY1() {
		return y1;
	}

	public void setY1(float y1) {
		this.y1 = y1;
	}

	public float getY2() {
		return y2;
	}

	public void setY2(float y2) {
		this.y2 = y2;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getAngleDegrees() {
		return angleDegrees;
	}

	public void setAngleDegrees(float angleDegrees) {
		this.angleDegrees = angleDegrees;
	}

	public float getDangle() {
		return dangle;
	}

	public void setDangle(float dangle) {
		this.dangle = dangle;
	}

}