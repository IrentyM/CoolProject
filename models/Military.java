package models;

public class Military implements IMilitary {
    private int soldiers; // Current number of soldiers
    private int militaryPoints; // Military points for calculating recruits
    private int recruits;
    private static final int RECRUITS_PER_MILITARY_POINT = 30; // Recruits per military point

    // Constructor
    public Military(int initialSoldiers, int initialMilitaryPoints) {
        this.soldiers = initialSoldiers;
        this.militaryPoints = initialMilitaryPoints;
        this.recruits = militaryPoints * RECRUITS_PER_MILITARY_POINT;;
    }

    public void recruitSoldiers(Country targetCountry, int numberOfRecruits) {
        targetCountry.getEconomy().spentMoney(numberOfRecruits);
        soldiers += numberOfRecruits;
        recruits -= numberOfRecruits;
    }

    public int getAvailableRecruits() {
        return recruits; // Total recruits available based on military points
    }

    public int getSoldiers() {
        return soldiers;
    }

    public void setMilitaryPoints(int militaryPoints) {
        this.militaryPoints = militaryPoints;
    }
}
