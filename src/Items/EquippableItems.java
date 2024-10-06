package Items;

import Interfaces.Equippable;

public class EquippableItems extends Item implements Equippable {

    public EquippableItems(String name, int weight, int value) {
        super(name, weight, value);

    }

    @Override
    public void equipItem() {
        System.out.println("Item has been equipped");
    }

    @Override
    public void unEquipItem() {
        System.out.println("Item has be unequipped");

    }

    @Override
    public String getType() {
        return "";
    }

}
