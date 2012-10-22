package model;

public class WeaponDeco implements Soldier {

	private Soldier s;
	
	public WeaponDeco(Soldier s) {
		super();
		this.s = s;
	}

	@Override
	public int strike() {
		return s.strike();
	}

	@Override
	public void parry(int damage) {
		s.parry(damage);
	}

	@Override
	public int getHp() {
		return s.getHp();
	}

}
