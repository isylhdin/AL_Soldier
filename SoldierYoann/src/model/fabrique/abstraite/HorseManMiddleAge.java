package model.fabrique.abstraite;

import model.decorateur.Shield;
import model.decorateur.Sword;
import model.proxy.HorseMan;

public class HorseManMiddleAge extends HorseMan {

	public HorseManMiddleAge(String name) {
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
