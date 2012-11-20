package model.proxy;

import model.decorateur.IInfantryMan;
import model.visitor.SoldierVisitor;

public class InfantryMan extends SoldierAbstract {
	
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
	
	
	

}
