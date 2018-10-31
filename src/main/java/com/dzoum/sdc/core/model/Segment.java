package com.dzoum.sdc.core.model;

import java.awt.Color;

public class Segment {
	
	private Color color;
	private int height;
	private int width;
	
	public Segment(Color color, int height, int width) {
		this.color = color;
		this.height = height;
		this.width = width;
	}
	
	public void update() {
		
	}
	
	public void render() {
		
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
