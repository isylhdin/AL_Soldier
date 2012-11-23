package model.composite;

import java.util.ArrayList;
import java.util.List;

import model.proxy.Soldier;
import model.visitor.SoldierVisitor;

public class Army extends Soldier {

	private List<Soldier> army;


	public Army(){
		army = new ArrayList<Soldier>();
	}

	@Override
	public void addSword() {
		for (Soldier s : army) {
			s.addSword();
		}
	}

	@Override
	public void addShield() {
		for (Soldier s : army) {
			s.addShield();
		}
	}

	@Override
	public int strikeForce() {
		int allDamage = 0;
		for (Soldier s : army) {
			allDamage += s.strikeForce();
		}
		return allDamage;
	}


	@Override
	public void parry(int damage) {
		int damagePerSoldier  = damage / this.army.size();
		for (Soldier s : army) 
			s.parry(damagePerSoldier);
		
		super.parry(damagePerSoldier);
	}

	@Override
	public int getHealthPoints() {
		int allHP = 0;
		for (Soldier s : army) {
			allHP += s.getHealthPoints();
		}
		return allHP;
	}

	public void addSoldier(Soldier s) {
		army.add(s);
	}

	public void removeSoldier(Soldier s) {
		army.remove(s);
	}

	public List<Soldier> getListOfSoldier(){
		return this.army;
	}

	@Override
	public void accept(SoldierVisitor v) {
		v.visit(this);
		for (Soldier s : army) 
			s.accept(v);
	}

	@Override
	public String getName() {
		return "Army";
	}

	// on ne doit pas spécifier quel type d'arme on attribue, c'est à la fabrique abstraite de le faire
	@Override
	public void addWeapon() {
		for (Soldier s : army) {
			s.addWeapon();
		}
	}


	
}
