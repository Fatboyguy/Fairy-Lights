package com.somerton.fairylights.algorithm;

import com.somerton.fairylights.Algorithms;
import com.somerton.fairylights.model.Chain;
import com.somerton.fairylights.model.Light;

public class SequenceAlgorithm implements Algorithm {

	private String name = Algorithms.SEQUENCE.name();
	private int interval;

	public SequenceAlgorithm(Chain chain) {
		interval = 500;
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
	 * @param chain the chain to move on
	 */
	public void next(Chain chain) {

		chain.get(chain.getCurrent()).trigger();
		
		// simple return the next light in the chain or loop back to start
		if (chain.getCurrent() == chain.getLength() - 1) {
			chain.setCurrent(0);
		} else {
			chain.setCurrent(chain.getCurrent() + 1);
		}
		
		chain.get(chain.getCurrent()).trigger();
	}

	/**
	 * Initialises the chain to its starting configuration.
	 * 
	 * @param chain the chain to initialise.
	 */
	public void initialize(Chain chain) {
		
		for(Light light: chain.getLights()) {
			light.setState(false);
		}
		
		chain.get(0).trigger();
		
	}

}
