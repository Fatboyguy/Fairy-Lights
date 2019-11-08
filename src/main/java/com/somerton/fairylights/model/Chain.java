package com.somerton.fairylights.model;

import java.util.List;

/**
 * The Chain interface.
 *
 */
public interface Chain {
	
	public int getLength();
	public int getCurrent();
	public void setCurrent(int current);
	public Light get(int index);
	public void add(Light light);
	public List<Light> getLights();

}
