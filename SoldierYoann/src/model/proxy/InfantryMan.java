package model.proxy;

import model.decorateur.IInfantryMan;
import model.visitor.SoldierVisitor;

public abstract class InfantryMan extends SoldierAbstract {
	
	public InfantryMan(){
		super(new IInfantryMan());
	}
	
	public InfantryMan(String name){
		super(new IInfantryMan(name));
	}

	@Override
	public void accept(SoldierVisitor s) {
		s.visit(this);	
	}
	
	public abstract void addWeapon();
	
	
	

}
