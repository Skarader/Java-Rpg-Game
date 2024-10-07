package Items.Weapons;

import Interfaces.Equippable;
import Items.Item;

public abstract class Weapon extends Item implements Equippable {
    private int damage;

    public Weapon(String name, int weight, int value, int damage) {
        super(name, weight, value);
        this.damage = damage;

    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void equipItem() {
    }

    @Override
    public void unEquipItem() {
    }

    @Override
    public String getType() {
        return "Weapon";
    }

}
