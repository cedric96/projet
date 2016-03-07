package ants;
import core.AntColony;
import core.Undeletable;

import java.util.ArrayList;

import core.Ant;

public  class QueenAnt extends ScubaThrowerAnt implements Undeletable {
	   
	/**le nombre de reine.
	je le fais debuter a -1 car par defaut se crre des le debut la reine presente a la fin des tunnels 
	Elle reviendra donc a 0 des qu'on lance le jeu
	**/
	private static int nbreInstance=-1;
	
	//une liste dynamique STATIC qui contiendra mes reines presentes
	private static ArrayList<QueenAnt> list_Queen=new ArrayList<QueenAnt>();
    
	
	
	public QueenAnt (){
		super ();
		watersafe=true;
		foodCost=6;
		this.increment_Instance();//je prends soin de lancer cette methode des que je cree une nouvelle reine
		
	}
        
	public void increment_Instance(){
		nbreInstance++;//j'incremente le nombre de reine
		System.out.println("le nombre de reine est: "+nbreInstance);
		list_Queen.add(this);//j'ajoute cette reine cree a ma liste de reine
		
		
		}
		
	
   public void action(AntColony colony){
		//System.out.println(list_Queen);
		
			if (nbreInstance<=1){
				
				Ant temp=list_Queen.get(nbreInstance);
				//System.out.println("temp.getPlace()=  "+temp.getPlace());
				
				//ajout de la position de la reine dans la place queenPlace qui est la fin des tunnels
				colony.setContaintqueenPlace(temp.getPlace());
				
				
				
				
				
				super.action(colony);//la reine fait les actions de ScubaThrowerAnt
				
				
				//System.out.println("colony get= "+colony.getContaintqueenPlace());
				
				
				//creation et remplissage de la liste des fourmis voisisines
				ArrayList<Ant> fourmi_galvanisee=new ArrayList<Ant>();
				Ant fourmi_d_entree=(temp.getPlace()).getEntrance().getAnt();
				Ant fourmi_de_sortie=(temp.getPlace()).getExit().getAnt();
				if (fourmi_galvanisee.contains(fourmi_d_entree)==false){
					fourmi_galvanisee.add(fourmi_d_entree);
				}
				if (fourmi_galvanisee.contains(fourmi_de_sortie)==false){
					fourmi_galvanisee.add(fourmi_de_sortie);
				}
				//System.out.println( "fourmi_galvanisee"+fourmi_galvanisee);
				
				//modifications des perfommances des fourmis voisines
				for (Ant ant : fourmi_galvanisee){
					if (ant!=null){
						int old_damage=ant.getDamage();//je memorise l'ancienne valeur de damage
						ant.setDamage(2*old_damage);
					}
						
				}
				
			}
			
			else{// si mon nbreInstance est superieur a 1 il y a donc plus d'une reine 
				//dans le jeu.
				list_Queen.get(nbreInstance).isDeletable=true;
				list_Queen.get(nbreInstance).reduceArmor(1);//on supprime donc celle qu'on vient d'ajouter
				list_Queen.remove(nbreInstance);//On veuille a la supprimer de  notre liste dynamique
				nbreInstance--;//on decremente le nbreInstance puisqu'on a plus qu'une reine
				
			}
				
				
				
			
			
			
			
			
		
	}
	
}
