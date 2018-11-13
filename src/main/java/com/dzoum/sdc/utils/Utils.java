package com.dzoum.sdc.utils;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Utils {
	
// 	public static Color COLLISION_COLOR = new Color(138, 43, 226);
	public static Color COLLISION_COLOR = Color.RED;

	private static Random SEED = new Random();

	private Utils() {
	}

	public static void randomize() {
		SEED = new Random();
	}

	public static void setRandomSeed(long seed) {
		SEED = new Random(seed);
	}

	/**
	 * Assert a condition.
	 * 
	 * @param cond   the condition to check
	 * @param err    message to throw
	 * @param eclazz exception class to use
	 */
	public static void assertTrue(boolean cond, String err, Class<? extends Exception> eclazz) {
		if (!cond) {
			try {
				Constructor<? extends Exception> ce = eclazz.getConstructor(String.class);
				ce.newInstance(err);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	public static <T> void println(T o) {
		System.out.println(o.toString());
	}

	public static <T> void print(T o) {
		System.out.print(o.toString());
	}

	/**
	 * Get random integer in range [min,max].
	 */
	public static int irand(int min, int max) {
		return SEED.nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Get random doouble in range [min,max].
	 */
	public static double drand(double min, double max) {
		return min + (max - min) * SEED.nextDouble();
	}
	
	/**
	 * Get random float in range [min,max].
	 */
	public static float frand(double min, double max) {
		return (float) (min + (max - min) * SEED.nextFloat());
	}
	
	/**
	 * Get random boolean.
	 */
	public static boolean ibool() {
		return SEED.nextBoolean();
	}

	/**
	 * Get log2 of inquired value.
	 */
	public static double log2(double value) {
		return Math.log10(value) / Math.log10(2);
	}

	/**
	 * Write some content to a file. Overrides the file if it exists.
	 * 
	 * @param title   the file title
	 * @param content the text to write
	 */
	public static void writeToFile(String title, String extension, String content) {
		title = filterTitle(title);
		title = "./res/bench/" + title;
		File file = new File(title);

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int compareInts(int v1, int v2) {
		return v1 > v2 ? 1 : v1 == v2 ? 0 : -1;
	}

	private static String filterTitle(String title) {
		return title.replaceAll("[ *$^!;:,=)('\"&]", "_");
	}

	public static final class Pair<A, B> {
		public final A first;
		public final B second;

		public Pair(A first, B second) {
			this.first = first;
			this.second = second;
		}
	}
}
