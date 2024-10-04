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

    public Country(String name, ILeader leader, IEconomy economy, IMilitary military, List<IRegion> regions) {
        this.name = name;
        this.leader = leader;
        this.economy = economy;
        this.military = military;
        this.relationshipManager = new RelationshipManager();
        this.diplomacy = new Diplomacy(3, economy); // Example diplomacy points initialization
        this.regions = regions;
        this.relationshipManager = new RelationshipManager();
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
