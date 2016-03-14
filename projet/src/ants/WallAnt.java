package ants;

import core.Ant;
import core.AntColony;

/*FOURMI AYANT une grande valeur d'armure mais ne faisant rien comme action
*/
public class WallAnt extends Ant {
	
	public WallAnt(){
		super(4,4);
	}
	public void action (AntColony Colony){
		
	} // On redefini pour qu'elle ne fasse rien
}
