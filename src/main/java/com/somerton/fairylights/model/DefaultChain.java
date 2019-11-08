package com.somerton.fairylights.model;

import java.util.ArrayList;
import java.util.List;

import com.somerton.fairylights.Colours;

/**
 * The default chain as specified.
 * 
 * For future consideration and with more time I would
 * define this in a properties/JSON file to allow
 * for different chains.
 *
 */
public class DefaultChain implements Chain {

	private List<Light> lights = new ArrayList<Light>();

	private int current;

	public DefaultChain() {

		for (int i = 0; i < 6; i++) {
			add(new Light(Colours.RED));
			add(new Light(Colours.GREEN));
			add(new Light(Colours.WHITE));
		}

		add(new Light(Colours.RED));
		add(new Light(Colours.GREEN));
		current = 0;

	}

	public void add(Light light) {
		this.lights.add(light);
	}

	public int getLength() {
		return lights.size();
	}

	public Light get(int index) {
		return lights.get(index);
	}

	public List<Light> getLights() {
		return lights;
	}

	@Override
	public String toString() {

		StringBuffer output = new StringBuffer();

		for (int i = 0; i < getLength(); i++) {
			Light light = get(i);
			output.append("Light ").append(i + 1).append(' ').append(light.getColour().getName()).append(' ')
					.append(get(i).isState() ? "on" : "off").append('\n');
		}

		return output.toString();
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
