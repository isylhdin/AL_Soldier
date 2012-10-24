package model.decorateur;

public abstract class SoldierAbstract implements Soldier {

	private int hp;
	private int strength;
	
	
	public SoldierAbstract(int hp, int strength) {
		super();
		this.hp = hp;
		this.strength = strength;
	}


	@Override
	public int strike() {
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
