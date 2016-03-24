package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class FireAnt extends Ant {
	private int damage=3;
	
	
	public FireAnt(){
		super(4,1);
		this.name="Fire";
		
	}
	public void reduceArmor(int amount){
		Bee[] bee_table=place.getBees(); 
		
		super.reduceArmor(amount);
		if (this.armor<=0){
			
			for (Bee bee:bee_table){
				System.out.println(bee_table);
				bee.reduceArmor(bee.getArmor());
				
			}
			
			
		}
	}
	
	@Override
	public void action(AntColony colony){
		
	}
}
