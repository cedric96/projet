package ants;

import core.Bee;

 // Thrower, mais de 0 a 2

public class ShortThrowerAnt extends ThrowerAnt {

	public ShortThrowerAnt() {
		super();
		this.name="ShortT";
	}
	
	public Bee getTarget () {
		return place.getClosestBee(0, 2); 
	} 
	
	
}
