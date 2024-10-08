package Player;

import Inventory.Inventory;
import Items.Item;
import Items.Weapons.Weapon;
import Items.Armors.Armor;

public class Player {
    private int MAX_HEALTH = 100;

    private String name;
    private int age;
    private int health;
    private int defence;
    private int strength;
    private int cap;
    private int balance;
    private Inventory inventory;

    public Player(String name, int age, int health, int defence, int strength, int cap, int balance) {
        this.name = name;
        this.age = age;
        this.health = 100;
        this.defence = 0;
        this.strength = 2;
        this.cap = 50;
        this.balance = 0;
        this.inventory = new Inventory(this);
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public int getDefence() {
        return defence;
    }

    public int getStrength() {
        return strength;
    }

    public int getCap() {
        return cap;
    }

    public int getBalance() {
        return balance;
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // GETTERS

    // --------------------------------------------------------------------------------------------------------------------------------------------------------------

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    // SETTERS

    // METHODS
    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public void showInventory() {
        inventory.showInventory();
    }

    public void showEquippedInventory() {
        inventory.showEquippedItems();
    }

    public void manageInventory() {
        inventory.manageInventory();
    }

    public void manageEquippedInventory() {
        inventory.manageEquippedInventory();
    }

    public Weapon getEquippedWeapon() {
        return inventory.getEquippedWeapon();
    }

    public Armor getEquippedArmor() {
        return inventory.getEquippedArmor();
    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
    }
    // METHODS

}
