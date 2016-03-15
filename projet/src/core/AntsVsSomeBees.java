package core;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees {

	public static void main (String[] args) {
		AntColony colony = new AntColony(3, 8, 3, 45); // specify the colony ]tunnels, length, moats, food]
		Hive hive = Hive.makeTestHive(); // specify the attackers (the hive)
		new AntGame(colony, hive); // launch the game
		
	}
}
