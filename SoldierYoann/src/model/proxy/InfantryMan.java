package model.proxy;

import model.decorateur.IInfantryMan;
import model.visitor.SoldierVisitor;

public class InfantryMan extends SoldierAbstract {
	
	public InfantryMan(){
		super(new IInfantryMan());
	}

	@Override
	public void accept(SoldierVisitor s) {
		s.visit(this);	
	}
	
	
	

}
