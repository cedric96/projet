package ants;
import core.Ant;
import core.AntColony;
import core.Bee;
import core.Place;

public class NinjaAnt extends Ant{
	
private int damage=1;	
	
	
	public NinjaAnt (){
		super(6,1);
		bloqueChemin=false;
	}
	
	public void action(AntColony Colony){
		Place place;
		place=this.getPlace();//la place de la fourmi
		Bee bee_table []=place.getBees();//je mets dans un tableau toutes les abeille presente a la place;
		
		for (Bee bee :bee_table){//pour chaque abeille presente on reduit son armure de 3
			bee.reduceArmor(damage);
		}
	}

	
	
}
