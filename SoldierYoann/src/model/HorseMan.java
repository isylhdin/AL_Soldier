package model;

public class HorseMan implements Soldier {

	private final int strength = 150;
	private final int hp = 100;
	
	
	@Override
	public int strike() {
		System.out.println("HorseMan strike "+ strength);
		return strength;
	}

	@Override
	public int parry() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHp() {
		return hp;
	}

}
