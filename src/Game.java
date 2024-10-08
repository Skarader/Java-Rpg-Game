import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

import Enemies.Enemy;
import Enemies.Rat;
import Enemies.Snake;
import Enemies.Fox;
import Enemies.Dragon;

import Items.Armors.Armor;
import Items.Armors.BrassArmor;
import Items.Armors.LeatherArmor;
import Items.Armors.SteelArmor;

import Items.Consumables.Consumable;
import Items.Consumables.DefencePotion;
import Items.Consumables.HealthPotion;
import Items.Consumables.StrengthPotion;

import Items.Weapons.Weapon;
import Items.Weapons.BigSword;
import Items.Weapons.FastBow;
import Items.Weapons.ThrowingKnife;

import Interfaces.MeleeWeapon;
import Interfaces.RangedWeapon;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player("null", 0, 100, 0, 2, 50, 0);

    public void startGame() {
        boolean isRunning = true;
        clearScreen();

        while (isRunning) {

            System.out.println("Welcome to dragon hunter!");
            System.out.println("1. Start Game");
            System.out.println("0. Exit Game");
            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            if (choice == 1) {
                isRunning = false;
                runGame();
            } else if (choice == 0) {
                System.out.println("Good Bye");
                isRunning = false;
            } else {
                clearScreen();
                System.out.println("Invalid choice! Try again!\n");
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
        int age = getIntInput();
        scanner.nextLine(); // consume extra chars
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
        boolean isRunning = true;
        clearScreen();

        while (isRunning) {

            System.out.println("You are standing in the middle of town! Where do you wanna go?");
            System.out.println("1. Go to potions shop");
            System.out.println("2. Go to armor shop");
            System.out.println("3. Go to weapon shop");
            System.out.println("4. Go fight monsters");
            System.out.println("5. Manage inventory");
            System.out.println("6. Manage equipped items");
            System.out.println("7. Quit game");

            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            switch (choice) {
                case 1:
                    isRunning = false;
                    potionShop();
                    break;
                case 2:
                    isRunning = false;
                    armorShop();
                    break;
                case 3:
                    isRunning = false;
                    weaponShop();
                    break;
                case 4:
                    isRunning = false;
                    goFight();
                    break;
                case 5:
                    isRunning = false;
                    manageInventory();
                    break;
                case 6:
                    isRunning = false;
                    manageEquippedItems();
                    break;
                case 7:
                    gameOver();
                default:
                    clearScreen();
                    System.out.println("Invalid choice! Try again!\n");
                    break;
            }

        }

    }

    public void potionShop() {
        clearScreen();
        boolean isRunning = true;

        HealthPotion healthPotion = new HealthPotion("Health Potion", 1, 20, 50);
        DefencePotion defencePotion = new DefencePotion("Defence Potion", 1, 80, 1);
        StrengthPotion strengthPotion = new StrengthPotion("Strength Potion", 1, 120, 1);

        Consumable itemChoice = null;

        while (isRunning) {

            System.out.println("Welcome to our potion shop!");
            System.out.println("Your current balance is: " + player.getBalance());
            System.out.println("\nEnter the number of the item you would like to buy");

            System.out.println("1. " + healthPotion.getName() + ". Price: " + healthPotion.getValue() + ", + "
                    + healthPotion.getPotency() + " Hp");
            System.out
                    .println("2. " + defencePotion.getName() + ". Price: " + defencePotion.getValue() + ", Permanent + "
                            + defencePotion.getPotency() + " Defence");
            System.out.println(
                    "3. " + strengthPotion.getName() + ". Price: " + strengthPotion.getValue() + ", Permanent + "
                            + strengthPotion.getPotency() + " Strength");
            System.out.println("0. Leave the store");

            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            switch (choice) {
                case 1:
                    isRunning = false;
                    itemChoice = healthPotion;
                    break;
                case 2:
                    isRunning = false;
                    itemChoice = defencePotion;
                    break;
                case 3:
                    isRunning = false;
                    itemChoice = strengthPotion;
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Leaving store...");
                    pressEnter();
                    townCenter();
                default:
                    clearScreen();
                    System.out.println("Invalid choice! Try again!\n");
                    break;
            }

            if (itemChoice != null) {
                if (player.getBalance() >= itemChoice.getValue()) {
                    player.setBalance(player.getBalance() - itemChoice.getValue());
                    System.out.println("You have bought a " + itemChoice.getName() + "!");
                    System.out.println("Your new balance is: " + player.getBalance());
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

        }
    }

    public void armorShop() {
        clearScreen();
        boolean isRunning = true;

        LeatherArmor leatherArmor = new LeatherArmor("Leather Armor", 20, 20, 5, 1);
        BrassArmor brassArmor = new BrassArmor("Brass Armor", 35, 35, 10, 10);
        SteelArmor steelArmor = new SteelArmor("Steel Armor", 50, 50, 25, 20);

        Armor itemChoice = null;

        while (isRunning) {
            System.out.println("Welcome to the armor shop!");
            System.out.println("Your current balance is: " + player.getBalance());
            System.out.println("\nEnter the number of the item you would like to buy");

            System.out.println("1. " + leatherArmor.getName() + ". Price: " + leatherArmor.getValue() + ", + "
                    + leatherArmor.getDamageDefence() + " Defence");
            System.out.println("2. " + brassArmor.getName() + ". Price: " + brassArmor.getValue() + ", + "
                    + brassArmor.getDamageDefence() + " Defence");
            System.out.println("3. " + steelArmor.getName() + ". Price: " + steelArmor.getValue() + ", + "
                    + steelArmor.getDamageDefence() + " Defence");
            System.out.println("0. Leave the store");

            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            switch (choice) {
                case 1:
                    isRunning = false;
                    itemChoice = leatherArmor;
                    break;
                case 2:
                    isRunning = false;
                    itemChoice = brassArmor;
                    break;
                case 3:
                    isRunning = false;
                    itemChoice = steelArmor;
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Leaving the store...");
                    pressEnter();
                    townCenter();
                default:
                    clearScreen();
                    System.out.println("Invalid choice! Try again!\n");
                    break;
            }

            if (itemChoice != null) {
                if (player.getBalance() >= itemChoice.getValue()) {
                    player.setBalance(player.getBalance() - itemChoice.getValue());
                    System.out.println("You have bought a " + itemChoice.getName() + "!");
                    System.out.println("Your new balance is: " + player.getBalance());
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

        }
    }

    public void weaponShop() {
        clearScreen();
        boolean isRunning = true;

        ThrowingKnife throwingKnife = new ThrowingKnife("Throwing Knife", 10, 10, 5);
        FastBow fastBow = new FastBow("Fast Bow", 25, 25, 7);
        BigSword bigSword = new BigSword("Big Sword", 40, 40, 9);

        Weapon itemChoice = null;

        while (isRunning) {

            System.out.println("Welcome to the weapon shop!");
            System.out.println("Your current balance is: " + player.getBalance());
            System.out.println("\nEnter the number of the item you would like to buy");

            System.out.println("1. " + throwingKnife.getName() + ". Price: " + throwingKnife.getValue() + ", + "
                    + throwingKnife.getDamage() + " Damage");
            System.out.println("2. " + fastBow.getName() + ". Price: " + fastBow.getValue() + ", + "
                    + fastBow.getDamage() + " Damage");
            System.out.println("3. " + bigSword.getName() + ". Price: " + bigSword.getValue() + ", + "
                    + bigSword.getDamage() + " Damage");
            System.out.println("0. Leave the store");

            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            switch (choice) {
                case 1:
                    isRunning = false;
                    itemChoice = throwingKnife;
                    break;
                case 2:
                    isRunning = false;
                    itemChoice = fastBow;
                    break;
                case 3:
                    isRunning = false;
                    itemChoice = bigSword;
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Leaving the store...");
                    pressEnter();
                    townCenter();
                default:
                    clearScreen();
                    System.out.println("Invalid choice! Try again!\n");
                    break;
            }

            if (itemChoice != null) {
                if (player.getBalance() >= itemChoice.getValue()) {
                    player.setBalance(player.getBalance() - itemChoice.getValue());
                    System.out.println("You have bought a " + itemChoice.getName() + "!");
                    System.out.println("Your new balance is: " + player.getBalance());
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

        }
    }

    public void goFight() {
        clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            System.out.println("What do you wanna do?");
            System.out.println("1. Find creatures causing havoc around the village");
            System.out.println("2. Go to the mountain to fight the dragon");
            System.out.println("3. Go back");
            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            switch (choice) {
                case 1:
                    isRunning = false;
                    fightVillage();
                    break;
                case 2:
                    isRunning = false;
                    fightDragon();
                    break;
                case 3:
                    isRunning = false;
                    townCenter();
                    break;
                default:
                    clearScreen();
                    System.out.println("Invalid input! Try again!\n");
                    break;
            }

        }
    }

    public void fightVillage() {
        clearScreen();
        boolean isRunning = true;

        Rat rat = new Rat("Possessed Rat", 15, 2);
        Snake snake = new Snake("Possessed Snake", 20, 4);
        Fox fox = new Fox("Possessed Fox", 30, 5);

        Enemy currentEnemy = null;

        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;

        switch (randomNumber) {
            case 1:
                currentEnemy = rat;
                break;
            case 2:
                currentEnemy = snake;
                break;
            case 3:
                currentEnemy = fox;
                break;
            default:
                break;
        }

        while (isRunning) {
            // try {
            System.out.println("Searching around the village you come across a " + currentEnemy.getName() + ".");
            System.out.println("What do you wanna do?");
            System.out.println("1. Fight!");
            System.out.println("2. Run away!");

            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            switch (choice) {
                case 1:
                    isRunning = false;
                    battle(currentEnemy);
                    break;
                case 2:
                    isRunning = false;
                    clearScreen();
                    System.out.println("You cowardly ran away from the " + currentEnemy.getName() + ".");
                    pressEnter();
                    townCenter();
                    break;
                default:
                    clearScreen();
                    System.out.println("Invalid choice! Try again!\n");
                    break;
            }

        }

    }

    public void fightDragon() {
        clearScreen();

        Rat rat = new Rat("Demonic Possessed Rat", 25, 4);
        Snake snake = new Snake("Demonic Possessed Snake", 30, 6);
        Fox fox = new Fox("Demonic Possessed Fox", 40, 10);
        Dragon dragon = new Dragon("Dragon", 500, 18);

        System.out.println("Hey there " + player.getName() + " Its me again, Frank!");
        System.out.println("I can se that you are leaving to fight the dragon.");
        System.out.println("I just want to remind you to equip yourself with the best gear you can find!");
        System.out.println("Once you leave here and enter the mountain, there is no turning back.");
        System.out.println("So what will it be? Are you ready? (yes/no)");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.println("Good luck " + player.getName() + " I hope I get to see you again");
        } else {
            System.out.println("Go back to town and make yourself ready then!");
            pressEnter();
            townCenter();
        }

        clearScreen();
        System.out.println(
                "While walking towards the mountain you wonder of you've done enough to prepere yourself for whats waiting...");
        System.out.println(
                "closeing in you see a large crack in the base of the mountain, you can see faints of smoke slowly simmer out from the crack...");
        System.out.println(
                "You take your first steps into the mountain and feel the heat go up for every step you take...");
        pressEnter();

        player.setHealth(player.getHealth() - 5);
        System.out.println("Out of nowhere a " + rat.getName() + " jumps on you dealing 5 damage! Current health: "
                + player.getHealth());

        pressEnter();
        battleDragon(rat);
        clearScreen();

        System.out
                .println("Phew... After defeating the " + rat.getName() + " you shake yourself up and keep walking...");
        System.out.println(
                "Getting deeper into the mountain you think to yourself, that rat was alot stronger then other rats i've battled...");
        pressEnter();
        player.setHealth(player.getHealth() - 8);
        System.out.println("Before you have time to think about anything else a " + snake.getName()
                + " jumps on you dealing 8 damage! Current health: " + player.getHealth());

        pressEnter();
        battleDragon(snake);
        clearScreen();

        System.out.println("Wow.. that was one tough " + snake.getName());
        System.out.println("Going even deeper into the mountain the heat is growing...");
        System.out.println("You can here a rumbling deeper inside the mountain...");
        System.out.println("The dragon must be close...");
        pressEnter();
        System.out.println(
                "From the corner of your eye you see somthing running towards you. It's a " + fox.getName() + "!");
        pressEnter();
        battleDragon(fox);
        clearScreen();

        System.out.println("That " + fox.getName() + " was mean...");
        System.out.println("With your body aching and you being covered in mud and dirt, the heat keeps raising...");
        System.out.println(
                "Almost wishing you never entered the village some time ago, but the temptation of being the hero is to strong");
        pressEnter();
        clearScreen();

        System.out.println("The pathway inside the mountain opens up...");
        System.out.println("You can see huge cave like room, gold and emerals is covering the entire cave...");
        System.out.println("This must be it you pander... ");
        System.out.println("This must be the lair of the dragon!");
        pressEnter();
        clearScreen();

        System.out.println("You here a huge roar and a " + dragon.getName() + " flyes towards you spitting fire...");
        System.out.println("You manage in the last second to throw yourself to the side, evading the fire...");
        System.out.println("This is it! it's now or never...");
        pressEnter();
        battleDragon(dragon);
        clearScreen();

        gameWin();

    }

    public void battleDragon(Enemy enemy) {
        clearScreen();
        boolean fighting = true;

        while (fighting) {
            System.out.println("Your current health: " + player.getHealth());
            System.out.println(enemy.getName() + " current health: " + enemy.getHealth());

            System.out.println("What's your action?");
            System.out.println("1. Attack");
            System.out.println("2. Use Health Potion");

            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            if (choice == 1) {

                Weapon equippedWeapon = player.getEquippedWeapon();

                if (equippedWeapon instanceof MeleeWeapon) {
                    ((MeleeWeapon) equippedWeapon).meleeAttack();
                } else if (equippedWeapon instanceof RangedWeapon) {
                    ((RangedWeapon) equippedWeapon).rangedAttack();
                }

                int playerDamage = calcPlayerDamage();
                enemy.takeDamage(playerDamage);

                System.out.println("\nYou dealt " + playerDamage + " damage to the " + enemy.getName() + ".");

                if (enemy.getHealth() <= 0) {
                    System.out.println("You defeated the " + enemy.getName() + ".");
                    calcLoot(enemy, player);
                    pressEnter();
                    fighting = false;
                    break;
                }

                int enemyDamage = calcEnemyDamage(enemy);
                player.takeDamage(enemyDamage);

                System.out.println("The " + enemy.getName() + " dealt " + enemyDamage + " damage to you.\n");

                if (player.getHealth() <= 0) {
                    System.out.println("\nYou were defeted by " + enemy.getName() + ".");
                    pressEnter();
                    gameOver();
                    fighting = false;
                }
            } else if (choice == 2) {
                Inventory inventory = player.getInventory();
                HealthPotion potion = inventory.findHealthPotionInInventory();

                if (potion != null) {
                    int healing = potion.getPotency();
                    player.setHealth(Math.min(player.getHealth() + healing, player.getMaxHealth()));

                    System.out.println("\nYou used a health potion and restored " + healing + " health points.");
                    player.getInventory().removeItem(potion);
                    System.out.println(" ");
                } else {
                    System.out.println("\nYou don't have any health potions left!");
                    System.out.println(" ");
                }
            } else {
                clearScreen();
                System.out.println("Invalid choice! Try again!\n");
            }
        }
    }

    public void battle(Enemy enemy) {
        clearScreen();
        boolean fighting = true;

        while (fighting) {
            System.out.println("Your current health: " + player.getHealth());
            System.out.println(enemy.getName() + " current health: " + enemy.getHealth());

            System.out.println("What's your action?");
            System.out.println("1. Attack");
            System.out.println("2. Flee");

            int choice = getIntInput();
            scanner.nextLine(); // consume extra chars

            if (choice == 1) {

                Weapon equippedWeapon = player.getEquippedWeapon();

                if (equippedWeapon instanceof MeleeWeapon) {
                    ((MeleeWeapon) equippedWeapon).meleeAttack();
                } else if (equippedWeapon instanceof RangedWeapon) {
                    ((RangedWeapon) equippedWeapon).rangedAttack();
                }

                int playerDamage = calcPlayerDamage();
                enemy.takeDamage(playerDamage);

                System.out.println("\nYou dealt " + playerDamage + " damage to the " + enemy.getName() + ".");

                if (enemy.getHealth() <= 0) {
                    System.out.println("You defeated the " + enemy.getName() + ".");
                    calcLoot(enemy, player);
                    pressEnter();
                    fighting = false;
                    townCenter();
                    break;
                }

                int enemyDamage = calcEnemyDamage(enemy);
                player.takeDamage(enemyDamage);

                System.out.println("The " + enemy.getName() + " dealt " + enemyDamage + " damage to you.\n");

                if (player.getHealth() <= 0) {
                    System.out.println("You were defeted by " + enemy.getName() + ".");
                    pressEnter();
                    gameOver();
                    fighting = false;
                }
            } else if (choice == 2) {
                System.out.println("You cowardly ran away!");
                calcLossRisk(enemy);
                pressEnter();
                townCenter();
                fighting = false;
            } else {
                clearScreen();
                System.out.println("Invalid choice! Try again!\n");
            }
        }
    }

    public int calcPlayerDamage() {

        Weapon equippedWeapon = player.getEquippedWeapon();
        int weaponDamage = equippedWeapon != null ? equippedWeapon.getDamage() : 0;

        return player.getStrength() + weaponDamage;
    }

    public int calcEnemyDamage(Enemy enemy) {
        int baseDamage = enemy.getStrength() - player.getDefence();

        Armor equippedArmor = player.getEquippedArmor();
        int armorDefence = (equippedArmor != null) ? equippedArmor.getDamageDefence() : 0;
        if (equippedArmor != null) {
            equippedArmor.setDurability(equippedArmor.getDurability() - 1);

            if (equippedArmor.getDurability() <= 0) {
                System.out.println(equippedArmor.getName() + " is broken and not be usable anymore!");
                equippedArmor.setDamageDefence(0);
            }
        }

        return Math.max(0, baseDamage - armorDefence);
    }

    public void calcLoot(Enemy enemy, Player player) {
        Random random = new Random();
        int luckyLoot = random.nextInt(1000);
        if (luckyLoot == 23) {
            player.setBalance(player.getBalance() + 100);
            System.out.println("After defeating the " + enemy.getName() + " you found a large amount of money!"
                    + " 100 coins has been added to your balance." + " New balance: " + player.getBalance());
        }

        int loot = random.nextInt(10);
        if (loot >= 1) {
            player.setBalance(player.getBalance() + loot);
            System.out.println(
                    "After defeating the " + enemy.getName() + " " + loot + " coins has been added to your balance."
                            + " New balance: " + player.getBalance());
        } else {

            System.out.println("After defeating the " + enemy.getName() + " no loot was found! Current balance: "
                    + player.getBalance());
        }
    }

    public void calcLossRisk(Enemy enemy) {
        Random random = new Random();

        int chance = random.nextInt(10000) + 1;
        int change2 = random.nextInt(10) + 1;
        int chance3 = random.nextInt(100) + 1;

        if (player.getHealth() <= 5) {
            if (chance == 1337) {
                System.out.println("Badly wounded you tried to run away from the " + enemy.getName() + " but the "
                        + enemy.getName() + " caught up with and defeated you!");
                gameOver();
            }
        }

        if (player.getHealth() >= 11) {
            if (change2 <= 3) {
                player.setHealth(10);
                System.out.println("While running away from the " + enemy.getName() + " you fell over and "
                        + enemy.getName() + " manage to get a few more hits on you!");
                System.out.println("Current health: " + player.getHealth());
            }

        }
        if (player.getBalance() >= 1) {
            if (chance3 <= 10) {
                System.out.println("While running away you lost all your money");
                player.setBalance(0);
            } else {
                System.out.println("You manage to get away without loosing any money");
            }
        }

    }

    public void checkInventory() {
        clearScreen();
        player.showInventory();
        pressEnter();
        townCenter();
    }

    public void checkEquippedInventory() {
        clearScreen();
        player.showEquippedInventory();
        pressEnter();
        townCenter();
    }

    public void manageInventory() {
        clearScreen();
        player.manageInventory();
        pressEnter();
        townCenter();
    }

    public void manageEquippedItems() {
        clearScreen();
        player.manageEquippedInventory();
        pressEnter();
        townCenter();
    }

    public void gameOver() {
        System.out.println("Good bye " + player.getName() + "! Hope to see you soon again!");
        System.exit(0);
    }

    public void gameWin() {
        System.out
                .println("After killing the dragon you return to the village with the treasures from the dragon lair");
        System.out.println("NO WAY!!! " + player.getName() + " DID IT!!!!");
        pressEnter();

        System.out.println(
                "Thanks for playing this rpg battle game!\nCongratz on completing the game!\n until next time! Good Bye!");
        System.out.println("Game created by 'MasterFlex3.5' ");
        System.exit(0);
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

    public void pressEnter() {
        System.out.println("Press enter to continue...");
        scanner.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
