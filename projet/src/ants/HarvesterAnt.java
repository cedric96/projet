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
		super(2,1);
		this.name="Harvest";
	}

	@Override
	public void action (AntColony colony) {
	}
}
