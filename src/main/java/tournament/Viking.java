package tournament;

import tournament.util.Equipment;

public class Viking extends Challenger implements ChallengerInterface {

	private final int damage = 6;
	
	public Viking() {
		super();
		this.hitPoints = 120;
		this.equip("handAxe");

	}
	
	@Override
	public Viking equip(String equipmentPiece) {
		switch (equipmentPiece) {
		case "buckler":
			this.equipment.put(equipmentPiece, new Equipment(3, 1));
			break;
		case "handAxe":
			this.equipment.put(equipmentPiece, new Equipment(1, 1));
			break;
		}
	
		return this;
	}

	@Override
	public void engage(Challenger challenged) {
		while (this.hitPoints > 0 && challenged.hitPoints > 0) {
			attack(challenged, damage);
		}
	}
	
}
