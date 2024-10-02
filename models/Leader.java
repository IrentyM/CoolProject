package models;

public class Leader {
    private String name;
    private int militarySkill;
    private int economySkill;
    private int diplomacySkill;

    public Leader(String name, int militarySkill, int economySkill, int diplomacySkill) {
        this.name = name;
        this.militarySkill = militarySkill;
        this.economySkill = economySkill;
        this.diplomacySkill = diplomacySkill;
    }

    public String getName() {
        return name;
    }

    public int getMilitarySkill() {
        return militarySkill;
    }

    public int getEconomySkill() {
        return economySkill;
    }

    public int getDiplomacySkill() {
        return diplomacySkill;
    }
}

