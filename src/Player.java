import Items.Item;

public class Player {
    private String name;
    private int age;
    private int health;
    private int strength;
    private int cap;
    private int balance;
    private Inventory inventory;

    public Player(String name, int age, int health, int strength, int cap, int balance) {
        this.name = name;
        this.age = age;
        this.health = 100;
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

    public int getStrength() {
        return strength;
    }

    public int getCap() {
        return cap;
    }

    public int getBalance() {
        return balance;
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
    // METHODS

}
