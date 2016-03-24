package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 *
 * @author YOUR NAME HERE
 */
public class ThrowerAnt extends Ant {

	

	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 0, Damage: 1
	 */
	public ThrowerAnt () {
		super(4,1);
		damage = 1;
		this.name="Thrower";
	}

	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 3);
	}

	@Override
	public void action (AntColony colony) {
		if (this.armor>0){
			Bee target = getTarget();
			if (target != null) {
				target.reduceArmor(damage);
			}
		}
		
	}
}
