package model.decorateur;

public class AbstractWeapon extends WeaponDeco {
	
	private int weaponDamage;
	private double parryRatio;
	private boolean isOneHand;
	private boolean canBeHandledInBothHands;

	
	public AbstractWeapon(ISoldier s, int weaponDamage, double parryRatio,
			boolean isOneHand, boolean canBeHandledInBothHands) {
		super(s);
		this.weaponDamage = weaponDamage;
		this.parryRatio = parryRatio;
		this.isOneHand = isOneHand;
		this.canBeHandledInBothHands = canBeHandledInBothHands;
	}

	@Override
	public int strikeForce() {
		return super.strikeForce() + weaponDamage;
	}

	@Override
	public void parry(int damage) {
		super.parry((int) (damage / parryRatio));
	}

	/**
	 * @return the isOneHand
	 */
	public boolean isOneHand() {
		return isOneHand;
	}

	/**
	 * @return the canBeHandledInBothHands
	 */
	public boolean CanBeHandledInBothHands() {
		return canBeHandledInBothHands;
	}

}
