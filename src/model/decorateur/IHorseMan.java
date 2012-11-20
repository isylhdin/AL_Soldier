package model.decorateur;

public class IHorseMan extends ISoldierAbstract implements ISoldier{

	private final static int strength = 150;
	private static int hp = 100;
	
	
	public IHorseMan() {
		super(hp, strength, "HorseMan");
	}
	
	public IHorseMan(String name) {
		super(hp, strength,name);
	}

}
