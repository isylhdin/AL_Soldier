package model.fabrique.abstraite;

import model.composite.Army;
import model.proxy.Soldier;

public class ArmyWorldWar extends Army {

	
	public void addSoldier(Soldier s) {
		if(s instanceof InfantryManWorldWarFactory || s instanceof HorseManWorldWar || s instanceof ArmyWorldWar){
			super.addSoldier(s);
		}else{
			System.out.println("Impossible d'ajouter un soldat de famille différente !");
		}
	}
}
