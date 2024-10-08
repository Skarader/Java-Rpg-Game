package Items.Weapons;

import Interfaces.RangedWeapon;

public class ThrowingKnife extends Weapon implements RangedWeapon {

    public ThrowingKnife(String name, int weight, int value, int damage) {
        super(name, weight, value, damage);
    }

    @Override
    public void rangedAttack() {
        System.out.println("You throw a knife with the " + getName());
    }

    public void fastShotAttack() {
        System.out.println();
    }

}
