package tournament;

import java.util.List;

public abstract class Challenger implements ChallengerInterface {

	int hitPoints;
	List<String> equipment;
	
	@Override
	public int hitPoints() {
		return hitPoints;
	}
	
	@Override
	public void attack(Challenger challenged, int damage) {
		challenged.takeHit(damage);
		if (challenged.hitPoints > 0) {
			challenged.engage(this);
		}
	}
	
	@Override
	public void takeHit(int damage) {
		this.hitPoints = Math.max(0, this.hitPoints - damage);
	}
	
}
