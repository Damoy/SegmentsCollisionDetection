package com.dzoum.sdc.utils;

/**
 * Used for output.
 */
public final class Output {

	private static final StringBuffer BUFFER = new StringBuffer();
	
	public static void log(String s) {
		BUFFER.append(s);
	}
	
	public static void logn(String s) {
		BUFFER.append(s);
		BUFFER.append("\n");
	}
	
	public static String get() {
		return BUFFER.toString();
	}
	
	public static String reset() {
		String content = BUFFER.toString();
		BUFFER.setLength(0);
		return content;
	}
	
	public static void averageToConsole() {
		Utils.println(average());
		Utils.println(logAverage());
		reset();
	}
	
	public static String average() {
		String content = get().trim();
		String[] lines = content.split("\n");
		String[] contentSplit;
		
		int collisionsCount = 0;
		int fps = 0;
		
		for(int i = 0; i < lines.length; ++i) {
			contentSplit = lines[i].split(";");
			collisionsCount += Integer.parseInt(contentSplit[0]);
			fps += Integer.parseInt(contentSplit[1]);
		}
		
		Utils.println("lines:" + lines.length); 
		return collisionsCount / lines.length + ";" + fps / lines.length;
	}
	
	public static String logAverage() {
		String content = get().trim();
		String[] lines = content.split("\n");
		String[] contentSplit;
		
		int collisionsCount = 0;
		int fps = 0;
		
		for(int i = 0; i < lines.length; ++i) {
			contentSplit = lines[i].split(";");
			collisionsCount += Integer.parseInt(contentSplit[0]);
			fps += Integer.parseInt(contentSplit[1]);
		}
		
		Utils.println("lines:" + lines.length); 
		return Utils.log2(collisionsCount / (float) lines.length) + ";" + Utils.log2(fps / (float) lines.length);
	}
}
