package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food
 *
 * @author YOUR NAME HERE
 */
public class HarvesterAnt extends Ant {

	/**
	 * Creates a new Harvester Ant
	 */
	public HarvesterAnt () {
		//completer le super pour ajouter la nourriture
		super(2,1);
		this.name="Harvest";
	}

	@Override
	public void action (AntColony colony) {
		// TODO: Should produce one additional food for the colony
		//debut
		colony.increaseFood(1);
		//fin
	}
}
