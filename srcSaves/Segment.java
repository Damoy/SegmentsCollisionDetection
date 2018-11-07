package com.dzoum.sdc.core.model;

import java.awt.Color;

import com.dzoum.sdc.graphics.Screen;
import com.dzoum.sdc.utils.Vector2i;

public class Segment {

	private Vector2i pos;
	private Color color;
	private int dx;
	private int dy;
	private int width;
	private int height;
	private double angleDegrees;
	private double dangle;

	public Segment(int x, int y, int dx, int dy,
			int width, int height, double angleDegrees, double dangle, Color color) {
		this.pos = new Vector2i(x, y);
		this.dx = dx;
		this.dy = dy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.angleDegrees = angleDegrees;
		this.dangle = dangle;
	}

	public void update() {
		angleDegrees += dangle;
		pos.incX(dx);
		pos.incY(dy);
	}

	public void render(Screen s) {
		s.renderLine(pos.getX(), pos.getY(), width, height, angleDegrees, color);
	}
	
	public Vector2i getPos() {
		return pos;
	}

	public int getX() {
		return pos.getX();
	}

	public int getY() {
		return pos.getY();
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

	public void setPos(Vector2i pos) {
		this.pos = pos;
	}

}
