package model.fabrique.abstraite;

import model.decorateur.LightSaber;
import model.proxy.InfantryMan;

public class InfantryManScienceFiction extends InfantryMan {


	public InfantryManScienceFiction(String name) {
		super(name);	
	}
	
	@Override
	public void addWeapon() {
		this.addWeapon(LightSaber.class);
	}

}
