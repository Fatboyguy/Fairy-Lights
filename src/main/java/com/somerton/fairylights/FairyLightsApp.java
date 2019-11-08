package com.somerton.fairylights;

import com.somerton.fairylights.controller.FairyLightsController;
import com.somerton.fairylights.model.Chain;
import com.somerton.fairylights.model.DefaultChain;
import com.somerton.fairylights.view.FairyLightDisplay;

/**
 * Fairy Lights
 * 
 * A fairy light simulator, upon running a simple menu is shown offering 3 different algorithms:
 * 
 * ‘Sequence’: each light is turned on for 0.5 seconds then off in turn from first to
 *    last.
 * ‘Colour’: all of the red lights are turned on for 1 second, then all the green for 1
 *    second then all the white for 1 second.
 * ‘Alternate’: the 'sequence' algorithm runs for 30 seconds, then the 'colour'
 *     algorithm for 30 seconds. 
 *     
 *  Note that once selected the application runs indefinitely. Please CTL-C to exit.
 *
 */
public class FairyLightsApp {
	public static void main(String[] args) {

		Chain chain = new DefaultChain();
		FairyLightDisplay display = new FairyLightDisplay();
		
		Algorithms algorithm = display.displayOptions();
		
		FairyLightsController controller = new FairyLightsController(chain, display, algorithm);

		try {
			controller.go();
		} catch (InterruptedException ie) {
			System.err.println("An thread error occured when running");
			ie.printStackTrace();
		} catch (Exception e) {
			System.err.println("An unexpected error occured when running");
			e.printStackTrace();
		}

	}
}
