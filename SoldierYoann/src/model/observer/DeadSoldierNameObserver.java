package model.observer;

import java.util.Observable;
import java.util.Observer;

import model.composite.Army;
import model.proxy.Soldier;

public class DeadSoldierNameObserver implements Observer {


	@Override
	public void update(Observable arg0, Object arg) {
		Soldier s = (Soldier)arg;
		if(s.getHealthPoints() <= 0){
		
			if(s instanceof Army){
				String allSoldierName = "[ ";
				for(Soldier soldier : ((Army)s).getListOfSoldier()){
					allSoldierName += soldier.getName()+" ";
				}
				allSoldierName += "]";
				System.out.println("Le sous-groupe contenant les Soldiers "+allSoldierName+ " a été détruit");
			}else{
				System.out.println(s.getName() + " est mort");
			}
		}


	}

	private static DeadSoldierNameObserver dsno;

	private DeadSoldierNameObserver() {	}

	public static DeadSoldierNameObserver getInstance() {
		if (dsno == null) {
			dsno = new DeadSoldierNameObserver();
		}
		return dsno;
	}

	


}
