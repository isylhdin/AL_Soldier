package model.fabrique.abstraite;

import model.decorateur.LightSaber;
import model.proxy.HorseMan;

public class HorseManScienceFiction extends HorseMan {


	public HorseManScienceFiction(String name) {
		super(name);	
	}
	
	
	public void addWeapon() {
		this.addWeapon(LightSaber.class);
	}

}
