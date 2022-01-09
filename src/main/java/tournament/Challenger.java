package tournament;

import java.util.HashMap;
import java.util.Map;

import tournament.util.Equipment;

public abstract class Challenger implements ChallengerInterface {

	int hitPoints;
	Map<String, Equipment> equipment;
	
	public Challenger() {
		this.equipment = new HashMap<>();
	}

	@Override
	public int hitPoints() {
		return hitPoints;
	}
	
	@Override
	public void attack(Challenger challenged, int damage) {
		challenged.takeHit(equipment, damage);
		challenged.engage(this);
	}
	
	@Override
	public void takeHit(Map<String, Equipment> equipmentAttacker, int damageAttacker) {

		boolean blocked = false;
		
		if (this.equipment.containsKey("armor")) {
			damageAttacker -= 3;
		}
		
		if (this.equipment.containsKey("buckler")) {
			Equipment buckler = this.equipment.get("buckler");
			
			// block damage one out of two
			blocked = buckler.tryUse(true);
			damageAttacker = blocked ? 0 : damageAttacker;
			
			if (blocked && equipmentAttacker.containsKey("axe")) {
				buckler.decreaseHp(1);
				if (buckler.getHp() == 0) {
					this.equipment.remove("buckler");
				}
			}
			
		}
		
		if (!blocked && equipmentAttacker.containsKey("poison")) {
			Equipment poison = equipmentAttacker.get("poison");
			boolean hasPoison = poison.tryUse(false);
			if (hasPoison) {
				damageAttacker += 20;
			}
		}
		
		if (!blocked && equipmentAttacker.containsKey("greatSword")) {
			Equipment greatSword = equipmentAttacker.get("greatSword");
			boolean canAttack = greatSword.tryUse(true);
			damageAttacker = canAttack ? damageAttacker : 0;
		}
		
		
		this.hitPoints = Math.max(0, this.hitPoints - damageAttacker);
	}
	
}
