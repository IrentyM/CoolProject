package models;

public class Region implements IRegion {
    private String name;
    private int developmentLevel;
    private String capital;

    public Region(String name, int developmentLevel, String capital) {
        this.name = name;
        this.developmentLevel = developmentLevel;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public int getDevelopmentLevel() {
        return developmentLevel;
    }

    public String getCapital() {
        return capital;
    }

    public void upgradeDevelopmentLevel() {
        if (developmentLevel < 10) {
            developmentLevel++;
            System.out.println(name + " upgraded to development level " + developmentLevel);
        } else {
            System.out.println(name + " is already at maximum development level.");
        }
    }
}
