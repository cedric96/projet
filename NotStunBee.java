package core;

public class NotStunBee extends Bee {
	
	/* Abeilles jamais �tourdies */
	
	public NotStunBee(int armor){
		super(1);
		this.setStun(false);
		this.setSlowStun(false);
	}
	
	

}
