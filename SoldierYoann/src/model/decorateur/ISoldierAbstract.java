package model.decorateur;

public abstract class ISoldierAbstract implements ISoldier {

	private int hp;
	private int strength;
	
	
	public ISoldierAbstract(int hp, int strength) {
		super();
		this.hp = hp;
		this.strength = strength;
	}


	@Override
	public int strikeForce() {
		return strength;
	}

	@Override
	public void parry(int damage) {
		this.hp -= damage;
	}

	@Override
	public int getHealthPoints() {
		return hp;
	}

}
