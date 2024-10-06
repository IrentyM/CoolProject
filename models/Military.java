package models;

public class Military implements IMilitary, Cloneable {
    private int soldiers;
    private int militaryPoints;
    private int recruits;
    private static final int RECRUITS_PER_MILITARY_POINT = 30;

    public Military(int initialSoldiers, int initialMilitaryPoints) {
        this.soldiers = initialSoldiers;
        this.militaryPoints = initialMilitaryPoints;
        this.recruits = militaryPoints * RECRUITS_PER_MILITARY_POINT;
    }

    public void recruitSoldiers(Country targetCountry, int numberOfRecruits) {
        if (targetCountry.getEconomy().subtractMoney(numberOfRecruits)) {
            soldiers += numberOfRecruits;
            recruits -= numberOfRecruits;
            System.out.println(numberOfRecruits + " soldiers recruited.");
        }
    }

    public int getAvailableRecruits() {
        return recruits;
    }

    public int getSoldiers() {
        return soldiers;
    }

    public void setMilitaryPoints(int militaryPoints) {
        this.militaryPoints = militaryPoints;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }
}