package Items.Consumables;

import Items.Consumable;

public class StrengthPotion extends Consumable {
    private double duration;

    public StrengthPotion(String name, int weight, int value, int potency, double duration) {
        super(name, weight, value, potency);
        this.duration = 120;

    }

    public double getDuration() {
        return duration;
    }

    public void addStrength(int potency) {

    }

}
