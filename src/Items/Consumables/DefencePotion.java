package Items.Consumables;

import Interfaces.Usable;
import Items.Consumable;

public class DefencePotion extends Consumable implements Usable {
    private double duration;

    public DefencePotion(String name, int weight, int value, int potency, double duration) {
        super(name, weight, value, potency);
        this.duration = duration;

    }

    public double getDuration() {
        return duration;
    }

    public void addDefence(int potency) {
    }

}
