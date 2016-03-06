package core;

/**
 * A class representing a basic Ant
 *
 * @author YOUR NAME HERE
 */
public abstract class Ant extends Insect implements Damaging{
	protected int damage;//Je redefini le damage ici pour qu'il soit accessible par toute les fourmi
	//il etait auparavant dans ThrowerAnt
	protected int foodCost; // the amount of food needed to make this ant
	private boolean bloqueChemin; //varaiable permettant de savoir si la fourni freine le chemin de l'abeille ou pas
	/**
	 * Creates a new Ant, with a food cost of 0.
	 *
	 * @param armor
	 *            The armor of the ant.
	 */
	public Ant (int armor) {
		
		super(armor, null);
		foodCost = 0;
	}
	//Debut ma partie
	public Ant (int food_cost,int armor){
		super(armor,null);
		this.foodCost=food_cost;
		this.bloqueChemin=true;
		damage=0;

	}
	//fin ma partie

	/**
	 * Returns the ant's food cost
	 *
	 * @return the ant's good cost
	 */
	public int getFoodCost () {
		return foodCost;
	}

	/**
	 * Removes the ant from its current place
	 */
	@Override
	public void leavePlace () {
		place.removeInsect(this);
	}
	//implantation de getDamage
	public int getDamage(){
		return this.damage;
	}
	//implantation du setDamage
	public void setDamage(int nbre){
		this.damage=nbre;
	}
	
	//je cree un getteur et un setteur pour la variable bloqueChemin
	
	public void setBloqueChemin(boolean b){
		this.bloqueChemin=b;
	}
	
	public boolean getBloqueChemin(){
		return bloqueChemin;
	}
}
