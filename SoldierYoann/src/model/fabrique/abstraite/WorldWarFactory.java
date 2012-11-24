package model.fabrique.abstraite;

import model.proxy.HorseMan;
import model.proxy.InfantryMan;

public class WorldWarFactory implements AbstractFactory {

	@Override
	public InfantryMan newInfantryMan(String name) {
		return new InfantryManWorldWarFactory(name);
	}

	@Override
	public HorseMan newHorseMan(String name) {
		return new HorseManWorldWar(name);
	}

}
