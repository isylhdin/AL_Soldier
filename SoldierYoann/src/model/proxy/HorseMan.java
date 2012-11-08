package model.proxy;

import model.decorateur.IHorseMan;

public class HorseMan extends SoldierAbstract {

	public HorseMan() {
		super(new IHorseMan());

	}

}
