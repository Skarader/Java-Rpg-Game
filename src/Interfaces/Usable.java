package Interfaces;

import Player.Player;

import Items.Item;

public interface Usable {

    void useItem(Player player, int potency, Item item);
}
