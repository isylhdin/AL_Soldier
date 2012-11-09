package model.proxy;

public interface Soldier {
	
	public void addSword();
	public void addShield();
	
	public int strikeForce();
	public void parry(int damage);
	public int getHealthPoints();
	
	
}
