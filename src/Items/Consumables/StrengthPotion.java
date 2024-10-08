package Items.Consumables;

public class StrengthPotion extends Consumable {
    private int duration;

    public StrengthPotion(String name, int weight, int value, int potency, int duration) {
        super(name, weight, value, potency);
        this.duration = 5;

    }

    public int getDuration() {
        return duration;
    }

    public void addStrength(int potency) {

    }

}
