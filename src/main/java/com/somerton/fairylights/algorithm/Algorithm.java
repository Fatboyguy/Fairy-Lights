package com.somerton.fairylights.algorithm;

import com.somerton.fairylights.model.Chain;

/**
 * The algorithm interface.
 *
 */
public interface Algorithm {
	
	public void next(Chain chain);
	public void initialize(Chain chain);
	public int getInterval();
	
}
