package model.visitor;

import java.lang.reflect.Field;

import model.composite.Army;
import model.proxy.HorseMan;
import model.proxy.InfantryMan;
import model.proxy.Soldier;

public class SoldierTypeConcrete implements SoldierVisitor {

	int nbInfantryMan = 0;
	int nbHorseMan = 0;



	private void computeSoldierOfEachType(Army a){
		for(Soldier s : a.getListOfSoldier()){
			if(s instanceof Army){
				this.computeSoldierOfEachType((Army)s);
			}else{
				if(s instanceof HorseMan){
					visit((HorseMan)s);
				}
				else
				{
					visit((InfantryMan)s);
				}
			}
		}	
	}

	@Override
	public void visit(InfantryMan i) {
		this.nbInfantryMan++;
	}

	@Override
	public void visit(HorseMan s) {
		this.nbHorseMan++;
	}

	@Override
	public void visit(Army a) {
		computeSoldierOfEachType(a);
		System.out.println("L'armée contient "+nbInfantryMan+" infantryMen et "+nbHorseMan+" HorseMen");
	}

}
