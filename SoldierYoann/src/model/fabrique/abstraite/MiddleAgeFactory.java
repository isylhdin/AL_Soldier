package model.fabrique.abstraite;

import model.proxy.HorseMan;
import model.proxy.InfantryMan;

public class MiddleAgeFactory implements AbstractFactory {

	@Override
	public HorseMan newHorseMan(String name) {
		return new HorseManMiddleAge(name);
	}

	@Override
	public InfantryMan newInfantryMan(String name) {
		return new InfantryManMiddleAge(name);
	}

}
