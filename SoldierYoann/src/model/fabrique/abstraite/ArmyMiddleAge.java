package model.fabrique.abstraite;

import model.composite.Army;
import model.proxy.Soldier;

public class ArmyMiddleAge extends Army {

	public void addSoldier(Soldier s) {
		if(s instanceof InfantryManMiddleAge || s instanceof HorseManMiddleAge || s instanceof ArmyMiddleAge){
			super.addSoldier(s);
		}else{
			System.out.println("Impossible d'ajouter un soldat de famille différente !");
		}
	}
}
