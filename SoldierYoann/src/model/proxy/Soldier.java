package model.proxy;

import java.util.Observer;

import model.observer.SoldierObservable;
import model.visitor.SoldierVisitor;

public abstract class Soldier {
	
	private SoldierObservable soldierObservable = new SoldierObservable();
	
	/* A supprimer */
//	public abstract void addSword();
//	public abstract void addShield();
	/*********************************/
	
	public abstract void addWeapon();
	      
	public abstract int strikeForce();
	
	
	public void parry(int damage) {
		soldierObservable.notifyObservers(this);
	}
	
	public abstract int getHealthPoints();
	
	public abstract String getName();
	        
	public abstract void accept(SoldierVisitor s);
	
	
	public void addObserver(Observer observer){
		soldierObservable.addObserver(observer);
	};
	
	public void removeObserver(Observer observer){
		soldierObservable.deleteObserver(observer);
	}
	
	
	
			
}
