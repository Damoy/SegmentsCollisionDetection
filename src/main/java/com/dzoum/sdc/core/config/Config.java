package com.dzoum.sdc.core.config;

import java.awt.Color;

public class Config {

	private String appTitle;
	private int appWidth;
	private int appHeight;
	private int appScale;
	private int appScreenType;
	private int segmentsCount;
	private Color segmentsColor;

	public Config(String appTitle, int appWidth, int appHeight, int appScale, int appScreenType,
			int segmentsCount, Color segmentsColor) {
		this.appWidth = appWidth;
		this.appHeight = appHeight;
		this.appTitle = appTitle;
		this.appScale = appScale;
		this.appScreenType = appScreenType;
		this.segmentsCount = segmentsCount;
		this.segmentsColor = segmentsColor;
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

	public String getAppTitle() {
		return appTitle;
	}

	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
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

	public Color getSegmentsColor() {
		return segmentsColor;
	}

	public void setSegmentsColor(Color segmentsColor) {
		this.segmentsColor = segmentsColor;
	}

}