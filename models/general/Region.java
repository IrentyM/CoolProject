package models.general;

import models.AbstractFactory.IBuilding;
import models.country.Country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.general.RelationshipStatus.ALLIED;
import static models.general.RelationshipStatus.AT_WAR;

public class Region implements IRegion, Cloneable {
    private String name;
    private int developmentLevel;
    private String capital;
    private List<IBuilding> buildings;
    private Country owner;

    // Soldier container: Map of soldier type to count
    private Map<String, Integer> soldiers;

    // Border logic: list of neighboring regions
    private List<Region> neighboringRegions;

    public Region(String name, int developmentLevel, String capital) {
        this.name = name;
        this.developmentLevel = developmentLevel;
        this.capital = capital;
        this.buildings = new ArrayList<>();
        this.soldiers = new HashMap<>(); // Initialize soldier container
        this.neighboringRegions = new ArrayList<>(); // Initialize the neighboring regions list
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

    // Soldier management methods
    public void addSoldiers(String soldierType, int count) {
        soldiers.put(soldierType, soldiers.getOrDefault(soldierType, 0) + count);
    }

    public boolean moveSoldier(String soldier, IRegion currentRegion, IRegion targetRegion) {
        if (targetRegion.isNeutral() || targetRegion.isOwnedByAlly(getOwner())) {

            currentRegion.removeSoldiers(soldier, getRegionSoldier(soldier));



            // Add soldier to the target region
            targetRegion.addSoldiers(soldier, getRegionSoldier(soldier));
            System.out.println("Soldier moved to " + targetRegion.getName() + ".");
            return true;
        } else if (targetRegion.isEnemy(getOwner())) {
            currentRegion.removeSoldiers(soldier, getRegionSoldier(soldier));


            // Add soldier to the target region
            targetRegion.addSoldiers(soldier, getRegionSoldier(soldier));
                System.out.println("Soldier moved to enemy region: " + targetRegion.getName() + " for battle.");
                return true;

        } else {
            System.out.println("Cannot move soldier. Invalid target region.");
            return false;
        }
    }

    public void removeSoldiers(String soldierType, int count) {
        if (soldiers.containsKey(soldierType)) {
            int currentCount = soldiers.get(soldierType);
            if (currentCount >= count) {
                soldiers.put(soldierType, currentCount - count);
            } else {
                System.out.println("Not enough soldiers to remove.");
            }
        } else {
            System.out.println("No soldiers of type " + soldierType + " in the region.");
        }
    }

    public Map<String, Integer> getSoldiers() {
        return new HashMap<>(soldiers); // Return a copy to prevent external modification
    }

    // Border management methods

    // Add a neighboring region
    public void addNeighbor(Region neighbor) {
        if (!neighboringRegions.contains(neighbor)) {
            neighboringRegions.add(neighbor);
            neighbor.neighboringRegions.add(this); // Add this region to the neighbor's list as well
        }
    }

    // Remove a neighboring region
    public void removeNeighbor(Region neighbor) {
        neighboringRegions.remove(neighbor);
        neighbor.neighboringRegions.remove(this); // Remove this region from the neighbor's list
    }
    public int getRegionSoldier(String soldierType) {
        return soldiers.getOrDefault(soldierType, 0); // Return the count or 0 if not present
    }
    // Check if two regions are neighbors
    public boolean isNeighbor(Region region) {
        return neighboringRegions.contains(region);
    }

    // Get neighboring regions
    public List<Region> getNeighbors() {
        return new ArrayList<>(neighboringRegions); // Return a copy of the list to prevent modification
    }
    @Override
    public boolean isNeutral() {
        return owner == null; // A region is neutral if it has no owner
    }

    @Override
    public boolean isEnemy(Country targetcountry) {
        // Logic to determine if the region's owner is an enemy
        if(owner.getRelationshipManager().getRelationship(targetcountry)== AT_WAR) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isOwnedByAlly(Country targetcountry) {
        if(owner.getRelationshipManager().getRelationship(targetcountry)== ALLIED) {
            return true;
        }else{
            return false;
        }
    }

    // Method to get the owner
    public Country getOwner() {
        return owner;
    }

    // Method to set the owner (useful for conquering regions)
    public void setOwner(Country newOwner) {
        this.owner = newOwner;
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

            // Deep copy the soldiers map
            cloned.soldiers = new HashMap<>(this.soldiers);

            // Do not copy neighboring regions (since they are references to other regions)

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can never happen
        }
    }
}
