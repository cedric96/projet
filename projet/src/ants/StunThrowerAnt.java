package ants;
import java.util.ArrayList;

import core.AntColony;
import core.Bee;


public class StunThrowerAnt extends ThrowerAnt{
	
	
	public StunThrowerAnt() {
		super();
		foodCost=6;
		name="Stun";
		}
	
	//Je redefini ici le getTarget
	public Bee getTarget () {
		return place.getClosestBee(0, 3);
	}
	
	public void action (AntColony colony) {
		
		Bee target=getTarget();
		if (target != null){
			target.setStun(true);
			target.reduceArmor(damage);
		}
		
	}
	
}
