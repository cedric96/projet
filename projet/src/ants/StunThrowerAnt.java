package ants;
import java.util.ArrayList;

import core.AntColony;
import core.Bee;


public class StunThrowerAnt extends ThrowerAnt {
	
	private int time=0;
	ArrayList<Bee> abeilles_Stunees=new ArrayList<Bee>();
	
	public StunThrowerAnt() {
		super();
		foodCost=6;
		//damage = 0;
		this.name="Stun";
	}
	
	//Je redefini ici le getTarget
	public Bee getTarget () {
		return place.getClosestBee(0, 4);
	}
	
	public void action (AntColony colony) {
		if (this.armor>0){//la throwerAnt ne fait une action que si son armor est superieur a 0
			Bee target = getTarget();
			//Je remets a false le isStun de labeille qui a ete mis a true lors du tour precedent
			if (abeilles_Stunees.size()!=0){
				abeilles_Stunees.get(abeilles_Stunees.size()-1).isStun=false;
			}
			
			if (target != null){
				target.reduceArmor(damage);
				if ( abeilles_Stunees.contains(target)==false){
					
					////une fourmi ne peut etre retarde qu'une fois
					target.isStun=true;
					abeilles_Stunees.add(target);
				}
			}
			
			 
			
		}
		
	}
	
}
