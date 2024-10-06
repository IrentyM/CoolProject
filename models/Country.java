package models;

import java.util.List;

public class Country {
    private String name;
    private IEconomy economy;
    private IMilitary military;
    private IRelationship relationshipManager;
    private IDiplomacy diplomacy;
    private ILeader leader;
    private List<IRegion> regions;

    // Constructor is now private to enforce Factory Method usage
    private Country(String name, ILeader leader, IEconomy economy, IMilitary military, List<IRegion> regions) {
        this.name = name;
        this.leader = leader;
        this.economy = economy;
        this.military = military;
        this.relationshipManager = RelationshipManager.getInstance(); // Use Singleton
        this.diplomacy = new Diplomacy(3, economy);
        this.regions = regions;
    }

    // Factory Method to create Country instances
    public static Country createCountry(String name, ILeader leader, IEconomy economy, IMilitary military, List<IRegion> regions) {
        return new Country(name, leader, economy, military, regions);
    }

    public String getName() {
        return name;
    }

    public ILeader getLeader() {
        return leader;
    }

    public IEconomy getEconomy() {
        return economy;
    }

    public IMilitary getMilitary() {
        return military;
    }

    public IRelationship getRelationshipManager() {
        return relationshipManager;
    }

    public IDiplomacy getDiplomacy() {
        return diplomacy;
    }

    public List<IRegion> getRegions() {
        return regions;
    }
}
