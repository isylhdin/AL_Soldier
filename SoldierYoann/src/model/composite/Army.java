package model.composite;

import java.util.ArrayList;
import java.util.List;

import model.proxy.Soldier;

public class Army implements Soldier {

	private List<Soldier> army = new ArrayList<Soldier>();

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
		int damagePerSoldier = damage / this.army.size();
		for (Soldier s : army) {
			s.parry(damagePerSoldier);
		}
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

	public int getNbSoldier(){
		return army.size();
	}


}
