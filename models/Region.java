package models;

public class Region implements IRegion, CloneableRegion {
    private String name;
    private int developmentLevel;
    private String capital;
    private BuildingFactory buildingFactory;

    public Region(String name, int developmentLevel, String capital, BuildingFactory factory) {
        this.name = name;
        this.developmentLevel = developmentLevel;
        this.capital = capital;
        this.buildingFactory = factory;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getDevelopmentLevel() {
        return developmentLevel;
    }

    public String getCapital() {
        return capital;
    }

    public BuildingFactory getBuildingFactory() {
        return buildingFactory;
    }

    // Upgrading the development level
    public void upgradeDevelopmentLevel() {
        if (developmentLevel < 10) {
            developmentLevel++;
            System.out.println(name + " upgraded to development level " + developmentLevel);
        } else {
            System.out.println(name + " is already at maximum development level.");
        }
    }

    // Clone method for the Prototype Pattern
    @Override
    public Region cloneRegion() {
        // Creates a shallow copy of the current region
        return new Region(this.name, this.developmentLevel, this.capital, this.buildingFactory);
    }
}