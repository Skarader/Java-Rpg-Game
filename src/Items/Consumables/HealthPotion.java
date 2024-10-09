package Items.Consumables;

import Player.Player;
import Items.Item;

public class HealthPotion extends Consumable {

    public HealthPotion(String name, int weight, int value, int potency) {
        super(name, weight, value, potency);

    }

    public void useItem(Player player, int potency, Item item) {
        player.setHealth(Math.min(player.getHealth() + potency, player.getMaxHealth()));
        System.out.println("You consumed a " + item.getName() + " and restored " + potency + " health!");
        System.out.println("Your current health: " + player.getHealth());
    }
}
