package models;

public class Country {
    private String name;
    private int regions;
    private Leader leader;
    private int development;
    private int economicScore;

    // Constructor
    public Country(String name, int regions, Leader leader, int development) {
        this.name = name;
        this.regions = regions;
        this.leader = leader;
        this.development = development;
        // Economic score calculated from leader's economic skill
        this.economicScore = leader.getEconomicSkill() * 10;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public Leader getLeader() {
        return leader;
    }

    public int getEconomicScore() {
        return economicScore;
    }

    public int getDevelopment() {
        return development;
    }

    public int getRegions() {
        return regions;
    }
}
