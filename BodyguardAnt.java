package ants;
import core.AntColony;
import core.Containing;
import core.Ant;


/**
 * Fourmi qui se place sur une autre fourmi
 * pour en modifier la valeur d'armure.
 */

public class BodyguardAnt extends Ant implements Containing {
	
	private Ant	fourmiContenue=null;
	
	public BodyguardAnt (){
		
		super(5,2);
		this.name="BodyG";
				
		
		watersafe=true;
		if (fourmiContenue != null){
			fourmiContenue.setPlace(this.place);
		}
	}


	@Override
	public boolean addContenantInsect(Ant ant) {
		if (fourmiContenue==null){
			fourmiContenue=ant;
			ant.setPlace(this.place);
			return true;
		}
		return false;
	}


	@Override
	public boolean deleteContenantInsect() {
		if (fourmiContenue != null){
			fourmiContenue=null;
			return true;
		}
		
		return false;
	}


	@Override
	public Ant getContenantInsect() {
		
		return fourmiContenue;
	}

	public void action(){
		
	}
	
	//@Override
	public void action(AntColony colony) {
		if (fourmiContenue!=null){
			fourmiContenue.action(colony);
		}
				
	}
	
	
}
