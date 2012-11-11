package model.composite;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;

import model.proxy.Soldier;
import model.proxy.SoldierAbstract;
import model.visitor.SoldierVisitor;

public class Army implements Soldier {

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
		int damagePerSoldier  = damage / getNbSoldier();
		System.out.println("Each soldat has to parry "+ damagePerSoldier + " damage");
		divideParry(damagePerSoldier);

	}


	public void divideParry(int damage){
		for (Soldier s : army) {
			if(s instanceof Army){
				((Army) s).divideParry(damage);
			}else{
				s.parry(damage);
			}
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

	public List<Soldier> getListOfSoldier(){
		return this.army;
	}
	
	
	public int getNbSoldier(){
		int nbSoldier = 0;	
		for(Soldier s : army){
			if(s instanceof Army){
				nbSoldier += ((Army)s).getNbSoldier();	
			}
			else {
				nbSoldier += 1;		
			}
		}
		return nbSoldier;
	}

	@Override
	public void accept(SoldierVisitor s) {
		s.visit(this);
	}


}
