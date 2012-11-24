package test;

import static org.junit.Assert.assertEquals;
import model.composite.Army;
import model.decorateur.IInfantryMan;
import model.decorateur.ISoldier;
import model.decorateur.LightSaber;
import model.decorateur.Shield;
import model.decorateur.Sword;
import model.decorateur.Winchester;
import model.fabrique.abstraite.AbstractFactory;
import model.fabrique.abstraite.HorseManMiddleAge;
import model.fabrique.abstraite.InfantryManMiddleAge;
import model.fabrique.abstraite.MiddleAgeFactory;
import model.fabrique.abstraite.ScienceFictionFactory;
import model.fabrique.abstraite.WorldWarFactory;
import model.observer.DeadSoldierCountObserver;
import model.observer.DeadSoldierNameObserver;
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
		soldier1 = new InfantryManMiddleAge("Richard");
		soldier2 = new HorseManMiddleAge("Thibault");
		soldier3 = new InfantryManMiddleAge("Baptiste");
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
		SoldierAbstract infantryMan = new InfantryManMiddleAge("florian");

		//Ajout d'une premiere sword
		infantryMan.addWeapon();

		//Il n'est pas possible d'en ajouter une autre
		Assert.assertEquals(false,infantryMan.canAddWeapon(Sword.class));
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

		army.addWeapon();
		assertEquals(soldier1.strikeForce()+ soldier2.strikeForce()+soldier3.strikeForce(),army.strikeForce());
	}

	@Test
	public void addArmyShieldTest(){
		addGroupsTest();
		army.addSoldier(group1);
		army.addSoldier(group2);
		//soldat a un bouclier en plus = degat / 3
		army.parry(300);

		assertEquals(50,army.getHealthPoints());
	}


	/*****************************  Visitor Test ***************************/

	@Test
	public void PrintArmyTest(){
		addGroupsTest();
		army.addSoldier(group1);
		army.addSoldier(group2);
		army.accept(new SoldierPrintConcrete());
		System.out.println("ET");

		SoldierTypeConcrete soldierType = new SoldierTypeConcrete();

		army.accept(soldierType);
		System.out.println("Il y a "+soldierType.getNbArmy()+" army, "+soldierType.getNbInfantryMan()+" infantryman et "+ soldierType.getNbHorseMan()+" horseman");

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
		soldier1.addObserver(dsno);
		soldier2.addObserver(dsno);
		soldier3.addObserver(dsno);

		DeadSoldierCountObserver dsco = DeadSoldierCountObserver.getInstance();
		soldier1.addObserver(dsco);
		soldier2.addObserver(dsco);
		soldier3.addObserver(dsco);
		group1.addObserver(dsco);
		group2.addObserver(dsco);
		army.addObserver(dsco);
		

		army.parry(400);

		army.accept(new SoldierPrintConcrete());
		System.out.println("------------------------------");

	}
	
	/*****************************  Factory Test ***************************/
	
	@Test
	public void addWeaponFactory(){
		AbstractFactory middleAge = new MiddleAgeFactory();
		AbstractFactory scienceFiction = new ScienceFictionFactory();
		AbstractFactory worldWar = new WorldWarFactory();
		
		InfantryMan iM =middleAge.newInfantryMan("yoann");
		iM.addWeapon();
		iM.addWeapon();
		Assert.assertEquals(false,iM.canAddWeapon(Sword.class));
		Assert.assertEquals(false,iM.canAddWeapon(Shield.class));
		System.out.println("StrikeForce : "+iM.strikeForce());
		System.out.println("EquipedItems de middleAge : "+iM.equipedItems);
		
		InfantryMan iS = scienceFiction.newInfantryMan("richard");
		iS.addWeapon();
		iS.addWeapon();
		Assert.assertEquals(false,iM.canAddWeapon(LightSaber.class));
		Assert.assertEquals(2,iM.equipedItems.size());
		System.out.println("StrikeForce : "+iS.strikeForce());
		System.out.println("EquipedItems de scienceFiction : "+iS.equipedItems);
		
		InfantryMan iW = worldWar.newInfantryMan("albert");
		iW.addWeapon();
		Assert.assertEquals(false,iW.canAddWeapon(Winchester.class));
		Assert.assertEquals(1,iW.equipedItems.size());
		System.out.println("StrikeForce : "+iW.strikeForce());
		System.out.println("EquipedItems de worldWar : "+iW.equipedItems);	
		
		

		System.out.println("------------------------------");
	}
	
	
	
	@Test
	public void addWeaponArmyFactory(){
		AbstractFactory middleAge = new MiddleAgeFactory();
		AbstractFactory scienceFiction = new ScienceFictionFactory();
		AbstractFactory worldWar = new WorldWarFactory();
		
		InfantryMan iM =middleAge.newInfantryMan("yoann");
		InfantryMan iS = scienceFiction.newInfantryMan("richard");
		InfantryMan iW = worldWar.newInfantryMan("albert");
		
		group1.addSoldier(iM);
		group1.addSoldier(iS);

		group2.addSoldier(iW);
		army.addSoldier(group1);
		army.addSoldier(group2);
		
		army.addWeapon();
		Assert.assertEquals(3,iW.equipedItems.size()+iM.equipedItems.size()+iS.equipedItems.size());
		army.addWeapon();
		Assert.assertEquals(5,iW.equipedItems.size()+iM.equipedItems.size()+iS.equipedItems.size());
		
		System.out.println("EquipedItems de worldWar : "+iW.equipedItems);	
		System.out.println("EquipedItems de scienceFiction : "+iS.equipedItems);
		System.out.println("EquipedItems de middleAge : "+iM.equipedItems);
		Assert.assertEquals(1410,army.strikeForce());
		
		System.out.println("------------------------------");
	}
	
	
}
