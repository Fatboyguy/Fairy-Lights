package com.somerton.fairylights.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefaultChainTest {

	private final String output = "Light 1 Red off\n" + 
			"Light 2 Green off\n" + 
			"Light 3 White off\n" + 
			"Light 4 Red off\n" + 
			"Light 5 Green off\n" + 
			"Light 6 White off\n" + 
			"Light 7 Red off\n" + 
			"Light 8 Green off\n" + 
			"Light 9 White off\n" + 
			"Light 10 Red off\n" + 
			"Light 11 Green off\n" + 
			"Light 12 White off\n" + 
			"Light 13 Red off\n" + 
			"Light 14 Green off\n" + 
			"Light 15 White off\n" + 
			"Light 16 Red off\n" + 
			"Light 17 Green off\n" + 
			"Light 18 White off\n" + 
			"Light 19 Red off\n" + 
			"Light 20 Green off\n";
	
	@Test
	public void toStringTest() {
		DefaultChain dc = new DefaultChain();
		
		assertEquals(output, dc.toString());
	}

}
