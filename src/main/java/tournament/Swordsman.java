package tournament;

import tournament.util.Equipment;

public class Swordsman extends Challenger implements ChallengerInterface {

	private final int damage = 5;
	
	public Swordsman() {
		super();
		this.hitPoints = 100;
		this.equip("handSword");
	}
	
	@Override
	public Swordsman equip(String equipmentPiece) {
		switch (equipmentPiece) {
		case "buckler":
			this.equipment.put(equipmentPiece, new Equipment(3, 1));
			break;
		case "handSword":
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
