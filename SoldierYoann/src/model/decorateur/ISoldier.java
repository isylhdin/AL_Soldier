package model.decorateur;

public interface ISoldier {
	
	/**
	 * Computes the power of an attack that a Soldier can do.
	 * 
	 * @return force of the soldier
	 */
	public int strikeForce();
	
	/**
	 * Parry an attack,
	 * 
	 * @param damage
	 *            force of the attack
	 */
	public void parry(int damage);
	
	
	/**
	 * @return the health points of a soldier
	 */
	public int getHealthPoints();
	
	public String getName();	
}
