package model.fabrique.abstraite;

import model.proxy.InfantryMan;

public interface AbstractFactory {
	//public AbstractInfantryMan newHorseMan(String name);
	public InfantryMan newInfantryMan(String name);

}
