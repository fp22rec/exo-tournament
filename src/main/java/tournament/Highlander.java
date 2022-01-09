package tournament;

import tournament.util.Equipment;

public class Highlander extends Challenger implements ChallengerInterface {

	private final int initialHitPoints = 150;
	private int damage;
	private boolean isVeteran; 
	private boolean isBerserk;
	
	public Highlander() {
		super();
		this.hitPoints = initialHitPoints;
		this.equip("greatSword");
	}
	
	public Highlander(String type) {
		super();
		this.hitPoints = initialHitPoints;
		this.equip("greatSword");
		if (type.equals("Veteran")) {
			this.isVeteran = true;
		}
	}

	@Override
	public void engage(Challenger challenged) {
		while (this.hitPoints > 0 && challenged.hitPoints > 0) {
			if (isVeteran && !isBerserk && hitPoints < initialHitPoints * 0.3) {
				isBerserk = true;
				damage *= 2;
			}
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
