package ants;
import core.AntColony;
import core.Bee;
import core.Undeletable;

import java.util.ArrayList;

import core.Ant;

public  class QueenAnt extends ScubaThrowerAnt implements Undeletable {
	   
	
	private static int nbreInstance=-1;
	
	private boolean reineImposteur;
	
	
	public QueenAnt (){
		super();
		nbreInstance++;
		watersafe=true;
		foodCost=6;
		this.name="Queen";
		reineImposteur=false;
		if (nbreInstance>1){
			this.isDeletable=true;
			this.reduceArmor(this.armor);
			
		}
	}
	public Bee getTarget () {
		return place.getClosestBee(0, 5);}
	
   public void action(AntColony colony){
	   
		
	    if(this!=null){
		   Ant temp=this;
			
			//ajout de la position de la reine dans la place queenPlace qui est la fin des tunnels
			colony.setContaintqueenPlace(temp.getPlace());
			
			super.action(colony);//la reine fait les actions de ScubaThrowerAnt
			
		
			
			//creation et remplissage de la liste des fourmis voisisines
			ArrayList<Ant> fourmi_galvanisee=new ArrayList<Ant>();
			
			
			if ((temp.getPlace()).getEntrance()!=null){
				Ant fourmi_d_entree=(temp.getPlace()).getEntrance().getAnt();
				if (fourmi_galvanisee.contains(fourmi_d_entree)==false){
					fourmi_galvanisee.add(fourmi_d_entree);
				}
			}
			if ((temp.getPlace()).getExit()!=null){
				Ant fourmi_de_sortie=(temp.getPlace()).getExit().getAnt();
				if (fourmi_galvanisee.contains(fourmi_de_sortie)==false){
					fourmi_galvanisee.add(fourmi_de_sortie);
				}
			}
			
			
			
			
			
			//modifications des perfommances des fourmis voisines
			for (Ant ant : fourmi_galvanisee){
				if (ant!=null){
					int old_damage=ant.getDamage();//je memorise l'ancienne valeur de damage
					ant.setDamage(2*old_damage);
				}
					
			}
			 
	   }
	
	}
	
}
