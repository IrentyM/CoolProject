package models;

public class Region {
    private String name;
    private int developmentLevel;


    public Region(String name, int developmentLevel, String capital) {
        this.name = name;
        this.developmentLevel = developmentLevel;

    }

    public String getName() {
        return name;
    }

    public int getDevelopmentLevel() {
        return developmentLevel;
    }


}

