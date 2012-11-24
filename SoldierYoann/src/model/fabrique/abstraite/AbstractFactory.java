package model.fabrique.abstraite;

import model.proxy.HorseMan;
import model.proxy.InfantryMan;

public interface AbstractFactory {
	public HorseMan newHorseMan(String name);
	public InfantryMan newInfantryMan(String name);

}
