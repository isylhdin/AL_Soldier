package model.visitor;


import model.composite.Army;
import model.proxy.HorseMan;
import model.proxy.InfantryMan;
import model.proxy.Soldier;


public class SoldierPrintConcrete implements SoldierVisitor {


	private void print(Soldier s){
		int healthPoint = s.getHealthPoints();
		int strikeForce = s.strikeForce();
		String className = s.getClass().getName();

		System.out.println(className+" has "+healthPoint+" healthpoint and "+strikeForce+" strengh");
	}


	@Override
	public void visit(Army a) {
		for(Soldier s : a.getListOfSoldier()){
			if(s instanceof Army){
				this.visit((Army)s);
			}else{
				print(s);
			}
		}	
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
