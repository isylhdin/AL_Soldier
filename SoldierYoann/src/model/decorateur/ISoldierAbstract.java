package model.decorateur;

public abstract class ISoldierAbstract implements ISoldier {

	private int hp;
	private int strength;
	private String name;
	
	
	public ISoldierAbstract(int hp, int strength) {
		super();
		this.hp = hp;
		this.strength = strength;
	}
	
	public ISoldierAbstract(int hp, int strength, String name) {
		super();
		this.hp = hp;
		this.strength = strength;
		this.name = name;
	}


	@Override
	public int strikeForce() {
		return strength;
	}

	@Override
	public void parry(int damage) {
		this.hp -= damage;
		if (this.hp < 0)
			this.hp = 0;
	}

	@Override
	public int getHealthPoints() {
		return hp;
	}
	
	public String getName() {
		return name;
	}

}
