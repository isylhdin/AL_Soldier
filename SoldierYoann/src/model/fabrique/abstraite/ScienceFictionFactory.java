package model.fabrique.abstraite;

import model.proxy.HorseMan;
import model.proxy.InfantryMan;

public class ScienceFictionFactory implements AbstractFactory {

	@Override
	public InfantryMan newInfantryMan(String name) {
		return new InfantryManScienceFiction(name);
	}

	@Override
	public HorseMan newHorseMan(String name) {
		return new HorseManScienceFiction(name);
	}

}