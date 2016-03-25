package core;

import java.util.ArrayList;




/**
 * Represents a location in the game
 *
 * @author Joel
 * @version Fall 2014
 */
public class Place {
	
	private String name; // a name we can use for debugging
	private Place exit; // where you leave this place to
	private Place entrance; // where you enter this place from
	private ArrayList<Bee> bees; // bees currently in the place
	private Ant ant; // ant (singular) currently in the place

	/**
	 * Creates a new place with the given name and exit
	 *
	 * @param name
	 *            The place's name
	 * @param exit
	 *            The place's exit
	 */
	public Place (String name, Place exit) {
		this.name = name;
		this.exit = exit;
		entrance = null;
		bees = new ArrayList<Bee>();
		ant = null;
	}

	/**
	 * Creates a new place with the given name
	 *
	 * @param name
	 *            The place's name
	 */
	public Place (String name) {
		this(name, null);
	}

	/**
	 * Returns the place's ant
	 *
	 * @return the place's ant
	 */
	public Ant getAnt () {
		return ant;
	}

	/**
	Renvoie une liste dynamique ainsi que les abeilles
	 */
	
	public  ArrayList<Bee> myself_getBees(){
		return bees;
	}
	
	/** Renvoie un tableau d'abeilles presentes sur une case donnee ou 
	 * sur la place de la reine (a la fin des tunnels ou autre si on l'a deja placee.
	 */
	
	public Bee[] getBees () {
		ArrayList<Bee> totalBees=this.myself_getBees();
		if (this instanceof QueenPlace ==false){
			return totalBees.toArray(new Bee[0]);
		}
		else{
			if (((QueenPlace)this).place_reine !=null) {
				for (Bee bee:(((QueenPlace)this).place_reine).myself_getBees()){
					totalBees.add(bee);
				}
				return totalBees.toArray(new Bee[0]);
			}
			
			else{
				totalBees=this.myself_getBees();
				return totalBees.toArray(new Bee[0]);
			}
		}
	}

	/**
	 * Returns a nearby bee, up to the maxDistance ahead. If multiple bees are the same distance, a random bee is chosen
	 *
	 * @param minDistance
	 *            The minimum distance away (in Places) a bee can be. A value of -1 means no min distance
	 * @param maxDistance
	 *            The maximum distance away (in Places) a Bee can be. A value of -1 means no max distance
	 * @return A random nearby bee.
	 */
	public Bee getClosestBee (int minDistance, int maxDistance) {
		Place p = this;
		for (int dist = 0; p != null && dist <= maxDistance; dist++) {
			if (dist >= minDistance && p.bees.size() > 0) {
				return p.bees.get((int) (Math.random() * p.bees.size())); // pick a random bee
			}
			p = p.entrance;
		}
		return null;
	}

	/**
	 * Returns the name of the place
	 *
	 * @return the name of the place
	 */
	public String getName () {
		return name;
	}

	/**
	 * Returns the exit of the place
	 *
	 * @return the exit of the place
	 */
	public Place getExit () {
		return exit;
	}

	/**
	 * Sets the entrance to the place
	 *
	 * @param entrance
	 *            The entrance to the place
	 */
	public void setEntrance (Place entrance) {
		this.entrance = entrance;
	}

	/**
	 * Returns the entrance to the place
	 *
	 * @return the entrance to the place
	 */
	public Place getEntrance () {
		return entrance;
	}

	/**
	 * On verifie s'il y a de l'eau, donc si on peut placer la fourmi, et si c'est le cas, 
	 * on verifie si on a une fourmi implementant Containing sans fourmie contenue ou
	 * une fourmi n'etant pas Containing.
	 * 
	 * Si c'est une Containing sans contenu, on place la fourmi ssi ce n'est pas une Containing
	 * Si ce n'est pas une Containing, on place une Containing
	 * Sinon, on repporte une erreur.
	 */
	
	public void addInsect (Ant ant) {
		
		
		if (this.ant == null) {
			if (this instanceof Water){
				boolean var=ant.getWatersafe();
				if (var==true){
					this.ant = ant;
					ant.setPlace(this);
				}else{
					System.out.println("This insect can't be here because of Water "); 
				}
			}else{
				this.ant = ant;
				ant.setPlace(this);
			}
		}else {
			if (this.ant instanceof Containing){
				if (((Containing)this.ant).addContenantInsect(ant)){
					((Containing)this.ant).addContenantInsect(ant);
				}else{
					System.out.println("Already an ant in " + this); 
				}
				
			}
			else if (ant instanceof Containing){
				if (((Containing)ant).addContenantInsect(this.ant)){
					Place place=this;
					((Containing)ant).addContenantInsect(this.ant);
					this.ant.setPlace(place);
					this.addInsect(ant);
					
				}else {
					if (((Containing)ant).getContenantInsect()==this.ant){
						this.ant=ant;
						ant.setPlace(this);
					}
					else{
						System.out.println("Already an ant in " + this); 
					}
					
				}
				
			}
			else{
				System.out.println("Already an ant in " + this);
			}
			
		}
	}

	/**
	 * Adds a bee to the place
	 *
	 * @param bee
	 *            The bee to add to the place.
	 */
	
	public void addInsect (Bee bee) {
		bees.add(bee);
		bee.setPlace(this);
	}

	
	/**
	 *Supprime une fourmi.
	 *
	 *Si c'est une fourmi Containing, on regarde si elle contient quelque chose.
	 *Si oui, on supprime la Containing en sauvegardant la fourmi contenue et en la replaçant après
	 *Sinon, on supprime la Containing vide ou la fourmi non Containing.
	 */
	
	public void removeInsect (Ant ant) {
		if (ant.isDeletable==true) {
			if (this.ant == ant) {
				if (ant instanceof Containing){
					if (((Containing)this.ant).getContenantInsect()!=null){
						Ant temp=((Containing)this.ant).getContenantInsect();
						this.ant=null;
						ant.setPlace(null);
						this.addInsect(temp);
					}else{
						this.ant=null;
						ant.setPlace(null);
					}
				}else{
					this.ant = null;
					ant.setPlace(null);
				}
				
			
			}else {
				System.out.println(ant + " is not in " + this);
			}
		}
	}

	/**
	 * Removes the bee from the place. If the given bee is not in this place, this method has no effect
	 *
	 * @param bee
	 *            The bee to remove from the place.
	 */
	public void removeInsect (Bee bee) {
		if (bees.contains(bee)) {
			bees.remove(bee);
			bee.setPlace(null);
		}
		else {
			System.out.println(bee + " is not in " + this);
		}
	}

	@Override
	public String toString () {
		return name;
	}
}
