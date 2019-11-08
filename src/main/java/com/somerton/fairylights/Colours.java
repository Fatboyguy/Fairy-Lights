package com.somerton.fairylights;

/**
 * The default colours as specified.
 * 
 * For future consideration and with more time I would
 * define these in a properties/JSON file to allow
 * for different colours.
 *
 */
public enum Colours {

	RED("Red"), GREEN("Green"), WHITE("White");

	private String name;

	private Colours(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
