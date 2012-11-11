package model.proxy;

import model.decorateur.IHorseMan;
import model.visitor.SoldierVisitor;

public class HorseMan extends SoldierAbstract {

	public HorseMan() {
		super(new IHorseMan());

	}

	@Override
	public void accept(SoldierVisitor s) {
		s.visit(this);
		
	}


}
