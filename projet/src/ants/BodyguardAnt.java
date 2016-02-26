package ants;
import core.AntColony;
import core.Ant;
import core.Containing;
import core.Place;
import core.Insect;


public class BodyguardAnt extends Ant implements Containing {

	/* fourmi bouclier
	 * 
	 */
	private Ant fourmiContenue=null;
	
	
	public BodyguardAnt (){
		super(5,2);
		watersafe=true;
	}
	public Ant getInsect(){
		 Place p=this.getPlace();//j'enregistre la place de la fourmi Containing
		 p.removeInsect(this);//je supprime l'insecte containing
		 
		 fourmiContenue=p.getAnt();//si il y avait une foumi en dessous de la Containing celle la sera mise dans fourmiContenue sinon la variable reste nulle
		 this.setPlace(p);//je replace la fourmie Containing
		 return fourmiContenue;
	}
	
	public boolean addContenantInsect(Ant ant){
		Place p=this.getPlace();//j'enregistre la place de la fourmi Containing
		if (this.getInsect()!=null){//si elle  contient un insect
			return false;//On ne peut donc pas ajouter d'insecte on retourne donc faux
		}else{//Si elle ne contient pas d'insecte
			ant.setPlace(p);//On rajoute l'insecte a la meme place que la Containing
			return true;//On retourne vraie
		}
	}
	
	
	public void action(AntColony colony){
		
	}
	
	public boolean deleteContenantInsect() {
		
		
		if (this.getInsect()==null){//si elle  contient pas d' insect
			return false;
		}else{
			Place p=this.getInsect().getPlace();//j'enregistre la place de la fourmi Containing
			p.removeInsect(this.getInsect());
			return true;
		}
		
		
	}
}
