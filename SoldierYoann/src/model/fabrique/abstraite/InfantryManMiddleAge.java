package model.fabrique.abstraite;

import java.lang.reflect.Field;

import model.decorateur.Shield;
import model.decorateur.Sword;
import model.proxy.InfantryMan;

public class InfantryManMiddleAge extends InfantryMan{

	public InfantryManMiddleAge(String name) {
		super(name);	
	}
	
	
	@Override
	public void addWeapon() {
		if(canAddWeapon(Sword.class)){
			addWeapon(Sword.class);
		}else{
			addWeapon(Shield.class);
		}
	}
	
}
