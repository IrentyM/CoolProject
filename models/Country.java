package models;

import java.util.ArrayList;

public class Country {
    private String name;
    private ArrayList<Region> regions;
    private Diplomacy diplomacy;
    private Economy economy;
    private Military military;
    private Leader leader;
    private String capital;

    // Basic skill constant
    private static final int BASIC_SKILL = 3;

    public Country(String name, Diplomacy diplomacy, Economy economy, Military military, Leader leader, String capital) {
        if (name == null || diplomacy == null || economy == null || military == null || leader == null || capital == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.name = name;
        this.regions = new ArrayList<>();
        this.diplomacy = diplomacy;
        this.economy = economy;
        this.military = military;
        this.leader = leader;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }
    public String getCapital() {
        return capital;
    }
    public void addRegion(Region region) {
        regions.add(region);
    }

    public void removeRegion(Region region) {
        regions.remove(region);
    }

    public Region findRegionByName(String regionName) {
        for (Region region : regions) {
            if (region.getName().equalsIgnoreCase(regionName)) {
                return region;
            }
        }
        return null; // or throw an exception
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public Diplomacy getDiplomacy() {
        return diplomacy;
    }

    public Economy getEconomy() {
        return economy;
    }

    public Leader getLeader() {
        return leader;
    }

    public Military getMilitary() {
        return military;
    }

    public int getFinalDiplomacySkill() {
        return BASIC_SKILL + leader.getDiplomacySkill();
    }

    public int getFinalEconomySkill() {
        return BASIC_SKILL + leader.getEconomySkill();
    }

    public int getFinalMilitarySkill() {
        return BASIC_SKILL + leader.getMilitarySkill();
    }

    public int calculateIncome() {
        int totalIncome = 0;
        for (Region region : regions) {
            totalIncome += region.getDevelopmentLevel() * 5; // Example calculation
        }
        return totalIncome;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", regions=" + regions +
                ", finalDiplomacySkill=" + getFinalDiplomacySkill() +
                ", finalEconomySkill=" + getFinalEconomySkill() +
                ", finalMilitarySkill=" + getFinalMilitarySkill() +
                ", leader=" + leader.getName() +
                '}';
    }
}
