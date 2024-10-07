import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Interfaces.Equippable;
import Interfaces.Usable;
import Items.Item;
import Items.Armors.Armor;
import Items.Weapons.Weapon;

public class Inventory {
    private ArrayList<Item> items;
    private ArrayList<Item> equippedItems;
    private Player player;
    Scanner scanner = new Scanner(System.in);

    public Inventory(Player player) {
        items = new ArrayList<>();
        equippedItems = new ArrayList<>();
        this.player = player;
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
            System.out.println("Your current balance is: " + player.getBalance());
            System.out.println("Your inventory is empty!");
        } else {
            System.out.println("Your current balance is: " + player.getBalance());
            System.out.println("This is the content of your inventory: ");
            System.out.println("***************************************************");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName());
            }
            System.out.println("");
            System.out.println("***************************************************");
        }
    }

    public void addEquippedItem(Item item) {
        if (item instanceof Equippable) {
            String itemType = ((Equippable) item).getType();

            for (Item equippedItem : equippedItems) {
                if (equippedItem instanceof Equippable && ((Equippable) equippedItem).getType().equals(itemType)) {
                    System.out.println("You already have an equipped " + itemType + ": " + equippedItem.getName());
                    System.out.println("Do you want to replace it? (yes/no)");

                    String choice = scanner.nextLine().trim().toLowerCase();

                    if (choice.equals("yes")) {
                        unEquipItem(equippedItem);
                        break;
                    } else {
                        System.out.println("No changes made.");
                        return;
                    }
                }
            }

            // Equip the new item
            equippedItems.add(item);
            items.remove(item);
            ((Equippable) item).equipItem();
            System.out.println(item.getName() + " has been equipped!");

        } else {
            System.out.println("This item cannot be equipped!");
        }
    }

    public void unEquipItem(Item item) {
        equippedItems.remove(item);
        items.add(item);
        System.out.println("You have unequipped " + item.getName());
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
        int choice = getIntInput();
        scanner.nextLine(); // consume extra chars

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

        int choice2 = getIntInput();
        scanner.nextLine(); // consume extra chars

        switch (choice2) {
            case 1:
                if (selectedItem instanceof Equippable) {
                    addEquippedItem(selectedItem);
                    // items.remove(selectedItem);
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

        if (equippedItems.isEmpty()) {
            return;
        }

        System.out.println("What item do you want to manage?");
        System.out.println("Select the item number of the item you want to manage.");
        int choice = getIntInput();
        scanner.nextLine(); // consume extra chars

        if (choice < 1 || choice > equippedItems.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        Item selectedItem = equippedItems.get(choice - 1);

        System.out.println("What do you wanna do with " + selectedItem.getName() + "?");
        System.out.println("1. Unequip Item");
        System.out.println("2. Cancel");

        int choice2 = getIntInput();
        scanner.nextLine(); // consume extra chars

        switch (choice2) {
            case 1:
                if (selectedItem instanceof Equippable) {
                    unEquipItem(selectedItem);
                } else {
                    System.out.println("This item cannot be equipped!");
                }
                break;
            case 2:
                System.out.println("No changes made!");
                break;
            default:
                System.out.println("Invalid choice! Try again!");
                break;
        }

    }

    public Weapon getEquippedWeapon() {
        for (Item item : equippedItems) {
            if (item instanceof Weapon) {
                return (Weapon) item;
            }
        }
        return null;
    }

    public Armor getEquippedArmor() {
        for (Item item : equippedItems) {
            if (item instanceof Armor) {
                return (Armor) item;
            }
        }
        return null;
    }

    public int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // consume extra chars
            }
        }
    }
}