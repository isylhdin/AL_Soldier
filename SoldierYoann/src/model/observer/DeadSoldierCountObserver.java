package model.observer;

import java.util.Observable;
import java.util.Observer;

import model.composite.Army;
import model.proxy.Soldier;

public class DeadSoldierCountObserver implements Observer{





	private int nbDeadSoldier = 0;

	@Override
	public void update(Observable o, Object arg) {
		Soldier s = (Soldier)arg;
		if( s.getHealthPoints() <= 0  && !(arg instanceof Army)){
			nbDeadSoldier ++;
			if(nbDeadSoldier == 1){
				System.out.println(nbDeadSoldier + " soldat est mort");
			}else{
				System.out.println(nbDeadSoldier + " soldats sont morts");
			}
		}


	}



	private static DeadSoldierCountObserver dsco;

	private DeadSoldierCountObserver() {	}
	public static DeadSoldierCountObserver getInstance() {
		if (dsco == null) {
			dsco = new DeadSoldierCountObserver();
		}
		return dsco;
	}
}
