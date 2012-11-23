package model.fabrique.abstraite;

import java.lang.reflect.Field;

import model.decorateur.Shield;
import model.decorateur.Sword;
import model.proxy.InfantryMan;

public class InfantryManMiddleAge extends InfantryMan{

	public InfantryManMiddleAge(String name) {
		super(name);	
	}
	
	
	public void addWeapon() {
		if(this.equipedItems.isEmpty()){
			this.addWeapon(Sword.class);
		}else{
			this.addWeapon(Shield.class);
		}
	}
	
}
