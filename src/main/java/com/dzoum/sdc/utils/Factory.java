package com.dzoum.sdc.utils;

import java.awt.Color;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

import com.dzoum.sdc.core.model.Segment;

public class Factory {

	private Factory() {
		// to prevent initialization
	}

	/**
	 * Create new empty mutable list.
	 */
	public static <T> MutableList<T> newList() { // Create new empty list
		return Lists.mutable.empty();
	}

	/**
	 * Create new mutable list of given parameters.
	 */
	@SuppressWarnings("unchecked")
	public static <T> MutableList<T> newList(T... of) { // Create new list of given parameters
		return Lists.mutable.of(of);
	}

	/**
	 * Create new empty immutable list.
	 */
	public static <T> ImmutableList<T> newiList() { // Create new empty list
		return Lists.immutable.empty();
	}

	/**
	 * Create new immutable list of given parameters.
	 */
	@SuppressWarnings("unchecked")
	public static <T> ImmutableList<T> newiList(T... of) {
		return Lists.immutable.of(of);
	}
	
	/**
	 * Create a new segment.
	 */
	public static Segment newSeg(int x, int y, int dx, int dy,
			int width, int height, double angleDegrees, double dangle, Color color) {
		return new Segment(x, y, dx, dy, width, height, angleDegrees, dangle, color);
	}

}
