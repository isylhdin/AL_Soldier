package model.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import model.decorateur.AbstractWeapon;
import model.decorateur.Shield;
import model.decorateur.ISoldier;
import model.decorateur.Sword;
import model.decorateur.WeaponDeco;



public abstract class SoldierAbstract extends Soldier {

	private ISoldier soldier;
	public List<String> equipedItems = new ArrayList<String>();

	public SoldierAbstract(ISoldier soldier) {
		super();
		this.soldier = soldier;
	}
	
	
	public boolean canAddWeapon(Class weapon){
		ISoldier it = soldier;
		while(it instanceof WeaponDeco){
			if(it.getClass().equals(weapon)){
				System.out.println("Il n'est pas possible de rajouter cette arme");
				return false;
			}else{
				it = ((WeaponDeco) soldier).getDeleg();
			}
		}
		return true;
	}

	
	@Override
	public void addSword() {
		if(canAddWeapon(Sword.class)){
			soldier = new Sword(soldier);
			equipedItems.add(Sword.class.getName());
			System.out.println("Arme ajoutée !");
		}
	}

	@Override
	public void addShield() {
		if(canAddWeapon(Shield.class)){
			soldier = new Shield(soldier);
			equipedItems.add(Shield.class.getName());
			System.out.println("Bouclier ajouté !");
		}
	}
	
	public void addWeapon(Class weapon){
		
		try {
			Constructor<?>[] cons = weapon.getConstructors();
			Object[] argc = { soldier };
			soldier = (ISoldier) cons[0].newInstance(argc);
			equipedItems.add(weapon.getName());
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}
	
	public abstract void addWeapon();
	
	
	@Override
	public int strikeForce() {
		return soldier.strikeForce();
	}

	@Override
	public void parry(int damage) {
		soldier.parry(damage);

	}

	@Override
	public int getHealthPoints() {
		return soldier.getHealthPoints();
	}
	
	public String getName(){
		return soldier.getName();
	}

}
