package Items.Consumables;

import Interfaces.Usable;
import Items.Item;

public abstract class Consumable extends Item implements Usable {
    private int potency;

    public Consumable(String name, int weight, int value, int potency) {
        super(name, weight, value);
        this.potency = potency;

    }

    public int getPotency() {
        return potency;
    }

    // @Override
    // public void useItem() {
    // }

}
