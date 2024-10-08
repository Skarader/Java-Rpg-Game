import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Items.Item;
import Items.Armors.Armor;
import Items.Weapons.Weapon;

import Items.Consumables.Consumable;
import Items.Consumables.DefencePotion;
import Items.Consumables.HealthPotion;
import Items.Consumables.StrengthPotion;

import Interfaces.Equippable;
import Interfaces.Usable;

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
        if (item instanceof HealthPotion) {
            HealthPotion healthPotion = (HealthPotion) item;
            int newHealth = Math.min(player.getHealth() + healthPotion.getPotency(), player.getMaxHealth());
            player.setHealth(newHealth);
            System.out.println(
                    "You have consumed " + item.getName() + " and restored " + healthPotion.getPotency() + " health!");
            System.out.println("Your current health is: " + player.getHealth());
        }
        if (item instanceof StrengthPotion) {
            StrengthPotion strengthPotion = (StrengthPotion) item;
            int newStrength = player.getStrength() + strengthPotion.getPotency();
            player.setStrength(newStrength);
            System.out.println("You have consumed " + item.getName()
                    + ". Your strength will be permenanlty be increased by " + strengthPotion.getPotency());
            System.out.println("Your current strength is: " + player.getStrength());
        }
        if (item instanceof DefencePotion) {
            DefencePotion defencePotion = (DefencePotion) item;
            int newDefence = player.getDefence() + defencePotion.getPotency();
            player.setDefence(newDefence);
            System.out.println("You have consumed " + item.getName()
                    + ". Your defence will be permenanlty be increased by " + defencePotion.getPotency());
            System.out.println("Your current defence is: " + player.getDefence());
        }
        items.remove(item);
    }

    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Your current health is: " + player.getHealth());
            System.out.println("Your current defence is: " + player.getDefence());
            System.out.println("Your current strength is: " + player.getStrength());
            System.out.println("Your current balance is: " + player.getBalance());
            System.out.println("***************************************************");
            System.out.println("Your inventory is empty!");
            System.out.println("");
            System.out.println("***************************************************");
        } else {
            System.out.println("Your current health is: " + player.getHealth());
            System.out.println("Your current defence is: " + player.getDefence());
            System.out.println("Your current strength is: " + player.getStrength());
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
        ((Equippable) item).unEquipItem();
        System.out.println("You have unequipped " + item.getName());
    }

    public void showEquippedItems() {
        if (equippedItems.isEmpty()) {
            System.out.println("You don't have any items equipped!");
        } else {
            System.out.println("This is the content of your equipped items: ");
            System.out.println("***************************************************");
            for (int i = 0; i < equippedItems.size(); i++) {
                System.out.println((i + 1) + ". " + equippedItems.get(i).getName());
            }
            System.out.println("");
            System.out.println("***************************************************");
        }
    }

    public void manageInventory() {
        Game.clearScreen();
        boolean isRunning = true;

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

        while (isRunning) {
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
                        isRunning = false;
                        addEquippedItem(selectedItem);
                    } else {
                        Game.clearScreen();
                        System.out.println("This item cannot be equipped!\n");
                    }
                    break;
                case 2:
                    if (selectedItem instanceof Usable) {
                        isRunning = false;
                        consumeItem(selectedItem);
                    } else {
                        Game.clearScreen();
                        System.out.println("This item cannot be consumed!\n");
                    }
                    break;
                case 3:
                    isRunning = false;
                    removeItem(selectedItem);
                    break;
                case 4:
                    isRunning = false;
                    Game.clearScreen();
                    System.out.println("No changes made!\n");
                    break;
                default:
                    Game.clearScreen();
                    System.out.println("Invalid choice! Try again!\n");
                    break;
            }
        }

    }

    public void manageEquippedInventory() {
        Game.clearScreen();
        boolean isRunning = true;

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

        while (isRunning) {

            System.out.println("What do you wanna do with " + selectedItem.getName() + "?");
            System.out.println("1. Unequip Item");
            System.out.println("2. Cancel");

            int choice2 = getIntInput();
            scanner.nextLine(); // consume extra chars

            switch (choice2) {
                case 1:
                    if (selectedItem instanceof Equippable) {
                        isRunning = false;
                        unEquipItem(selectedItem);
                    } else {
                        Game.clearScreen();
                        System.out.println("This item cannot be equipped!");
                    }
                    break;
                case 2:
                    isRunning = false;
                    Game.clearScreen();
                    System.out.println("No changes made!");
                    break;
                default:
                    Game.clearScreen();
                    System.out.println("Invalid choice! Try again!\n");
                    break;
            }
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

    public HealthPotion findHealthPotionInInventory() {
        for (Item item : items) {
            if (item instanceof HealthPotion) {
                return (HealthPotion) item;
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