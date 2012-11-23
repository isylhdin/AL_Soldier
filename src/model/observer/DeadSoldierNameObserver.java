package model.observer;

import java.util.Observable;
import java.util.Observer;

import model.proxy.Soldier;

public class DeadSoldierNameObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		Soldier s = (Soldier)arg;
		if( s.getHealthPoints() <= 0 )
			System.out.println(s.getName() + " est mort, un télégramme a été envoyé à sa famille");
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
