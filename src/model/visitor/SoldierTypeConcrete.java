package model.visitor;

import model.composite.Army;
import model.proxy.HorseMan;
import model.proxy.InfantryMan;

public class SoldierTypeConcrete implements SoldierVisitor {

	int nbInfantryMan = 0;
	int nbHorseMan = 0;
	int nbArmy = 0;


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
		nbArmy++;	
	}

	public int getNbInfantryMan() {
		return nbInfantryMan;
	}

	public int getNbHorseMan() {
		return nbHorseMan;
	}

	public int getNbArmy() {
		return nbArmy;
	}
	
}
