package model;

public class HorseMan implements Soldier {

	private final int strength = 150;
	private int hp = 100;
	
	
	@Override
	public int strike() {
		System.out.println("HorseMan strike "+ strength);
		return strength;
	}

	@Override
	public void parry(int receivedDamage) {
		this.hp -= receivedDamage;
	}

	@Override
	public int getHp() {
		return hp;
	}

}
