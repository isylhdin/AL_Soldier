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
 * Un soldier est lui m�me un observer (en plus de DeadSoldierCountObserver et DeadSoldierNameObserver)
 * A sa cr�ation il est automatiquement observ� par les 2 observers cit�s plus haut afin de maintenir
 * � jour une variable indiquant le nombre de soldats mort en temps r�el + les noms des victimes.
 * 
 * Un soldat doit observer ses camarades (voir classe Army, m�thode addSoldier) afin qu'un t�l�gramme
 * leur soit envoy� quand il meurt.
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
	
	//Envoie de t�l�gramme � ses fr�res d'arme
	@Override
	public void update(Observable obs, Object obj) {
		Soldier s = (Soldier)obj;
		if( (s.getHealthPoints() <= 0  && !(obj instanceof Army))){
			System.out.println("Un t�l�gramme a �t� envoy� aux fr�res d'arme de "+ s.getName());
		}
	}
	
			
}
