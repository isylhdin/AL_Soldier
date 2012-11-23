package model.visitor;

import model.composite.Army;
import model.proxy.HorseMan;
import model.proxy.InfantryMan;
import model.proxy.Soldier;

public interface SoldierVisitor {
	void visit(InfantryMan i);
	void visit(HorseMan s);
	void visit(Army a);
}
