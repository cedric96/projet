package core;

public interface Containing {
	
	
	/** 
	 * Methode permettant d'ajouter l'insecte(fourmi)
	 */
	public boolean  addContenantInsect(Ant ant);
	
	/**
	 * Methode pour supprimer  l'insecte (fourmi)
	 */
	
	public boolean deleteContenantInsect();
	
	/**
	 * Methode pour obtenir l'insecte contenu
	 */
	public Ant getContenantInsect();
}
