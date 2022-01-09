package tournament;

import tournament.util.Equipment;

public class Highlander extends Challenger implements ChallengerInterface {

	private int damage;
	
	public Highlander() {
		super();
		this.hitPoints = 100;
		this.equip("greatSword");
	}

	@Override
	public void engage(Challenger challenged) {
		while (this.hitPoints > 0 && challenged.hitPoints > 0) {
			attack(challenged, damage);
		}
	}

	@Override
	public Challenger equip(String equipmentPiece) {
		switch (equipmentPiece) {
		case "buckler":
			this.equipment.put(equipmentPiece, new Equipment(3, 1));
			break;
		case "greatSword":
			this.damage = 12;
			this.equipment.put(equipmentPiece, new Equipment(1, 2));
			break;
		case "armor":
			this.damage--;
			this.equipment.put(equipmentPiece, new Equipment(1, 1));
			break;
		}
		
		return this;
	}

}
