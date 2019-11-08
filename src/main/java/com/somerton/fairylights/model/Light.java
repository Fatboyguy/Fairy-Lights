package com.somerton.fairylights.model;

import com.somerton.fairylights.Colours;

/**
 * The model to hold each lights colour and state.
 *
 */
public class Light {

	private Colours colour;
	private boolean state;

	public Light(Colours colour) {
		this.colour = colour;
		this.state = false;
	}

	public Colours getColour() {
		return colour;
	}

	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}

	
	/**
	 * Switches the light on/off.
	 */
	public void trigger() {
		state = state ? false : true;
	}

	
}
