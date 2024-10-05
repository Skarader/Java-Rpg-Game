import java.util.ArrayList;
import java.util.Scanner;

import Interfaces.Equippable;
import Interfaces.Usable;
import Items.Item;

public class Inventory {
    private ArrayList<Item> items;
    private ArrayList<Item> equippedItems;
    Scanner scanner = new Scanner(System.in);

    public Inventory() {
        items = new ArrayList<>();
        equippedItems = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " has been added to your inventory");
    }

    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item.getName() + " has been removed from your inventory.");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public void consumeItem(Item item) {
        items.remove(item);

    }

    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty!");
        } else {
            System.out.println("This is the content of your inventory: ");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName());
            }
        }
    }

    public void addEquippedItem(Item item) {
        if (item instanceof Equippable) {
            equippedItems.add(item);
            ((Equippable) item).equipItem();
            // System.out.println(item.getName() + " has been equipped!");
        } else {
            System.out.println("This item cannot be equipped!");
        }
    }

    public void unEquipItem(Item item) {
        equippedItems.remove(item);
        items.add(item);
        System.out.println("You have unequipped the item");
    }

    public void showEquippedItems() {
        if (equippedItems.isEmpty()) {
            System.out.println("You don't have any items equipped!");
        } else {
            System.out.println("This is the content of your equipped items: ");
            for (int i = 0; i < equippedItems.size(); i++) {
                System.out.println((i + 1) + ". " + equippedItems.get(i).getName());
            }
        }
    }

    public void manageInventory() {
        Game.clearScreen();
        showInventory();
        if (items.isEmpty()) {
            return;
        }

        System.out.println("What item do you want to manage?");
        System.out.println("Select the item number of the item you want to manage.");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > items.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        Item selectedItem = items.get(choice - 1);

        System.out.println("What do you wanna do with " + selectedItem.getName() + "?");
        System.out.println("1. Equip Item");
        System.out.println("2. Consume item");
        System.out.println("3. Remove Item");
        System.out.println("4. Cancel");

        int choice2 = scanner.nextInt();

        switch (choice2) {
            case 1:
                if (selectedItem instanceof Equippable) {
                    addEquippedItem(selectedItem);
                    items.remove(selectedItem);
                    System.out.println("You have equipped " + selectedItem.getName() + "!");
                } else {
                    System.out.println("This item cannot be equipped!");
                }
                break;
            case 2:
                if (selectedItem instanceof Usable) {
                    consumeItem(selectedItem);
                    items.remove(selectedItem);
                    System.out.println("You have consumed " + selectedItem.getName());
                } else {
                    System.out.println("This item cannot be consumed!");
                }
                break;
            case 3:
                removeItem(selectedItem);
                System.out.println("You have removed " + selectedItem.getName() + " from your inventory!");
                break;
            case 4:
                System.out.println("No changes made!");
                break;
            default:
                System.out.println("Invalid choice! Try again!");
                break;
        }

    }

    public void manageEquippedInventory() {
        Game.clearScreen();
        showEquippedItems();

    }
}