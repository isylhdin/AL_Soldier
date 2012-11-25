package model.proxy;

import java.util.Observable;
import java.util.Observer;

import model.composite.Army;
import model.observer.DeadSoldierCountObserver;
import model.observer.DeadSoldierNameObserver;
import model.observer.SoldierObservable;
import model.visitor.SoldierVisitor;

/**
 * 
 * Un soldier est lui même un observer (en plus de DeadSoldierCountObserver et DeadSoldierNameObserver)
 * A sa création il est automatiquement observé par les 2 observers cités plus haut afin de maintenir
 * à jour une variable indiquant le nombre de soldats mort en temps réel + les noms des victimes.
 * 
 * Un soldat doit observer ses camarades (voir classe Army, méthode addSoldier) afin qu'un télégramme
 * leur soit envoyé quand il meurt.
 *
 */
public abstract class Soldier implements Observer{
	
	private SoldierObservable soldierObservable = new SoldierObservable();
	private DeadSoldierCountObserver dc = DeadSoldierCountObserver.getInstance();
	private DeadSoldierNameObserver dn = DeadSoldierNameObserver.getInstance();
	
	public Soldier(){
		this.addObserver(dc);
		this.addObserver(dn);
	}
	
	
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
	
	//Envoie de télégramme à ses frères d'arme
	@Override
	public void update(Observable obs, Object obj) {
		Soldier s = (Soldier)obj;
		if( (s.getHealthPoints() <= 0  && !(obj instanceof Army))){
			System.out.println("Un télégramme a été envoyé aux frères d'arme de "+ s.getName());
		}
	}
	
			
}
