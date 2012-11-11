package model.proxy;

import model.visitor.SoldierVisitor;

public interface Soldier {
	
	public void addSword();
	public void addShield();
	
	public int strikeForce();
	public void parry(int damage);
	public int getHealthPoints();
	
	public void accept(SoldierVisitor s);
			
}
