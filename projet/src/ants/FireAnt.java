package ants;

import core.Ant;
import core.AntColony;
import core.Place;
import core.Bee;

public class FireAnt extends Ant {
	private int damage=3;
	private int amount=1;
	
	public FireAnt(){
		super(4,1);
	}
	public void reduceArmor(int amount){
		
		Place place;
		place=this.getPlace();//la place de la fourmi
		//System.out.println("place= "+place);
		super.reduceArmor(amount);
		if (this.getArmor()<=0){//si la valeur d'armure de la fourmi est nulle ou negative
			
			Bee bee_table []=place.getBees();//je mets dans un tableau toutes les abeille presente a la place;
			int nbre=bee_table.length;//pour chaque abeille presente on reduit son armure de 3
			for (int i=0;i<nbre;i++){
				bee_table[i].reduceArmor(damage);
			}
		}
			
	}
	public void action(AntColony colony){
		
	}

}
