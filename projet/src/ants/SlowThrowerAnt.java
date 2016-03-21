package ants;

import java.util.ArrayList;

import core.AntColony;
import core.Bee;
import core.NotStunAnt;

public class SlowThrowerAnt extends ThrowerAnt {
	
	ArrayList<Bee> abeillesSlow=new ArrayList<Bee>();
	
	public SlowThrowerAnt(){
		super();
		foodCost=4;
		name="SlowT";
	}
	
	public Bee getTarget () {
		return place.getClosestBee(0, 2);
	}
	
	public void action(AntColony colony){
		
		Bee target=getTarget();
		if (target != null){
			if (target instanceof NotStunAnt ==false){
				target.setSlowStun(true);
				target.reduceArmor(damage);
			}
			
		}
		
	}
}
