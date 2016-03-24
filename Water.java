package core;

import core.Place;

public class Water extends Place{
	
	/**
	 * Creates a new water with the given name and exit
	 *
	 * @param name
	 *            The water's name
	 * @param exit
	 *            The water's exit
	 */
	public Water (String name, Place exit){
		super(name,exit);
	}
	/**
	 * Creates a new water with the given name
	 *
	 * @param name
	 *            The water's name
	 */
	public Water (String name) {
		this(name, null);
	}
	
	

}
