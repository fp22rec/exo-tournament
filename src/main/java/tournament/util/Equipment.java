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

	public boolean tryUse(boolean recover) {
		if (activeStatus == 0) {
			if (recover) {
				activeStatus = activeAmount;
			}
			return false;
		} else {
			activeStatus--;
			return true;
		}
		
	}
	
	
	
}
