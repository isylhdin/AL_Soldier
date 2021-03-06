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
		System.out.println("Soldier re�oit un coup de "+damage+" degats et il pare avec son bouclier, il a initialement " + s.getHealthPoints() + " hp");
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

		army.parry(400);

		Assert.assertTrue(DeadSoldierCountObserver.getInstance().getNbDeadSoldier() >= 3);

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
		
		InfantryMan iM1 = middleAge.newInfantryMan("yoann");
		InfantryMan iM2 = middleAge.newInfantryMan("cedric");
		InfantryMan iM3 = middleAge.newInfantryMan("damien");
		InfantryMan iS = scienceFiction.newInfantryMan("richard");
		InfantryMan iW = worldWar.newInfantryMan("albert");
		
		
		Army group1 = middleAge.newArmy();
		Army group2 = middleAge.newArmy();
		Army army = middleAge.newArmy();
		
		group1.addSoldier(iM1);
		group1.addSoldier(iM2);

		group2.addSoldier(iM3);
		army.addSoldier(group1);
		army.addSoldier(group2);
		
		//ne doit pas marcher car de famille diff�rente
		group1.addSoldier(iS);
		Assert.assertTrue(group1.getListOfSoldier().size() == 2);
		
		
		army.addWeapon();
		Assert.assertEquals(3,iM1.equipedItems.size()+iM2.equipedItems.size()+iM3.equipedItems.size());
		army.addWeapon();
		Assert.assertEquals(6,iM1.equipedItems.size()+iM2.equipedItems.size()+iM3.equipedItems.size());
		//ne va pas marcher car chaque soldat a d�j� une �p�e et un boouclier
		army.addWeapon();
		Assert.assertEquals(6,iM1.equipedItems.size()+iM2.equipedItems.size()+iM3.equipedItems.size());
		
		System.out.println("EquipedItems de "+ iM1.getName()+" : "+iM1.equipedItems);	
		System.out.println("EquipedItems de "+ iM2.getName()+" : "+iM2.equipedItems);
		System.out.println("EquipedItems de "+ iM3.getName()+" : "+iM3.equipedItems);
		Assert.assertEquals(1080,army.strikeForce());
		
		System.out.println("------------------------------");
	}
	
	
}
