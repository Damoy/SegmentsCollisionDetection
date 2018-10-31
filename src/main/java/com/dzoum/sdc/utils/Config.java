package com.dzoum.sdc.utils;

public class Config {


	private int appWidth;
	private int appHeight;
	private int appScale;
	private String appTitle; 

	public Config(int appWidth, int appHeight, int appScale, String appTitle) {
		this.appWidth = appWidth;
		this.appHeight = appHeight;
		this.appTitle = appTitle;	
		this.appScale = appScale;
	}

	public int getappWidth() {
		return appWidth;
	}

	public void setappWidth(int appWidth) {
		this.appWidth = appWidth;
	}

	public int getappHeight() {
		return appHeight;
	}

	public void setappHeight(int appHeight) {
		this.appHeight = appHeight;
	}

	public String getAppTitle() {
		return appTitle;
	}

	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}

	public int getappScale() {
		return appScale;
	}

	public void setappScale(int appScale) {
		this.appScale = appScale;
	}
	
}
