package src.main.java;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

import com.google.gson.Gson;

class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Initialize game state
        char direction;
        char confirm;
        Scanner scan = new Scanner(System.in);
        String[][] map = new String[10][10];
        Player player = new Player(2, 3);
        Random random = new Random();
        Item sword = new Item("Sword", "A basic sword", "A basic sword for fighting.");
        Enemy zombie = new Enemy("Zombie", 20, 5, "A basic zombie");

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                map[i][j] = "You are in a vast ocean.";
            }
        }

        try {
            Scanner fh = new Scanner(new File("datafile"));
            while (fh.hasNext()) {
                String line = fh.nextLine();
                String[] fileC = line.split(",");
                int a = Integer.parseInt(fileC[0].trim());
                int b = Integer.parseInt(fileC[1].trim());
                map[a][b] = fileC[2];
            }
            fh.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // Define routes
        get("/move/:direction", (req, res) -> {
            String dir = req.params(":direction");
            if (dir.equals("N")) {
                player.setY(player.getY() + 1);
            } else if (dir.equals("S")) {
                player.setY(player.getY() - 1);
            } else if (dir.equals("E")) {
                player.setX(player.getX() + 1);
            } else if (dir.equals("W")) {
                player.setX(player.getX() - 1);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("x", player.getX());
            response.put("y", player.getY());
            response.put("description", map[player.getX()][player.getY()]);
            return gson.toJson(response);
        });

        get("/pickup", (req, res) -> {
            if ((player.getX() == 5) && (player.getY() == 7)) {
                player.setJewelPickup(player.getJewelPickup() + 1);
            }
            if ((player.getX() == 5) && (player.getY() == 5)) {
                player.setWeaponPickup(player.getWeaponPickup() + 1);
                player.addItem(sword);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("jewels", player.getJewelPickup());
            response.put("weapons", player.getWeaponPickup());
            response.put("inventory", player.getInventory());
            return gson.toJson(response);
        });

        get("/dropoff", (req, res) -> {
            if (player.getJewelPickup() > 0) {
                player.setJewelPickup(player.getJewelPickup() - 1);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("jewels", player.getJewelPickup());
            response.put("weapons", player.getWeaponPickup());
            return gson.toJson(response);
        });

        get("/fight", (req, res) -> {
            String message;
            if ((player.getX() == 8) && (player.getY() == 4)) {
                message = "You are fighting a " + zombie.getName() + "!\n";
                if (player.getWeaponPickup() >= 1) {
                    message += "You attack the " + zombie.getName() + " with your " + sword.getName() + "!\n";
                    int damage = random.nextInt(10);
                    message += "You deal " + damage + " damage!\n";
                    if (damage > 5) {
                        message += "You killed the " + zombie.getName() + "!\n";
                    } else {
                        message += "The " + zombie.getName() + " is still alive!\n";
                    }
                } else {
                    message = "You do not have a weapon to use. You cannot fight.\n";
                }
            } else {
                message = "You cannot fight.\n";
            }
            Map<String, Object> response = new HashMap<>();
            response.put("message", message);
            return gson.toJson(response);
        });

        get("/inventory", (req, res) -> {
            List<String> inventoryDescriptions = new ArrayList<>();
            for (Item item : player.getInventory()) {
                inventoryDescriptions.add(item.getName() + ": " + item.getDescription());
            }
            return gson.toJson(inventoryDescriptions);
        });

        get("/map", (req, res) -> {
            return gson.toJson(map);
        });

        get("/player", (req, res) -> {
            Map<String, Object> response = new HashMap<>();
            response.put("x", player.getX());
            response.put("y", player.getY());
            response.put("jewels", player.getJewelPickup());
            response.put("weapons", player.getWeaponPickup());
            return gson.toJson(response);
        });

        // Initial location message
        get("/", (req, res) -> {
            Map<String, Object> response = new HashMap<>();
            response.put("message", map[player.getX()][player.getY()]);
            return gson.toJson(response);
        });
    }
}
