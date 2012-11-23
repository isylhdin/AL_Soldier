package model.decorateur;

public class Sword extends AbstractWeapon {

	private boolean oneHand = true;
	
	public Sword(ISoldier s) {
		super(s,200,2);
	}

}
