package Items;

import Interfaces.Equippable;

public abstract class Armor extends Item implements Equippable {
    private int damageDefence;
    private int durability;

    public Armor(String name, int weight, int value, int damageDefence, int durability) {
        super(name, weight, value);
        this.damageDefence = damageDefence;
        this.durability = durability;

    }

    public int getDamageDefence() {
        return damageDefence;
    }

    public int getDurabillity() {
        return durability;
    }

    @Override
    public void equipItem() {

    }

    @Override
    public void unEquipItem() {
    }

    public void repair() {
    }

}
