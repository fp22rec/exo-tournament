package tournament;

public interface ChallengerInterface {

	void engage(Challenger challenged);
	
	int hitPoints();
	
	Challenger equip(String equipmentPiece);
	
	void attack(Challenger challenged, int damage);

	void takeHit(int damage);
}
