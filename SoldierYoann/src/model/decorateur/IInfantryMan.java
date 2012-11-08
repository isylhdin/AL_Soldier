package model.decorateur;

public class IInfantryMan extends ISoldierAbstract implements ISoldier {	

	private static int hp = 100;
	private final static int strength = 100;
	
	
	public IInfantryMan() {
		super(hp, strength);
	}
	

}
