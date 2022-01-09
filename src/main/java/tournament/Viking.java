package tournament;

public class Viking extends Challenger implements ChallengerInterface {

	private final int damage = 6;
	
	public Viking() {
		this.hitPoints = 120;
	}
	
	@Override
	public Viking equip(String equipmentPiece) {
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
