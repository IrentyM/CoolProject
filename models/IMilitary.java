package models;

public interface IMilitary {
    void recruitSoldiers(int numberOfRecruits);
    int getAvailableRecruits();
    int getSoldiers();
    void setMilitaryPoints(int militaryPoints);
}