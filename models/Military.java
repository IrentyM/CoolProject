package models;
import java.util.ArrayList;
import java.util.List;

public class Military implements IMilitary {
    private int soldiers;
    private int militaryPoints;
    private int recruits;
    private static final int RECRUITS_PER_MILITARY_POINT = 30;
    private List<Soldier> army;  // List to hold recruited soldiers

    private ISoldierFactory soldierFactory;

    public Military(int initialSoldiers, int initialMilitaryPoints) {
        this.soldiers = initialSoldiers;
        this.militaryPoints = initialMilitaryPoints;
        this.recruits = militaryPoints * RECRUITS_PER_MILITARY_POINT;
        this.army = new ArrayList<>();
        this.soldierFactory = new SoldierFactory(); // Factory for soldier creation
    }

    public void recruitSoldier(String type) {
        Soldier newSoldier = soldierFactory.createSoldier(type);
        if (recruits >= newSoldier.getCost()) {
            recruits -= newSoldier.getCost();
            army.add(newSoldier);
            System.out.println(newSoldier.getType() + " recruited!");
        } else {
            System.out.println("Not enough recruits to create " + newSoldier.getType());
        }
    }

    @Override
    public void recruitSoldiers(Country targetCountry, int numberOfRecruits) {

    }

    public int getAvailableRecruits() {
        return recruits;
    }

    @Override
    public int getSoldiers() {
        return 0;
    }

    public int getSoldiersCount() {
        return army.size();
    }

    public void setMilitaryPoints(int militaryPoints) {
        this.militaryPoints = militaryPoints;
    }
}
