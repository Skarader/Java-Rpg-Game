package Items.Consumables;

import Player.Player;
import Items.Item;

public class DefencePotion extends Consumable {

    public DefencePotion(String name, int weight, int value, int potency) {
        super(name, weight, value, potency);

    }

    @Override
    public void useItem(Player player, int potency, Item item) {
        player.setDefence(player.getDefence() + potency);
        System.out.println("You consumed a " + item.getName() + " and gained " + potency + " permanent defence!");
        System.out.println("Your current defence: " + player.getDefence());
    }

}
