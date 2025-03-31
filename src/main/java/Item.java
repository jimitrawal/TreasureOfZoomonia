package src.main.java;

public class Item {
    private String name;
    private String description;

    public Item(String name, String description, String description2) {
        this.name = name;
        this.description = description2;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
