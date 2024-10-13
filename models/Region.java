package models;

import java.util.ArrayList;
import java.util.List;

public class Region implements IRegion, Cloneable {
    private String name;
    private int developmentLevel;
    private String capital;
    private List<IBuilding> buildings;

    public Region(String name, int developmentLevel, String capital) {
        this.name = name;
        this.developmentLevel = developmentLevel;
        this.capital = capital;
        this.buildings = new ArrayList<>();
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

    public void addBuilding(IBuilding building) {
        buildings.add(building);
    }

    // Prototype method
    @Override
    protected Region clone() {
        try {
            Region cloned = (Region) super.clone();
            // Deep copy the buildings list
            cloned.buildings = new ArrayList<>(this.buildings.size());
            for (IBuilding building : this.buildings) {
                cloned.buildings.add(building); // Assuming IBuilding also implements Cloneable
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can never happen
        }
    }
}
