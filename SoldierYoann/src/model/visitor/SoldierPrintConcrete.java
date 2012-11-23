package model.visitor;


import model.composite.Army;
import model.proxy.HorseMan;
import model.proxy.InfantryMan;
import model.proxy.Soldier;


public class SoldierPrintConcrete implements SoldierVisitor {


	private void print(Soldier s){
		int healthPoint = s.getHealthPoints();
		int strikeForce = s.strikeForce();
		String name = s.getName();

		System.out.println(name+" has "+healthPoint+" healthpoint and "+strikeForce+" strengh");
	}


	@Override
	public void visit(Army a) {
		print(a);
	}

	@Override
	public void visit(InfantryMan i) {
		print(i);	
	}

	@Override
	public void visit(HorseMan h) {
		print(h);	
	}




}
