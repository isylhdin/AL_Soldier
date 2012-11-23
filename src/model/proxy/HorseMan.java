package model.proxy;

import model.decorateur.IHorseMan;
import model.visitor.SoldierVisitor;

public class HorseMan extends SoldierAbstract {

	public HorseMan() {
		super(new IHorseMan());

	}
	
	public HorseMan(String name) {
		super(new IHorseMan(name));

	}

	@Override
	public void accept(SoldierVisitor s) {
		s.visit(this);
		
	}


}
