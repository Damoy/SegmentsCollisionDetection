package com.dzoum.sdc.core.model;

import java.awt.Color;

import com.dzoum.sdc.graphics.Screen;

public class Segment {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;

	public Segment(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public void update() {
		++x;
		++y;
	}

	public void render(Screen s) {
		s.renderLine(x, y, width, height, color);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

}
