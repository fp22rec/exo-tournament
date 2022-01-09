package tournament;

import tournament.util.Equipment;

public class Viking extends Challenger implements ChallengerInterface {

	private int damage;
	
	public Viking() {
		super();
		this.hitPoints = 120;
		this.equip("axe");

	}
	
	@Override
	public Viking equip(String equipmentPiece) {
		switch (equipmentPiece) {
		case "buckler":
			this.equipment.put(equipmentPiece, new Equipment(3, 1));
			break;
		case "axe":
			this.damage = 6;
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
