package Items;

import Interfaces.Equippable;

public abstract class Weapon extends Item implements Equippable {
    private int damage;
    // private int attackSpeed;

    public Weapon(String name, int weight, int value, int damage) {
        super(name, weight, value);
        this.damage = damage;

    }

    public int getDamage() {
        return damage;
    }

    // public int attackSpeed() {
    // return attackSpeed;
    // }

    @Override
    public void equipItem() {
    }

    @Override
    public void unEquipItem() {
    }

}
