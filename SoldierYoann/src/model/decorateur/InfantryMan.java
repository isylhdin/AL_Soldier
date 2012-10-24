package model.decorateur;

public class InfantryMan extends SoldierAbstract implements Soldier {	

	private static int hp = 100;
	private final static int strength = 100;
	
	
	public InfantryMan() {
		super(hp, strength);
	}
	
	
	@Override
	public int strike() {
		System.out.println("Infantry man strike "+ strength);
		return strength;
	}

	@Override
	public void parry(int damage) {
		super.parry(damage);
	}

	@Override
	public int getHp() {
		return super.getHp();		
	}

}
