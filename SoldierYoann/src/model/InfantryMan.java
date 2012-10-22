package model;

public class InfantryMan implements Soldier {

	private int hp = 100;
	private final int strength = 100;
	
	@Override
	public int strike() {
		System.out.println("Infantry man strike "+ strength);
		return strength;
	}

	@Override
	public void parry(int damage) {
		this.hp -= damage;
	}

	@Override
	public int getHp() {
		return hp;
	}

}
