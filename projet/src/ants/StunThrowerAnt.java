package ants;
import core.AntColony;
import core.Bee;


public class StunThrowerAnt extends ThrowerAnt {

	public StunThrowerAnt() {
		super();
		foodCost=6;
		damage = 0;
	}
	
	public void action (AntColony colony) {
		if (this.armor>0){//la throwerAnt ne fait une action que si son armor est superieur a 0
			Bee target = getTarget();
			if (target != null) {

			}
		}
		
	}
	
}
