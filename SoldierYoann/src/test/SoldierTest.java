package test;

import static org.junit.Assert.*;

import model.decorateur.IInfantryMan;
import model.decorateur.Shield;
import model.decorateur.ISoldier;
import model.decorateur.Sword;
import model.proxy.InfantryMan;
import model.proxy.SoldierAbstract;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoldierTest {

	ISoldier s;
	ISoldier sword;
	ISoldier shield;

	@Before
	public void setUp() throws Exception {
		s = new IInfantryMan();
		sword = new Sword(s);
		shield = new Shield(sword); 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void infantryStrikeTest() {
		assertEquals(100, s.strikeForce());
	}

	@Test
	public void swordStrikeTest() {
		assertEquals(300, sword.strikeForce());
	}
	
	@Test
	public void shieldStrikeTest() {
		assertEquals(360, shield.strikeForce());
	}
	
	@Test
	public void parryTest(){
		int damage = 360;
		System.out.println("Soldier reçoit un coup de "+damage+" dégats et il pare avec son bouclier, il a initialement " + s.getHealthPoints() + " hp");
		shield.parry(damage);
		assertEquals(s.getHealthPoints(), 40);
		System.out.println("il lui reste "+ s.getHealthPoints() +" hp");
		System.out.println("-----------------------");
	}
	
	/****************************************************************************************************/
	
	@Test
	public void AddSwordTest(){
		SoldierAbstract infantryMan = new InfantryMan();
		
		//Ajout d'une premiere sword
		infantryMan.addSword();
		
		//Il n'est pas possible d'en ajouter une autre
		Assert.assertEquals(false,infantryMan.canAddWeapon(Sword.class));
		System.out.println("-----------------------");
	}
	
	@Test
	public void strikeProxy() {
		System.out.println("Utilisation du proxy");
		SoldierAbstract infantryMan = new InfantryMan();
		assertEquals(100, infantryMan.strike());
		System.out.println("-----------------------");
	}
	
	
	
	

}
