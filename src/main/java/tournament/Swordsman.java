package tournament;

import tournament.util.Equipment;

public class Swordsman extends Challenger implements ChallengerInterface {

	private int damage;
	
	public Swordsman() {
		super();
		this.hitPoints = 100;
		this.equip("handSword");
	}
	
	public Swordsman(String type) {
		super();
		this.hitPoints = 100;
		this.equip("handSword");
		if (type.equals("Vicious")) {
			this.equip("poison");
		}
	}
	
	@Override
	public Swordsman equip(String equipmentPiece) {
		switch (equipmentPiece) {
		case "buckler":
			this.equipment.put(equipmentPiece, new Equipment(3, 1));
			break;
		case "handSword":
			this.damage = 5;
			this.equipment.put(equipmentPiece, new Equipment(1, 1));
			break;
		case "axe":
			this.damage = 6;
			this.equipment.put(equipmentPiece, new Equipment(1, 1));
			break;
		case "poison":
			this.equipment.put(equipmentPiece, new Equipment(1, 2));
			break;
		case "armor":
			this.damage--;
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
