package com.somerton.fairylights.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.somerton.fairylights.Algorithms;
import com.somerton.fairylights.Colours;
import com.somerton.fairylights.model.DefaultChain;
import com.somerton.fairylights.model.Light;

public class ColourAlgorithmTest {

	@Test
	public void initialState() {

		DefaultChain chain = new DefaultChain();
		ColourAlgorithm ca = new ColourAlgorithm(chain);

		assertEquals(1000, ca.getInterval());
		assertEquals(Algorithms.COLOUR.name(), ca.getName());

		for (Light light : chain.getLights()) {

			if (light.getColour() == Colours.RED) {
				assertTrue(light.isState());
			} else {
				assertFalse(light.isState());
			}

		}

	}

	@Test
	public void lightPhases() {

		DefaultChain chain = new DefaultChain();
		ColourAlgorithm ca = new ColourAlgorithm(chain);

		for (Light light : chain.getLights()) {

			if (light.getColour() == Colours.RED) {
				assertTrue(light.isState());
			} else {
				assertFalse(light.isState());
			}

		}
		
		ca.next(chain);
		
		for (Light light : chain.getLights()) {

			if (light.getColour() == Colours.GREEN) {
				assertTrue(light.isState());
			} else {
				assertFalse(light.isState());
			}

		}
		
		ca.next(chain);
		
		for (Light light : chain.getLights()) {

			if (light.getColour() == Colours.WHITE) {
				assertTrue(light.isState());
			} else {
				assertFalse(light.isState());
			}

		}
		
		ca.next(chain);
		
		for (Light light : chain.getLights()) {

			if (light.getColour() == Colours.RED) {
				assertTrue(light.isState());
			} else {
				assertFalse(light.isState());
			}

		}

	}

}
