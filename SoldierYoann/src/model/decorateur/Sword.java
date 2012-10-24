package model.decorateur;

public class Sword extends WeaponDeco {


	public Sword(Soldier s) {
		super(s);
	}

	@Override
	public int strike() {
		int SwordDamage = 200;
		int totalDamage = super.strike() + SwordDamage;

		System.out.println("Sword + other damage = "+ totalDamage);
		return totalDamage;
	}

	@Override
	public void parry(int damage) {
		super.parry(damage/2);
	}


}
