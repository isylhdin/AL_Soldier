package model.decorateur;

public class AbstractWeapon extends WeaponDeco {
	
	private int weaponDamage;
	private double parryRatio;

	public AbstractWeapon(ISoldier s, int force, double parryRatio) {
		super(s);
		this.weaponDamage = force;
		this.parryRatio = parryRatio;
		
	}

	@Override
	public int strikeForce() {
		return super.strikeForce() + weaponDamage;
	}

	@Override
	public void parry(int damage) {
		super.parry((int) (damage / parryRatio));
	}

	

}
