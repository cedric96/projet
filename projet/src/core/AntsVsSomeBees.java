package core;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees {

	public static void main (String[] args) {
		AntColony colony = new AntColony(3, 10, 3, 50); // specify the colony ]tunnels, length, moats, food]
		Hive hive = Hive.makeTestHive(); // specify the attackers (the hive)
		/**
		 * les abeilles normales (Bee) sont en jaune noir
		 * les NotStunBee sont en rouges noir
		 * les autres sont les ClassCanonBee
		 */
		new AntGame(colony, hive); // launch the game
		
	}
}
