package Items.Weapons;

import Interfaces.MeleeWeapon;
import Interfaces.RangedWeapon;

public class ThrowingKnife extends Weapon implements MeleeWeapon, RangedWeapon {

    public ThrowingKnife(String name, int weight, int value, int damage) {
        super(name, weight, value, damage);
    }

    @Override
    public void meleeAttack() {
    }

    @Override
    public void rangedAttack() {
    }

    public void slashAttack() {
    }

}
