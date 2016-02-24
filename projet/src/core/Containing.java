package core;

public interface Containing {
	
	/*methode permettant  
	 * d'ajouter l'insecte(fourmi)
	 */
	public void  addAnt(Ant ant);
	
	/*methode pour supprimer  l'insecte (fourmi)
	 * 
	 */
	public void deleteAnt();
	
	/*methode pour obtenir l'insecte contenu
	 * 
	 */
	public Insect getInsect();
}
