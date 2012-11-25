package model.fabrique.abstraite;

import model.composite.Army;
import model.proxy.HorseMan;
import model.proxy.InfantryMan;

public interface AbstractFactory {
	public HorseMan newHorseMan(String name);
	public InfantryMan newInfantryMan(String name);
	public Army newArmy();

}
