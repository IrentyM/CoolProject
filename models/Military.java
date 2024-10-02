package models;

public class Military {
    private int soldiers; // Current number of soldiers
    private int militaryPoints; // Military points for calculating recruits
    private static final int RECRUITS_PER_MILITARY_POINT = 30; // Recruits per military point

    // Constructor
    public Military(int initialSoldiers, int initialMilitaryPoints) {
        this.soldiers = initialSoldiers;
        this.militaryPoints = initialMilitaryPoints;
    }

    // Method to recruit soldiers based on military points
    public void recruitSoldiers(int numberOfRecruits) {
        soldiers += numberOfRecruits; // Increase soldier count
    }

    // Method to calculate total recruits available
    public int getAvailableRecruits() {
        return militaryPoints * RECRUITS_PER_MILITARY_POINT; // Total recruits available based on military points
    }

    // Getters
    public int getSoldiers() {
        return soldiers;
    }
    public int getMilitaryPointsPoints() {
        return militaryPoints;
    }
    public void setMilitaryPoints(int militaryPoints) {
        this.militaryPoints = militaryPoints;
    }
}

