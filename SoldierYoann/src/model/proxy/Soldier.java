package model.proxy;

public interface Soldier {
	
	public void addSword();
	public void addShield();
	
	public int strike();
	public void parry(int damage);
	public int getHp();
	
	
}