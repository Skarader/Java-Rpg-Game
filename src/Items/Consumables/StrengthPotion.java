package Items.Consumables;

import Player.Player;
import Items.Item;

public class StrengthPotion extends Consumable {

    public StrengthPotion(String name, int weight, int value, int potency) {
        super(name, weight, value, potency);

    }

    public void useItem(Player player, int potency, Item item) {
        player.setStrength(player.getStrength() + potency);
        System.out.println("You consumed a " + item.getName() + " and gained " + potency + " permanent strength");
        System.out.println("Your current strength: " + player.getStrength());
    }

}
