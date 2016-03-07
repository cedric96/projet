package ants;
import core.AntColony;
import core.Bee;

public class LongThrowerAnt extends ThrowerAnt {

	public LongThrowerAnt() {
		super();
	}
	
	public Bee getTarget () {
		return place.getClosestBee(4,AntColony.MAX_TUNNEL_LENGTH); // La fourmi a une portée max de 4
	}									  // On modifie juste le getTarget et le reste est pris de la classe mère
	
	
}
