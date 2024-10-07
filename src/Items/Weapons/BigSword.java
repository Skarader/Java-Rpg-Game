package Items.Weapons;

import Interfaces.MeleeWeapon;

public class BigSword extends Weapon implements MeleeWeapon {

    public BigSword(String name, int weight, int value, int damage) {
        super(name, weight, value, damage);
    }

    @Override
    public void meleeAttack() {
        System.out.println("You swing the " + getName() + ".");
    }

    public void bigSwingAttack() {
        System.out.println("You swing the " + getName() + " with more force than usual dealing double damage");
    }
}
