package com.dzoum.sdc.core.model;

import java.awt.Color;

import com.dzoum.sdc.graphics.Screen;

public class Segment {
	
	private Color color;
	private int height;
	private int width;
	private int x;
	private int y;
		
	public Segment(Color color, int height, int width, int x, int y) {
		this.color = color;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
	}

	public void update() {
		
	}
	
	public void render(Screen s) {
		
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
