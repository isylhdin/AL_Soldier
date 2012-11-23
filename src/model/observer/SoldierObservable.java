package model.observer;

import java.util.Observable;

public class SoldierObservable extends Observable {

	@Override
	public void notifyObservers(Object arg) {
		this.setChanged();
		super.notifyObservers(arg);
	}
	
}
