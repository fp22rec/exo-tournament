package tournament;

public class Swordsman extends Challenger implements ChallengerInterface {

	private final int damage = 5;
	
	public Swordsman() {
		this.hitPoints = 100;
	}
	
	@Override
	public Swordsman equip(String equipmentPiece) {
		equipment.add(equipmentPiece);
		return this;
	}
	
	@Override
	public void engage(Challenger challenged) {
		while (this.hitPoints > 0 && challenged.hitPoints > 0) {
			attack(challenged, damage);
		}
	}
	
}
