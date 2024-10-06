package Items.Consumables;

import Interfaces.Usable;
import Items.Item;

public abstract class Consumable extends Item implements Usable {
    private int potency;
    // private double duration;

    public Consumable(String name, int weight, int value, int potency) {
        super(name, weight, value);
        this.potency = potency;
        // this.duration = duration;

    }

    public int getPotency() {
        return potency;
    }

    // public double getDuration() {
    // return duration;
    // }

    @Override
    public void useItem() {
    }

}
