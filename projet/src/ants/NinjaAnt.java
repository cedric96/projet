package ants;
import core.Ant;
import core.AntColony;
import core.Bee;
import core.Place;

public class NinjaAnt extends Ant{
	
private int damage=1;	
	
	
	public NinjaAnt (){
		super(6,1);
		this.setBloqueChemin(false);
		this.name="Ninja";
	}
	
	
	/** 
	 * Je mets dans un tableau toutes les abeille presente a la place
	 * On inflige des dommages à chacune
	 */
	
	public void action(AntColony Colony){
		Place place;
		place=this.getPlace();
		Bee bee_table []=place.getBees(); 
		System.out.println("bee_table="+bee_table);
		
		for (Bee bee :bee_table){ 
			bee.reduceArmor(damage);
		}
	}

	
	
}
