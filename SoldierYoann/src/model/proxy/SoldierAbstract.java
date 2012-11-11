package model.proxy;

import model.decorateur.Shield;
import model.decorateur.ISoldier;
import model.decorateur.Sword;
import model.decorateur.WeaponDeco;


/**
 * 
 * Classe visible par le client, vu de l'ext�rieur. Aurait pu se nommer "Soldier" 
 * pour lui, mais on gardera le nom "SoldierProxy" pour plus de compr�hension et 
 * mettre en �vidence le pattern Proxy
 * 
 * 
 * @author yoann
 *
 */
public abstract class SoldierAbstract implements Soldier {

	private ISoldier soldier;

	public SoldierAbstract(ISoldier soldier) {
		super();
		this.soldier = soldier;
	}
	
	
	public boolean canAddWeapon(Class weapon){
		ISoldier it = soldier;
		while(it instanceof WeaponDeco){
			if(it.getClass().equals(weapon)){
				System.out.println("Pas possible d'ajouter une nouvelle arme, le personnage en a d�j� une !");
				return false;
			}else{
				it = ((WeaponDeco) soldier).getDeleg();
			}
		}
		return true;
	}

	
	@Override
	public void addSword() {
		if(canAddWeapon(Sword.class)){
			soldier = new Sword(soldier);
			System.out.println("Arme ajout�e !");
		}
	}

	@Override
	public void addShield() {
		if(canAddWeapon(Shield.class)){
			soldier = new Shield(soldier);
			System.out.println("Bouclier ajout� !");
		}
	}

	@Override
	public int strikeForce() {
		return soldier.strikeForce();
	}

	@Override
	public void parry(int damage) {
		soldier.parry(damage);

	}

	@Override
	public int getHealthPoints() {
		return soldier.getHealthPoints();
	}
	


}
