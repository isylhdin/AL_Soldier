package model.fabrique.abstraite;

import java.util.Observable;

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
