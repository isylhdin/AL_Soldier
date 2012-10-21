package model;

public class Shield extends WeaponDeco {

	
	public Shield(Soldier s) {
		super(s);
	}

	@Override
	public int strike() {
		int shieldDamage = 60;
		int totalDamage = super.strike() + shieldDamage;
		System.out.println("Shield + other damage = "+ totalDamage);
		return totalDamage;
	}

	@Override
	public int parry() {
		// TODO Auto-generated method stub
		return super.parry();
	}

}