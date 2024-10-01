package models;

public class Leader {
    private String name;
    private int militarySkill;
    private int economicSkill;
    private int diplomaticSkill;

    // Constructor
    public Leader(String name, int militarySkill, int economicSkill, int diplomaticSkill) {
        this.name = name;
        this.militarySkill = militarySkill;
        this.economicSkill = economicSkill;
        this.diplomaticSkill = diplomaticSkill;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getMilitarySkill() {
        return militarySkill;
    }

    public int getEconomicSkill() {
        return economicSkill;
    }

    public int getDiplomaticSkill() {
        return diplomaticSkill;
    }
}
