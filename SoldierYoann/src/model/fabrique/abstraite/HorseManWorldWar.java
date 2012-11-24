package model.fabrique.abstraite;

import model.decorateur.Winchester;
import model.proxy.HorseMan;

public class HorseManWorldWar extends HorseMan {

	public HorseManWorldWar(String name) {
		super(name);	
	}
	
	@Override
	public void addWeapon() {
		this.addWeapon(Winchester.class);
	}

}
