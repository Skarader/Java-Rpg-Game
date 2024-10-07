package Items.Armors;

import Interfaces.Equippable;
import Items.Item;

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

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setDamageDefence(int damageDefence) {
        this.damageDefence = damageDefence;
    }

    @Override
    public void equipItem() {

    }

    @Override
    public void unEquipItem() {
    }

    @Override
    public String getType() {
        return "Armor";
    }

    public void repair() {
    }

}
