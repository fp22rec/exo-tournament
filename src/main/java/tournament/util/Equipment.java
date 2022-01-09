package tournament.util;

public class Equipment {

	private int hp;
	private int activeAmount;
	private int activeStatus;

	public Equipment(int hp, int activeAmount) {
		this.hp = hp;
		this.activeAmount = activeAmount;
		this.activeStatus = activeAmount;
	}

	public int getHp() {
		return hp;
	}

	public void decreaseHp(int amount) {
		this.hp -= amount;
	}

	public boolean tryUse() {
		if (activeStatus == 0) {
			activeStatus = activeAmount;
			return false;
		} else {
			activeStatus--;
			return true;
		}
		
	}
	
	
	
}
