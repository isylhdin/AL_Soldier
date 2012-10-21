package model;

public class InfantryMan implements Soldier {

	private final int hp = 100;
	private final int strength = 100;
	
	@Override
	public int strike() {
		System.out.println("Infantry man strike "+ strength);
		return strength;
	}

	@Override
	public int parry() {
		return 0;
	}

	@Override
	public int getHp() {
		return hp;
	}

}
