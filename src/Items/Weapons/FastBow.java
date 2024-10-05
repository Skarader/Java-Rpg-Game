package Items.Weapons;

import Interfaces.RangedWeapon;
import Items.Weapon;

public class FastBow extends Weapon implements RangedWeapon {
    // private int ammunition;
    // private double range;

    public FastBow(String name, int weight, int value, int damage) {
        super(name, weight, value, damage);
    }

    @Override
    public void rangedAttack() {
    }

    public void fastShotAttack() {
    }

}
