package model.proxy;

import model.decorateur.IInfantryMan;

public class InfantryMan extends SoldierAbstract {
	
	public InfantryMan(){
		super(new IInfantryMan());
	}
	
	
	

}
