package Items.Weapons;

import Interfaces.MeleeWeapon;
import Items.Weapon;

public class BigSword extends Weapon implements MeleeWeapon {

    public BigSword(String name, int weight, int value, int damage) {
        super(name, weight, value, damage);
    }

    @Override
    public void meleeAttack() {
    }

    public void bigSwingAttack() {
    }
}
