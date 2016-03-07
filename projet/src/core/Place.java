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
	 * Returns an array of the place's bees
	 *
	 * @return an array of the place's bees
	 */
	public  ArrayList<Bee> myself_getBees(){//je cree une fonction annexe qui me renvoie UNE LISTE DYNAMIQUE des abeilles
		return bees;//avant que cette liste ne soit convertie en tableau
	}
	
	public Bee[] getBees () {
		ArrayList<Bee> totalBees=this.myself_getBees();//je cree une liste qui contiendra l'ensemble des abeilles 
		if (this instanceof QueenPlace ==false){//si la place n'est pas une QueenPlace
			//totalBees=this.myself_getBees();//la liste totale des abeilles correspond aux abeilles presentes seulement sur cette plac
			return totalBees.toArray(new Bee[0]);
		}
		else{//si la place est une QueenPlace
			if (((QueenPlace)this).place_reine !=null){//et qu'ellle contient d'autres Queenplace 
				//il s'agit ici des queenPlace en fin de tunnels qui contiennent eventuellement place_reine la place qu'ocupe la reine actuellement
				
				for (Bee bee:(((QueenPlace)this).place_reine).myself_getBees()){
					//pour toute abeille presente sur la place "place_reine" donc sur la meme place que la reine
					totalBees.add(bee);//j'ajoute cette abeille a la liste totale des abeilles 
				}
				return totalBees.toArray(new Bee[0]);
			}
			
			else{//et qu'elle ne contient pas d' autre place en loccurrence si la Reine n'est pas appel�e
			 
			 
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
	 * Adds an ant to the place. If there is already an ant, this method has no effect
	 *
	 * @param ant
	 *            The ant to add to the place.
	 */
	public void addInsect (Ant ant) {
		
		
		if (this.ant == null) {
			if (this instanceof Water){
				boolean var=ant.getWatersafe();
				if (var==true){
					this.ant = ant;
					ant.setPlace(this);
				}else{
					System.out.println("This insect can't be here because of Water "); // report error
				}
			}else{
				this.ant = ant;
				ant.setPlace(this);
			}
		}else {//si la place nest pas vide
			if (this.ant instanceof Containing){//si la fourmi presente est une containig
				if (((Containing)this.ant).addContenantInsect(ant)){//Si la containing peut prendre la non Containing
					((Containing)this.ant).addContenantInsect(ant);//On lui ajoute notre fourmi
				}else{//Sinon si la Containing ne peut pas prendre la non Containing
					System.out.println("Already an ant in " + this); // report error
				}
				
			}
			else if (ant instanceof Containing){//Si la fourmi a ajouter est une containing
				if (((Containing)ant).addContenantInsect(this.ant)){//Si la containing peut prendre la non Containing( ne contient aucune fourmi pour l'instant
					Place place=this;//On memorise la place qu'occupait la non-containing
					((Containing)ant).addContenantInsect(this.ant);//On  ajoute dans la containing la fourmi presente auparavant
					//Puisque la containing n'est pas encore placee en y mettant la premiere fourmi  sa place passe a null 
					this.ant.setPlace(place);//on lui remets cette place
					//System.out.println("ant= "+ this.ant);
					this.addInsect(ant);//On ajoute la fourmi Containing qui contient bien l'autre fourmi
					
				}else {//Sinon si la Containing ne peut pas prendre la non Containing(contient deja une fourmi
					if (((Containing)ant).getContenantInsect()==this.ant){//si la fourmi contenue est la meme que celle sur place deja
						this.ant=ant;//je peux alors placer la containing (et la fourmi qu'elle contient) a cette place
						ant.setPlace(this);
					}
					else{
						System.out.println("Already an ant in " + this); // report error
					}
					
				}
				
			}
			else{//Si aucune des deux fourmi (a ajouter comme celle deja presente) n'est de type Containing
				System.out.println("Already an ant in " + this); // report error
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
	 * Removes the ant from the place. If the given ant is not in this place, this method has no effect
	 *
	 * @param ant
	 *            The ant to remove from the place
	 */
	public void removeInsect (Ant ant) {
		if (ant.isDeletable==true) {
			if (this.ant == ant) {//Si on detecte un insecte 
				//Si on detecte un insecte il est soit Containing et contient eventuellement un autre ou il est non containing
				if (ant instanceof Containing){//Si il est containing
					if (((Containing)this.ant).getContenantInsect()!=null){//on regarde s'il contient quelque chose 
						Ant temp=((Containing)this.ant).getContenantInsect();//Je crre une variable locale pour memoriser linsecte contenu
						this.ant=null;//je supprime alors la Containing
						ant.setPlace(null);
						this.addInsect(temp);//Puis je rajoute sur la meme place l'insecte contenu
					}else{//Si la containing ne contient rien
						this.ant=null;//On la supprime
						ant.setPlace(null);
					}
				}else{//Si cest pas une containing on la supprime
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
