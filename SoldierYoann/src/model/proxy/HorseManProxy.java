package model.proxy;

import model.decorateur.HorseMan;

public class HorseManProxy extends SoldierProxy {

	public HorseManProxy() {
		super(new HorseMan());

	}

}
