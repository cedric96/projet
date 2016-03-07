package ants;

import core.Bee;

public class ShortThrowerAnt extends ThrowerAnt {

	public ShortThrowerAnt() {
		super();
	}
	
	public Bee getTarget () {
		return place.getClosestBee(0, 2); // La fourmi a une portée max de 2
	}									  // On modifie juste le getTarget et le reste est pris de la classe mère
	
	
}
