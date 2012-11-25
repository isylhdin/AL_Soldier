package model.fabrique.abstraite;

import model.composite.Army;
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

	@Override
	public Army newArmy() {
		return new ArmyMiddleAge();
	}

}
