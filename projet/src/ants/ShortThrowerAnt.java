package ants;

import core.Bee;

 // Thrower, mais de 0 ‡ 2

public class ShortThrowerAnt extends ThrowerAnt {

	public ShortThrowerAnt() {
		super();
	}
	
	public Bee getTarget () {
		return place.getClosestBee(0, 2); 
	}  // On modifie juste le getTarget et le reste est pris de la classe m√®re
	
	
}
