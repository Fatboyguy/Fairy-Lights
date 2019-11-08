package com.somerton.fairylights.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.somerton.fairylights.Colours;

public class LightTest {

	@Test
	public void triggerTest() {
		Light light = new Light(Colours.GREEN);
		
		assertFalse(light.isState());
		
		light.trigger();
		assertTrue(light.isState());
		
		light.trigger();
		assertFalse(light.isState());
	}

}
