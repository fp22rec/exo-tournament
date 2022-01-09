package tournament;

import java.util.Map;

import tournament.util.Equipment;

public interface ChallengerInterface {

	void engage(Challenger challenged);
	
	int hitPoints();
	
	Challenger equip(String equipmentPiece);
	
	void attack(Challenger challenged, int damage);

	void takeHit(Map<String, Equipment> equipmentAttacker, int damageAttacker);
}
