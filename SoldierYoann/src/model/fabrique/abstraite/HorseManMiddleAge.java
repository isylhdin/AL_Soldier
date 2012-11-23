package model.fabrique.abstraite;

import model.decorateur.Shield;
import model.decorateur.Sword;
import model.proxy.HorseMan;
import model.proxy.Soldier;
import model.visitor.SoldierVisitor;

public class HorseManMiddleAge extends HorseMan {

	public HorseManMiddleAge(String name) {
		super(name);
	}
		
	
	@Override
	public void addWeapon() {
		if(this.equipedItems.isEmpty()){
			this.addWeapon(Sword.class);
		}else{
			this.addWeapon(Shield.class);
		}		
	}

	

}
