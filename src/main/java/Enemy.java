package src.main.java;

public class Enemy {
    private String name;
    private int health;
    private int attack;

    public Enemy(String name, int health, int attack, String description) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }
}
