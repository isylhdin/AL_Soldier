package model.decorateur;

public class HorseMan extends SoldierAbstract implements Soldier{

	private final static int strength = 150;
	private static int hp = 100;
	
	
	public HorseMan() {
		super(hp, strength);
	}
	
	
	@Override
	public int strike() {
		System.out.println("HorseMan strike "+ strength);
		return super.strike();
	}

	@Override
	public void parry(int receivedDamage) {
		super.parry(receivedDamage);
	}

	@Override
	public int getHp() {
		return super.getHp();
	}

}
