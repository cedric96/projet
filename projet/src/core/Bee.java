package core;

/**
 * Represents a Bee
 *
 * @author YOUR NAME HERE
 */
public class Bee extends Insect {

	private static final int DAMAGE = 1;
	public boolean isStun;
	
	//private boolean isStun;
	

	/**
	 * Creates a new bee with the given armor
	 *
	 * @param armor
	 *            The bee's armor
	 */
	public Bee (int armor) {
		super(armor);
		watersafe=true;
		this.isStun=false;
	}

	/**
	 * Deals damage to the given ant
	 *
	 * @param ant
	 *            The ant to sting
	 */
	public void sting (Ant ant) {
		ant.reduceArmor(DAMAGE);
	}

	/**
	 * Moves to the given place
	 *
	 * @param place
	 *            The place to move to
	 */
	public void moveTo (Place place) {
		this.place.removeInsect(this);
		place.addInsect(this);
	}

	@Override
	public void leavePlace () {
		place.removeInsect(this);
	}

	/**
	 * Returns true if the bee cannot advance (because an ant is in the way)
	 *
	 * @return if the bee can advance
	 */
	public boolean isBlocked () {
		if (place.getAnt() != null){//si on a une fourmi on verifie si elle laisse passer les abeille
			
				return place.getAnt().getBloqueChemin();
			
			
		}else{ //ou pas si on a pas de fourmi on laisse passer labeille
			return false;
		}
		
	}
	
	
	
	//je cree un getteur pour le DAMAGE
	public int getDamage(){
		return Bee.DAMAGE;
	}
	
	
	//public void setStun(boolean b){
		//this.isStun=b;
	//}
	
	//public boolean getStun(){
		//return isStun;
	//}
	/**
	 * A bee's action is to sting the Ant that blocks its exit if it is blocked,
	 * otherwise it moves to the exit of its current place.
	 */
	@Override
	public void action (AntColony colony) {
		if (this.armor >0){
			if (isBlocked()) {
				sting(place.getAnt());
			}
			else {
				if (isStun==false){
					moveTo(place.getExit());
				}
				else{//il reste sur la place
					moveTo(place);
				}
				
			}
		}
	}
}
