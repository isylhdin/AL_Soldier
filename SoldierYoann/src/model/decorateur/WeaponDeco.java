package model.decorateur;

public class WeaponDeco implements ISoldier {

	private ISoldier s;
	
	public WeaponDeco(ISoldier s) {
		super();
		this.s = s;
	}

	@Override
	public int strikeForce() {
		return s.strikeForce();
	}

	@Override
	public void parry(int damage) {
		s.parry(damage);
	}

	@Override
	public int getHealthPoints() {
		return s.getHealthPoints();
	}
	
	public ISoldier getDeleg(){
		return s;
	}

}
