package com.dzoum.sdc.utils;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

public class Factory {
	
	private Factory() {
		// to prevent init
	}
	
	public static <T> MutableList<T> newList(){ // Create new empty list
		return Lists.mutable.empty();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> MutableList<T> newList(T... of){ // Create new list of given parameters
		return Lists.mutable.of(of);
	}

}
