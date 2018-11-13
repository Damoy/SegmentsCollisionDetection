package com.dzoum.sdc.utils;

/**
 * Global tick counter. 
 */
public final class TickCounter {
	
	private TickCounter() {}
	
	private static int ticks = 0;
	private static boolean minute = false;
	
	public static void update() {
		++ticks;
		if(ticks >= 1800) {
			minute = true;
			ticks = 0;
		}
	}
	
	public static boolean minutePassed() {
		if(!minute) return false;
		boolean ret = minute;
		minute = false;
		return ret;
	}
}