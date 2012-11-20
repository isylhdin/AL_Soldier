package test;

import static org.junit.Assert.assertEquals;
import model.composite.Army;
import model.decorateur.IInfantryMan;
import model.decorateur.ISoldier;
import model.decorateur.Shield;
import model.decorateur.Sword;
import model.observer.DeadSoldierCountObserver;
import model.observer.DeadSoldierNameObserver;
import model.proxy.HorseMan;
import model.proxy.InfantryMan;
import model.proxy.Soldier;
import model.proxy.SoldierAbstract;
import model.visitor.SoldierPrintConcrete;
import model.visitor.SoldierTypeConcrete;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoldierTest {

	private ISoldier s;
	private ISoldier sword;
	private ISoldier shield;
	private Army army;
	private Army group1;
	private Army group2;
	private Soldier soldier1;
	private Soldier soldier2;
	private Soldier soldier3;

	@Before
	public void setUp() throws Exception {
		s = new IInfantryMan();
		sword = new Sword(s);
		shield = new Shield(sword); 
		army = new Army();
		group1 = new Army();
		group2 = new Army();
		soldier1 = new InfantryMan("Richard");
		soldier2 = new HorseMan("Thibault");
		soldier3 = new InfantryMan("Baptiste");
	}

	@After
	public void tearDown() throws Exception {
	}


	/*****************************  Decorateur Test ***************************/
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
		System.out.println("Soldier reçoit un coup de "+damage+" degats et il pare avec son bouclier, il a initialement " + s.getHealthPoints() + " hp");
		shield.parry(damage);
		assertEquals(s.getHealthPoints(), 40);
		System.out.println("il lui reste "+ s.getHealthPoints() +" hp");
		System.out.println("-----------------------");
	}


	/*****************************  Proxy Test ***************************/

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
		SoldierAbstract infantryMan = new InfantryMan();
		assertEquals(100, infantryMan.strikeForce());
	}


	/*****************************  Composite Test ***************************/

	private void addGroupsTest(){
		group1.addSoldier(soldier1);
		group1.addSoldier(soldier2);

		group2.addSoldier(soldier3);
	}

	@Test
	public void getArmyHealthPointTest(){
		addGroupsTest();
		army.addSoldier(group1);
		army.addSoldier(group2);
		assertEquals(soldier1.getHealthPoints()+ soldier2.getHealthPoints()+soldier3.getHealthPoints(),army.getHealthPoints());
	}

	@Test
	public void strikeForceArmyTest(){
		addGroupsTest();
		army.addSoldier(group1);
		army.addSoldier(group2);
		assertEquals(soldier1.strikeForce()+ soldier2.strikeForce()+soldier3.strikeForce(),army.strikeForce());
	}
	
	@Test
	public void parryArmyTest(){
		addGroupsTest();
		army.addSoldier(group1);
		army.addSoldier(group2);
		
		army.addShield();
		assertEquals(soldier1.strikeForce()+ soldier2.strikeForce()+soldier3.strikeForce(),army.strikeForce());
		System.out.println("-----------------------");
	}
	
	@Test
	public void addArmyShieldTest(){
		addGroupsTest();
		army.addSoldier(group1);
		army.addSoldier(group2);
		//soldat a un bouclier en plus = degat / 3
		soldier1.addShield();
		army.parry(300);
		
		assertEquals(100,army.getHealthPoints());
		System.out.println("-----------------------");
	}
	
	
	/*****************************  Visitor Test ***************************/

	@Test
	public void PrintArmyTest(){
		addGroupsTest();
		army.addSoldier(group1);
		army.addSoldier(group2);
		army.accept(new SoldierPrintConcrete());
		System.out.println("ET");
		army.accept(new SoldierTypeConcrete());
		System.out.println("-----------------------");
	}
	
	
	/*****************************  Observer Test ***************************/
	
	@Test
	public void ObserverTestPrintDead(){
		addGroupsTest();
		army.addSoldier(group1);
		army.addSoldier(group2);
		
		DeadSoldierNameObserver dsno = DeadSoldierNameObserver.getInstance();
		group1.addObserver(dsno);
		group2.addObserver(dsno);
		army.addObserver(dsno);
		soldier3.addObserver(dsno);
		
		DeadSoldierCountObserver dsco = DeadSoldierCountObserver.getInstance();
		group1.addObserver(dsco);
		group2.addObserver(dsco);
		army.addObserver(dsco);
		soldier3.addObserver(dsco);
		
		army.parry(300);
		
		army.accept(new SoldierPrintConcrete());

	}
}
