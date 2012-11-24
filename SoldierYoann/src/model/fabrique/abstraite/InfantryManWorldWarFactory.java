package model.fabrique.abstraite;

import model.decorateur.Winchester;
import model.proxy.InfantryMan;

public class InfantryManWorldWarFactory extends InfantryMan {

	
	public InfantryManWorldWarFactory(String name) {
		super(name);	
	}
	
	@Override
	public void addWeapon() {
		this.addWeapon(Winchester.class);
	}

}
