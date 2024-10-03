package models;

public class Military implements IMilitary {
    private int soldiers; // Current number of soldiers
    private int militaryPoints; // Military points for calculating recruits
    private static final int RECRUITS_PER_MILITARY_POINT = 30; // Recruits per military point

    // Constructor
    public Military(int initialSoldiers, int initialMilitaryPoints) {
        this.soldiers = initialSoldiers;
        this.militaryPoints = initialMilitaryPoints;
    }

    public void recruitSoldiers(int numberOfRecruits) {
        soldiers += numberOfRecruits; // Increase soldier count
    }

    public int getAvailableRecruits() {
        return militaryPoints * RECRUITS_PER_MILITARY_POINT; // Total recruits available based on military points
    }

    public int getSoldiers() {
        return soldiers;
    }

    public void setMilitaryPoints(int militaryPoints) {
        this.militaryPoints = militaryPoints;
    }
}
