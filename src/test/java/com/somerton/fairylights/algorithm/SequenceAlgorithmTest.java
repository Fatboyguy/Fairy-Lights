package com.somerton.fairylights.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.somerton.fairylights.Algorithms;
import com.somerton.fairylights.model.DefaultChain;
import com.somerton.fairylights.model.Light;

public class SequenceAlgorithmTest {

	@Test
	public void initialState() {

		DefaultChain chain = new DefaultChain();
		SequenceAlgorithm sa = new SequenceAlgorithm(chain);

		assertEquals(500, sa.getInterval());
		assertEquals(Algorithms.SEQUENCE.name(), sa.getName());

		for (int i = 0; i < chain.getLength(); i++) {

			Light light = chain.get(i);

			if (i == 0) {
				assertTrue(light.isState());
			} else {
				assertFalse(light.isState());
			}

		}

	}

	@Test
	public void lightPhases() {

		DefaultChain chain = new DefaultChain();
		SequenceAlgorithm sa = new SequenceAlgorithm(chain);

		//test all lights in sequence
		for (int j = 0; j < chain.getLength(); j++) {
			for (int i = 0; i < chain.getLength(); i++) {

				Light light = chain.get(i);

				if (i == j) {
					assertTrue(light.isState());
				} else {
					assertFalse(light.isState());
				}

			}
			sa.next(chain);
		}
		
		//now check it started again
		for (int i = 0; i < chain.getLength(); i++) {

			Light light = chain.get(i);

			if (i == 0) {
				assertTrue(light.isState());
			} else {
				assertFalse(light.isState());
			}

		}
		
	}

}
