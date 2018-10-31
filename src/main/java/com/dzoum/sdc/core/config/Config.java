package com.dzoum.sdc.core.config;

public class Config {

	private String appTitle;
	private int appWidth;
	private int appHeight;
	private int appScale;
	private int appScreenType;

	public Config(String appTitle, int appWidth, int appHeight, int appScale, int appScreenType) {
		this.appWidth = appWidth;
		this.appHeight = appHeight;
		this.appTitle = appTitle;
		this.appScale = appScale;
		this.appScreenType = appScreenType;
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

}