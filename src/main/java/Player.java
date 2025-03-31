package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int x;
    private int y;
    private int jewelPickup;
    private int weaponPickup;
    private List<Item> inventory;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.jewelPickup = 0;
        this.weaponPickup = 0;
        this.inventory = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getJewelPickup() {
        return jewelPickup;
    }

    public void setJewelPickup(int jewelPickup) {
        this.jewelPickup = jewelPickup;
    }

    public int getWeaponPickup() {
        return weaponPickup;
    }

    public void setWeaponPickup(int weaponPickup) {
        this.weaponPickup = weaponPickup;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }
}
