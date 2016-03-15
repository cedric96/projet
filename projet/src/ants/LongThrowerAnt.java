package ants;
import core.AntColony;
import core.Bee;

//Comme une Thrower, mais � 4+ cases

public class LongThrowerAnt extends ThrowerAnt {

	public LongThrowerAnt() {
		super();
		this.name="LongT";
	}
	
	public Bee getTarget () {
		return place.getClosestBee(4,AntColony.MAX_TUNNEL_LENGTH);
	}			 // On modifie juste le getTarget et le reste est pris de la classe mere
	
	
}
