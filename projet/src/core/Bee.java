package core;
import java.util.ArrayList;

/**
 * Represents a Bee
 *
 * @author YOUR NAME HERE
 */
public class Bee extends Insect {

	private static int DAMAGE = 1;
	
	private boolean slowStun;
	private int slowTime=0;
	private int stunTime = 0;
	private boolean isStun;
	

	/**
	 * Creates a new bee with the given armor
	 *
	 * @param armor
	 *            The bee's armor
	 */
	public Bee (int armor) {
		super(armor);
		watersafe=true;
		
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
	public void setDamage(int newDamage){
		this.DAMAGE=newDamage;
	}
	
	
	
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
				//je geres ici les slow et stun
				if (slowStun==true){
					if (slowTime<2){
						moveTo(this.place);
						slowTime++;
					}
					else{
						this.slowStun=false;
						slowTime=0;
					}
				}
				else if (isStun==true){
					if (stunTime<1){
						System.out.println(stunTime);
						moveTo(this.place);
						stunTime++;
					}
					else{
						this.isStun=false;
						stunTime=0;
					}
				}

				else {
					moveTo(place.getExit());
				}
				
			}
		}
	}
	
	public void setSlowStun(boolean b) {
		this.slowStun=b;
	}
	public void setStun(boolean b) {
		this.isStun=b;
	}
}
