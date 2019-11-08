package com.somerton.fairylights.algorithm;

import com.somerton.fairylights.Algorithms;
import com.somerton.fairylights.Colours;
import com.somerton.fairylights.model.Chain;
import com.somerton.fairylights.model.Light;

/**
 * The Colour Algorithm
 * 
 * All of the red lights are turned on for 1 second, then all the green for 1
 * second then all the white for 1 second.
 *
 */
public class ColourAlgorithm implements Algorithm {

	private String name = Algorithms.COLOUR.name();
	private int interval;
	private Colours currentColour;

	public ColourAlgorithm(Chain chain) {
		interval = 1000;
		initialize(chain);
	}

	public String getName() {
		return name;
	}

	public int getInterval() {
		return interval;
	}

	
	/**
	 * Switches the lights to the next phase.
	 *
	 * @param chain the chain to move on.
	 */
	public void next(Chain chain) {

		switch (currentColour) {

		case RED:
			currentColour = Colours.GREEN;
			break;

		case GREEN:
			currentColour = Colours.WHITE;
			break;

		case WHITE:
			currentColour = Colours.RED;
			break;

		}

		changeColour(chain);
	}

	/**
	 * Initialises the chain to its starting configuration.
	 * 
	 * @param chain the chain to initialise.
	 */
	public void initialize(Chain chain) {

		currentColour = Colours.RED;

		changeColour(chain);
	}

	private void changeColour(Chain chain) {
		for (Light light : chain.getLights()) {
			if (light.getColour().equals(currentColour)) {
				light.setState(true);
			} else {
				light.setState(false);
			}
		}
	}

}
