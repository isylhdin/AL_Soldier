package model.proxy;

import model.decorateur.IHorseMan;
import model.visitor.SoldierVisitor;

public abstract class HorseMan extends SoldierAbstract {

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

	public abstract void addWeapon();

}
