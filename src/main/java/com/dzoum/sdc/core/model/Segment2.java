package com.dzoum.sdc.core.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import com.dzoum.sdc.graphics.Screen;

public class Segment2 {

	private Line2D shape;
	private Color color;
	private int dx;
	private int dy;
	private int width;
	private int height;
	private double angleDegrees;
	private double dangle;

	public Segment2(int x, int y, int dx, int dy,
			int width, int height, double angleDegrees, double dangle, Color color) {
		this.shape = new Line2D.Float(x, y, x + width, y + height);
		this.dx = dx;
		this.dy = dy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.angleDegrees = angleDegrees;
		this.dangle = dangle;
	}
	
	public double x1 = 0;
	public double y1 = 0;
	public double x2 = 0;
	public double y2 = 0;

	public void update() {
		angleDegrees += dangle;
		
//		x1 += dx;
//		y1 += dy;
//		x2 = x1 * Math.cos(Math.toRadians(angleDegrees));
//		y2 = y1 * Math.sin(Math.toRadians(angleDegrees));
		
//		x' = x cos f - y sin f
//		y' = y cos f + x sin f
		
		incX(dx);
		incY(dy);
	}
	
	public void incX(double dx) {
		shape.setLine(shape.getX1() + dx, shape.getY1(),
				shape.getX1() + dx + width, shape.getY2());
	}
	
	public void incY(double dy) {
		shape.setLine(shape.getX1(), shape.getY1() + dy,
				shape.getX2(), shape.getY1() + dy + height);
	}

	public void render(Screen s) {
		Graphics2D g = s.g();
		Color savedColor = g.getColor();
		g.setColor(color);
		
		g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
		
//		g.drawLine((int) shape.getX1(), (int) shape.getY1(),
//				(int) (width + shape.getX1() + (Math.cos(Math.toRadians(angleDegrees)) * dx)),
//				(int) (height + shape.getY1() + (Math.sin(Math.toRadians(angleDegrees)) * dy)));
//		
//		g.setColor(savedColor);
		AffineTransform atSave = g.getTransform();
		AffineTransform at = AffineTransform.getRotateInstance(
				Math.toRadians(angleDegrees), shape.getX1(), shape.getY1());
		
		// Draw the rotated line
		g.draw(at.createTransformedShape(shape));
		g.setColor(savedColor);
		g.setTransform(atSave);
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public double getAngleDegrees() {
		return angleDegrees;
	}

	public void setAngleDegrees(double angleDegrees) {
		this.angleDegrees = angleDegrees;
	}

	public double getDangle() {
		return dangle;
	}

	public void setDangle(double dangle) {
		this.dangle = dangle;
	}

}

//package com.dzoum.sdc.core.model;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.geom.AffineTransform;
//import java.awt.geom.Line2D;
//
//import com.dzoum.sdc.graphics.Screen;
//
//public class Segment {
//
//	private Line2D shape;
//	private Color color;
//	private int dx;
//	private int dy;
//	private int width;
//	private int height;
//	private double angleDegrees;
//	private double dangle;
//
//	public Segment(int x, int y, int dx, int dy,
//			int width, int height, double angleDegrees, double dangle, Color color) {
//		this.shape = new Line2D.Float(x, y, x + width, y + height);
//		this.dx = dx;
//		this.dy = dy;
//		this.width = width;
//		this.height = height;
//		this.color = color;
//		this.angleDegrees = angleDegrees;
//		this.dangle = dangle;
//	}
//
//	public void update() {
//		angleDegrees += dangle;
//		incX(dx);
//		incY(dy);
//	}
//	
//	public void incX(double dx) {
//		shape.setLine(shape.getX1() + dx, shape.getY1(),
//				shape.getX1() + dx + width, shape.getY2());
//	}
//	
//	public void incY(double dy) {
//		shape.setLine(shape.getX1(), shape.getY1() + dy,
//				shape.getX2(), shape.getY1() + dy + height);
//	}
//
//	public void render(Screen s) {
//		Graphics2D g = s.g();
//		Color save = g.getColor();
//		g.setColor(color);
//		
//		AffineTransform atSave = g.getTransform();
//		AffineTransform at = AffineTransform.getRotateInstance(
//				Math.toRadians(angleDegrees), shape.getX1(), shape.getY1());
//		
//		// Draw the rotated line
//		g.draw(at.createTransformedShape(shape));
//		g.setColor(save);
//		g.setTransform(atSave);
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
//	public int getHeight() {
//		return height;
//	}
//
//	public void setHeight(int height) {
//		this.height = height;
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
//	public int getDx() {
//		return dx;
//	}
//
//	public void setDx(int dx) {
//		this.dx = dx;
//	}
//
//	public int getDy() {
//		return dy;
//	}
//
//	public void setDy(int dy) {
//		this.dy = dy;
//	}
//
//	public double getAngleDegrees() {
//		return angleDegrees;
//	}
//
//	public void setAngleDegrees(double angleDegrees) {
//		this.angleDegrees = angleDegrees;
//	}
//
//	public double getDangle() {
//		return dangle;
//	}
//
//	public void setDangle(double dangle) {
//		this.dangle = dangle;
//	}
//
//}