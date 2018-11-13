package com.dzoum.sdc.utils;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;

import com.dzoum.sdc.core.World;
import com.dzoum.sdc.core.config.Config;
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
	 * Create new mutable Map of given parameters.
	 */
	public static <K, V> MutableMap<K, V> newMap() {
		return Maps.mutable.empty();
	}
	
	/**
	 * Create a new segment.
	 */
	public static Segment newSeg(Config config, World world, float x, float y, float dx, float dy,
			int width, int height, float angleDegrees, float dangle) {
		return new Segment(config, world, x, y, dx, dy, width, height, angleDegrees, dangle);
	}

}
