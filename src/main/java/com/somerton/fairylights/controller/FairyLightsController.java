package com.somerton.fairylights.controller;

import com.somerton.fairylights.Algorithms;
import com.somerton.fairylights.algorithm.Algorithm;
import com.somerton.fairylights.algorithm.ColourAlgorithm;
import com.somerton.fairylights.algorithm.SequenceAlgorithm;
import com.somerton.fairylights.model.Chain;
import com.somerton.fairylights.view.FairyLightDisplay;

/**
 * @author gsome
 *
 */
public class FairyLightsController {

	private Chain chain;
	private FairyLightDisplay display;
	private Algorithm algorithm;
	private Algorithms choice;

	/**
	 * Controller containing the business logic for controlling the chain of lights.
	 * 
	 * @param chain the chain to use
	 * @param display the view for I/O
	 * @param choice the algorithm to execute
	 */
	public FairyLightsController(Chain chain, FairyLightDisplay display, Algorithms choice) {
		this.chain = chain;
		this.display = display;
		this.choice = choice;

		setAlgorithm();
	}

	private void setAlgorithm() {

		switch (choice) {

		case SEQUENCE:
			algorithm = new SequenceAlgorithm(chain);
			break;
		case COLOUR:
			algorithm = new ColourAlgorithm(chain);
			break;
		case ALTERNATE:
			algorithm = new SequenceAlgorithm(chain);
			break;
		}
	}

	private void nextAlgorithm() {

		if (algorithm instanceof SequenceAlgorithm) {
			algorithm = new ColourAlgorithm(chain);
		} else if (algorithm instanceof ColourAlgorithm) {
			algorithm = new SequenceAlgorithm(chain);
		}

	}

	
	/**
	 * 
	 * Starts the light display using the pre-configured algorithm.
	 * 
	 * This method will run indefinitely as specified.
	 *  
	 * @throws InterruptedException
	 */
	public void go() throws InterruptedException {

		if (choice != Algorithms.ALTERNATE) {
			while (true) {
				runPhase();
			}
		} else {

			long start = System.currentTimeMillis();

			while (true) {

				long stepTime = System.currentTimeMillis() - start;
				if (stepTime < 30000) {
					runPhase();
				} else {
					nextAlgorithm();
					start = System.currentTimeMillis();
					runPhase();
				}
			}

		}

	}

	private void runPhase() throws InterruptedException {
		display.display(chain);
		Thread.sleep(algorithm.getInterval());
		algorithm.next(chain);
	}

}
