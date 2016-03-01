package core;

public interface Containing {
	
	
	/*methode permettant  
	 * d'ajouter l'insecte(fourmi)
	 */
	public boolean  addContenantInsect(Ant ant);
	
	/*methode pour supprimer  l'insecte (fourmi)
	 * 
	 */
	public boolean deleteContenantInsect();
	
	/*methode pour obtenir l'insecte contenu
	 * 
	 */
	public Ant getContenantInsect();
}
