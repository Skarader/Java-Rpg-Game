package Enemies;

public abstract class Enemy {

    private String name;
    private int health;
    private int strength;

    public Enemy(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int strength() {
        return strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack() {
    };

}
