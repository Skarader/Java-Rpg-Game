package Items.Consumables;

public class DefencePotion extends Consumable {
    private int duration;

    public DefencePotion(String name, int weight, int value, int potency, int duration) {
        super(name, weight, value, potency);
        this.duration = 5;

    }

    public int getDuration() {
        return duration;
    }

    public void addDefence(int potency) {
    }

}
