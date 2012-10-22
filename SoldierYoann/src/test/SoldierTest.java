package test;

import static org.junit.Assert.*;

import model.InfantryMan;
import model.Shield;
import model.Soldier;
import model.Sword;

import org.junit.After;
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
		System.out.println("Soldier re�oit un coup de "+damage+" d�gats et il pare avec son bouclier, il a initialement " + s.getHp() + " hp");
		shield.parry(damage);
		assertEquals(s.getHp(), 40);
		System.out.println("il lui reste "+ s.getHp() +" hp");
	}

}
