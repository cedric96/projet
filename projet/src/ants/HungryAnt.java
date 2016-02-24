package ants;
import core.Ant;
import core.AntColony;
import core.Bee;
//import core.Insect;


/*fourmi qui tue instantanement les abeilles 
 
 */
public class HungryAnt extends Ant {
	protected int damage;
	protected int time=0;
	
	public HungryAnt(){
		super(4,1);
	}
	
	public void action(AntColony colony){
		Bee target_bee=place.getClosestBee(0, 0);
		if (time>2){//temps de digestion de trois tours
			if (target_bee!=null ){//verifie s'il y a une abeille ou pas
				damage=target_bee.getArmor();
				target_bee.reduceArmor(damage+1);
				time=0;
			}else{
				time=time+1;
			}
			
		}else{
			time=time+1;
		}
		
	}
	
}
