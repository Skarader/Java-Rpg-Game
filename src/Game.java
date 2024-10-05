import java.util.Scanner;

import Items.Consumable;
import Items.Weapon;
import Items.Armor;
import Items.Armors.BrassArmor;
import Items.Armors.LeatherArmor;
import Items.Armors.SteelArmor;
import Items.Consumables.DefencePotion;
import Items.Consumables.HealthPotion;
import Items.Consumables.StrengthPotion;
import Items.Weapons.BigSword;
import Items.Weapons.FastBow;
import Items.Weapons.ThrowingKnife;

public class Game {
    Scanner scanner = new Scanner(System.in);
    boolean isRunning = true;
    Player player = new Player("null", 0, 100, 2, 50, 0);

    public void startGame() {
        clearScreen();
        System.out.println("Welcome to dragon hunter!");
        System.out.println("1. Start Game");
        System.out.println("0. Exit Game");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume extra chars...

        while (isRunning) {
            if (choice == 1) {
                runGame();
                isRunning = false;
            } else {
                System.out.println("Good Bye");
                isRunning = false;
            }
        }
    }

    public void runGame() {
        clearScreen();
        System.out.println(
                "Hello and welcome to dragon hunter!\nIn this game you will be attempting to save the village from the old dragon lurking in the mountain.");
        System.out.println("First, please write your name?: ");
        String name = scanner.nextLine();
        System.out.println("How old are you?: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        player.setName(name);
        player.setAge(age);
        clearScreen();
        System.out.println("Okay " + player.getName() + "! Let's start the game...");
        pressEnter();
        intro();
    }

    public void intro() {
        clearScreen();
        System.out.println("Hello " + player.getName());
        System.out.println("My name is Frank and you are currently standing in the middle of our village.");
        System.out.println("As you have heard, there is an old mighty dragon hidden somewhere in the mountain.");
        System.out.println(
                "For many years the old stories about the dragon was just scary tales the adults told the children to keep them from going to far away from the village.");
        pressEnter();
        System.out.println(
                "But last month, we were awaken by a huge roar comming from the mountain, and since then we've had strange attacks from forest animals.");
        System.out.println(
                "Squirrel attcking us while we are picking berries, rats jumping up from holes in the ground biting our feet... I could tell stories like these for days!");
        System.out.println(
                "The last guy that came to us trying to help b-lined straight to the mountain and was never seen again.");
        System.out.println(
                "This time we have prepered for a brave knight like yourself to come and save us once and for all from the old dragon.");
        pressEnter();
        System.out.println("Look around and explore our village, you will find stuff that will help you progress!");
        System.out.println("Here is 5 coins to start with! Use it well");
        player.setBalance(player.getBalance() + 500);
        System.out.println("Good luck " + player.getName() + "! You'll need it!");
        pressEnter();
        townCenter();
    }

    public void townCenter() {
        clearScreen();
        System.out.println("You are standing in the middle of town! Where do you wanna go?");

        System.out.println("1. Go to potions shop");
        System.out.println("2. Go to armor shop");
        System.out.println("3. Go to weapon shop");
        System.out.println("4. Go fight monsters");
        System.err.println("5. Check inventory");
        System.out.println("6. Check equipped items");
        System.out.println("7. Manage inventory");
        System.out.println("8. Manage equipped items");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume extra chars

        switch (choice) {
            case 1:
                potionShop();
                break;
            case 2:
                armorShop();
                break;
            case 3:
                weaponShop();
                break;
            case 4:
                // goFight();
                break;
            case 5:
                checkInventory();
                break;
            case 6:
                checkEquippedInventory();
                break;
            case 7:
                manageInventory();
                break;
            case 8:
                manageEquippedItems();
                break;
            default:
                clearScreen();
                System.err.println("Invalid choice! Try again");
                break;
        }

    }

    public void potionShop() {
        clearScreen();
        System.out.println("Welcome to our potion shop!");
        System.err.println("Enter the number of the item you would like to buy");
        HealthPotion healthPotion = new HealthPotion("Health Potion", 1, 10, 50);
        DefencePotion defencePotion = new DefencePotion("Defence Potion", 1, 25, 5, 120);
        StrengthPotion strengthPotion = new StrengthPotion("Strength Potion", 1, 40, 5, 120);

        System.out.println("1. " + healthPotion.getName() + ". Price: " + healthPotion.getValue() + ", + "
                + healthPotion.getPotency() + "Hp");
        System.out.println("2. " + defencePotion.getName() + ". Price: " + defencePotion.getValue() + ", + "
                + defencePotion.getPotency() + " Defence");
        System.out.println("3. " + strengthPotion.getName() + ". Price: " + strengthPotion.getValue() + ", + "
                + strengthPotion.getPotency() + " Strength");
        System.out.println("0. Leave the store");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume extra chars

        Consumable itemChoice = null;

        switch (choice) {
            case 1:
                itemChoice = healthPotion;
                break;
            case 2:
                itemChoice = defencePotion;
                break;
            case 3:
                itemChoice = strengthPotion;
                break;
            case 0:
                System.out.println("Leaving store...");
                pressEnter();
                townCenter();
            default:
                System.out.println("Invalid choice! Try again!");
                break;
        }

        if (player.getBalance() >= itemChoice.getValue()) {
            player.setBalance(player.getBalance() - itemChoice.getValue());
            System.out.println("You have bought a " + itemChoice.getName() + "!");
            player.addItem(itemChoice);
            pressEnter();
            townCenter();
        } else {
            System.out
                    .println("Your balance is to low! Your balance: " + player.getBalance() + " | "
                            + itemChoice.getName()
                            + " costs: " + itemChoice.getValue());
            pressEnter();
            townCenter();
        }
    }

    public void armorShop() {
        clearScreen();
        System.out.println("Welcome to the armor shop!");
        System.err.println("Enter the number of the item you would like to buy");

        LeatherArmor leatherArmor = new LeatherArmor("Leather Armor", 20, 20, 5, 10);
        BrassArmor brassArmor = new BrassArmor("Brass Armor", 35, 35, 10, 10);
        SteelArmor steelArmor = new SteelArmor("Steel Armor", 50, 50, 25, 20);

        System.out.println("1. " + leatherArmor.getName() + ". Price: " + leatherArmor.getValue() + ", + "
                + leatherArmor.getDamageDefence() + " Defence");
        System.out.println("2. " + brassArmor.getName() + ". Price: " + brassArmor.getValue() + ", + "
                + brassArmor.getDamageDefence() + " Defence");
        System.out.println("3. " + steelArmor.getName() + ". Price: " + steelArmor.getValue() + ", + "
                + steelArmor.getDamageDefence() + " Defence");
        System.out.println("0. Leave the store");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume extra chars

        Armor itemChoice = null;

        switch (choice) {
            case 1:
                itemChoice = leatherArmor;
                break;
            case 2:
                itemChoice = brassArmor;
                break;
            case 3:
                itemChoice = steelArmor;
                break;
            case 0:
                System.out.println("Leaving the store...");
                pressEnter();
                townCenter();
            default:
                System.out.println("Invalid choice! Try again!");
                break;
        }

        if (player.getBalance() >= itemChoice.getValue()) {
            player.setBalance(player.getBalance() - itemChoice.getValue());
            System.out.println("You have bought a " + itemChoice.getName() + "!");
            player.addItem(itemChoice);
            pressEnter();
            townCenter();
        } else {
            System.out
                    .println("Your balance is to low! Your balance: " + player.getBalance() + " | "
                            + itemChoice.getName()
                            + " costs: " + itemChoice.getValue());
            pressEnter();
            townCenter();
        }
    }

    public void weaponShop() {
        clearScreen();
        System.out.println("Welcome to the weapon shop!");
        System.err.println("Enter the number of the item you would like to buy");

        ThrowingKnife throwingKnife = new ThrowingKnife("Throwing Knife", 10, 10, 5);
        BigSword bigSword = new BigSword("Big Sword", 40, 40, 7);
        FastBow fastBow = new FastBow("Fast Bow", 25, 25, 7);

        System.out.println("1. " + throwingKnife.getName() + ". Price: " + throwingKnife.getValue() + ", + "
                + throwingKnife.getDamage() + " Damage");
        System.out.println("2. " + bigSword.getName() + ". Price: " + bigSword.getValue() + ", + "
                + bigSword.getDamage() + " Damage");
        System.out.println("3. " + fastBow.getName() + ". Price: " + fastBow.getValue() + ", + "
                + fastBow.getDamage() + " Damage");
        System.out.println("0. Leave the store");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume extra chars

        Weapon itemChoice = null;

        switch (choice) {
            case 1:
                itemChoice = throwingKnife;
                break;
            case 2:
                itemChoice = bigSword;
                break;
            case 3:
                itemChoice = fastBow;
                break;
            case 0:
                System.out.println("Leaving the store...");
                pressEnter();
                townCenter();
            default:
                System.out.println("Invalid choice! Try again!");
                break;
        }

        if (player.getBalance() >= itemChoice.getValue()) {
            player.setBalance(player.getBalance() - itemChoice.getValue());
            player.addItem(itemChoice);
            pressEnter();
            townCenter();
        } else {
            System.out
                    .println("Your balance is to low! Your balance: " + player.getBalance() + " | "
                            + itemChoice.getName()
                            + " costs: " + itemChoice.getValue());
            pressEnter();
            townCenter();
        }

    }

    public void goFight() {
    }

    public void checkInventory() {
        player.showInventory();
        pressEnter();
        townCenter();
    }

    public void checkEquippedInventory() {
        player.showEquippedInventory();
        pressEnter();
        townCenter();
    }

    public void manageInventory() {
        player.manageInventory();
        pressEnter();
        townCenter();
    }

    public void manageEquippedItems() {
        player.manageEquippedInventory();
        pressEnter();
        townCenter();
    }

    public void pressEnter() {
        System.out.println("Press enter to continue...");
        scanner.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
