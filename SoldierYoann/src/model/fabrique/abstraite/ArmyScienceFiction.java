package model.fabrique.abstraite;

import model.composite.Army;
import model.proxy.Soldier;

public class ArmyScienceFiction extends Army {

	
	public void addSoldier(Soldier s) {
		if(s instanceof InfantryManScienceFiction || s instanceof HorseManScienceFiction || s instanceof ArmyScienceFiction){
			super.addSoldier(s);
		}else{
			System.out.println("Impossible d'ajouter un soldat de famille différente !");
		}
	}
}
