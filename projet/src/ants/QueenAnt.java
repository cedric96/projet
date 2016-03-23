package ants;
import core.AntColony;
import core.Undeletable;

import java.util.ArrayList;

import core.Ant;

public  class QueenAnt extends ScubaThrowerAnt implements Undeletable {
	   
	
	private static int nbreInstance=-1;
	
	// une liste dynamique STATIC qui contiendra mes reines presentes 
	
	private static ArrayList<QueenAnt> list_Queen=new ArrayList<QueenAnt>();
    
	
	
	public QueenAnt (){
		super();
		watersafe=true;
		foodCost=6;
		this.name="Queen";
		this.increment_Instance(); // Je prends soin de lancer cette methode des que je cree une nouvelle reine
		
	}
        
	public void increment_Instance(){
		nbreInstance++; // J'incremente le nombre de reine
		
		list_Queen.add(this); // J'ajoute cette reine creee � ma liste de reine
		
		
		}
		
	
   public void action(AntColony colony){
		//System.out.println(list_Queen);
		
			if (nbreInstance<=1){
				
				Ant temp=list_Queen.get(nbreInstance);
				
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
					//System.out.println("entrance: "+);
					if (ant!=null){
						int old_damage=ant.getDamage();//je memorise l'ancienne valeur de damage
						ant.setDamage(2*old_damage);
					}
						
				}
				
			}
			
			else{
				// si mon nbreInstance est superieur � 1 il y a donc plus d'une reine dans le jeu.
				list_Queen.get(nbreInstance).isDeletable=true; // On rend les  autres reines supprimables
				list_Queen.get(nbreInstance).reduceArmor(1);//On supprime donc celle(s) qu'on vient d'ajouter
				list_Queen.remove(nbreInstance);// On veille a la/les supprimer de notre liste dynamique
				nbreInstance--;// On d�cremente le nbreInstance puisqu'on a plus qu'une reine
				
			}
				
				
				
			
			
			
			
			
		
	}
	
}
