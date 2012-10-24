package test;

import static org.junit.Assert.*;

import model.decorateur.InfantryMan;
import model.decorateur.Shield;
import model.decorateur.Soldier;
import model.decorateur.Sword;
import model.proxy.InfantryManProxy;
import model.proxy.SoldierProxy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoldierTest {

	Soldier s;
	Soldier sword;
	Soldier shield;

	@Before
	public void setUp() throws Exception {
		s = new InfantryMan();
		sword = new Sword(s);
		shield = new Shield(sword); 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void infantryStrikeTest() {
		System.out.println("infantryStrikeTest");
		assertEquals(100, s.strike());
		System.out.println("-----------------------");
	}

	@Test
	public void swordStrikeTest() {
		System.out.println("swordStrikeTest");
		assertEquals(300, sword.strike());
		System.out.println("-----------------------");
	}
	
	@Test
	public void shieldStrikeTest() {
		System.out.println("shieldStrikeTest");
		assertEquals(360, shield.strike());
		System.out.println("-----------------------");
	}
	
	@Test
	public void parryTest(){
		int damage = 360;
		System.out.println("Soldier reçoit un coup de "+damage+" dégats et il pare avec son bouclier, il a initialement " + s.getHp() + " hp");
		shield.parry(damage);
		assertEquals(s.getHp(), 40);
		System.out.println("il lui reste "+ s.getHp() +" hp");
		System.out.println("-----------------------");
	}
	
	/****************************************************************************************************/
	
	@Test
	public void AddSwordTest(){
		SoldierProxy infantryMan = new InfantryManProxy();
		
		//Ajout d'une premiere sword
		infantryMan.addSword();
		
		//Il n'est pas possible d'en ajouter une autre
		Assert.assertEquals(false,infantryMan.canAddWeapon());
		System.out.println("-----------------------");
	}
	
	@Test
	public void strikeProxy() {
		System.out.println("Utilisation du proxy");
		SoldierProxy infantryMan = new InfantryManProxy();
		assertEquals(100, infantryMan.strike());
		System.out.println("-----------------------");
	}
	
	
	
	

}
