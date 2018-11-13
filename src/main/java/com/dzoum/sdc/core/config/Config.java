package com.dzoum.sdc.core.config;

import java.awt.Color;
import java.awt.Font;

/**
 * Whole application configuration container.
 */
public class Config {

	private String appTitle;
	private Color screenColor;
	private Color segmentsColor;
	private Color l1CollColor;
	private Color l2CollColor;
	private Color l3CollColor;
	private Color textColor;
	private Font textFont;

	private int appWidth;
	private int appHeight;
	private int appScale;
	private int appScreenType;
	
	private int textX;
	private int textY;
	
	private int l2bound;
	private int l3bound;
	
	private int segmentsCount;
	private int collisionsCount;
	private float segDx;
	private float segDy;
	private float segDangle;

	public Config(String appTitle, int appWidth, int appHeight, int appScale, int appScreenType,
			int textX, int textY, int l2bound, int l3bound,
			int segmentsCount, float segDx, float segDy, float segDangle,
			Color screenColor, Color segmentsColor, Color l1CollColor,
			Color l2CollColor, Color l3CollColor,
			Color textColor, Font textFont) {
		this.appWidth = appWidth;
		this.appHeight = appHeight;
		this.appTitle = appTitle;
		this.appScale = appScale;
		this.appScreenType = appScreenType;
		this.textX = textX;
		this.textY = textY;
		this.l2bound = l2bound;
		this.l3bound = l3bound;
		this.segmentsCount = segmentsCount;
		this.collisionsCount = 0;
		this.segDx = segDx;
		this.segDy = segDy;
		this.segDangle = segDangle;
		this.screenColor = screenColor;
		this.segmentsColor = segmentsColor;
		this.l1CollColor = l1CollColor;
		this.l2CollColor = l2CollColor;
		this.l3CollColor = l3CollColor;
		this.textColor = textColor;
		this.textFont = textFont;
	}

	public String getAppTitle() {
		return appTitle;
	}

	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}

	public Color getScreenColor() {
		return screenColor;
	}

	public void setScreenColor(Color screenColor) {
		this.screenColor = screenColor;
	}

	public Color getSegmentsColor() {
		return segmentsColor;
	}

	public void setSegmentsColor(Color segmentsColor) {
		this.segmentsColor = segmentsColor;
	}

	public Color getL1CollColor() {
		return l1CollColor;
	}

	public void setL1CollColor(Color l1CollColor) {
		this.l1CollColor = l1CollColor;
	}

	public Color getL2CollColor() {
		return l2CollColor;
	}

	public void setL2CollColor(Color l2CollColor) {
		this.l2CollColor = l2CollColor;
	}

	public Color getL3CollColor() {
		return l3CollColor;
	}

	public void setL3CollColor(Color l3CollColor) {
		this.l3CollColor = l3CollColor;
	}

	public int getAppWidth() {
		return appWidth;
	}

	public void setAppWidth(int appWidth) {
		this.appWidth = appWidth;
	}

	public int getAppHeight() {
		return appHeight;
	}

	public void setAppHeight(int appHeight) {
		this.appHeight = appHeight;
	}

	public int getAppScale() {
		return appScale;
	}

	public void setAppScale(int appScale) {
		this.appScale = appScale;
	}

	public int getAppScreenType() {
		return appScreenType;
	}

	public void setAppScreenType(int appScreenType) {
		this.appScreenType = appScreenType;
	}

	public int getSegmentsCount() {
		return segmentsCount;
	}

	public void setSegmentsCount(int segmentsCount) {
		this.segmentsCount = segmentsCount;
	}

	public float getSegDx() {
		return segDx;
	}

	public void setSegDx(float segDx) {
		this.segDx = segDx;
	}

	public float getSegDy() {
		return segDy;
	}

	public void setSegDy(float segDy) {
		this.segDy = segDy;
	}

	public float getSegDangle() {
		return segDangle;
	}

	public void setSegDangle(float segDangle) {
		this.segDangle = segDangle;
	}

	public int getL2bound() {
		return l2bound;
	}

	public void setL2bound(int l2bound) {
		this.l2bound = l2bound;
	}

	public int getL3bound() {
		return l3bound;
	}

	public void setL3bound(int l3bound) {
		this.l3bound = l3bound;
	}
	
	public void incCollisionsCount() {
		++this.collisionsCount;
	}
	
	public void decCollisionsCount() {
		--this.collisionsCount;
	}
	
	public int getCollisionsCount() {
		return collisionsCount;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public Font getTextFont() {
		return textFont;
	}

	public void setTextFont(Font textFont) {
		this.textFont = textFont;
	}

	public void setCollisionsCount(int collisionsCount) {
		this.collisionsCount = collisionsCount;
	}

	public int getTextX() {
		return textX;
	}

	public void setTextX(int textX) {
		this.textX = textX;
	}

	public int getTextY() {
		return textY;
	}

	public void setTextY(int textY) {
		this.textY = textY;
	}
	
}