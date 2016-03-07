package ants;
import core.AntColony;
import core.Bee;


public class StunThrowerAnt extends ThrowerAnt {
	
	private int time=0;
	
	public StunThrowerAnt() {
		super();
		foodCost=6;
		damage = 0;
	}
	
	public void action (AntColony colony) {
		if (this.armor>0){//la throwerAnt ne fait une action que si son armor est superieur a 0
			Bee target = getTarget();
			if (target != null) {
				for (int time=0;time<2;time++) {
				
					
				}
			}
		}
		
	}
	
}
