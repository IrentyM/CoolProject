package models;

public interface IMilitary {
    void recruitSoldiers(Country targetCountry, int numberOfRecruits);
    int getAvailableRecruits();
    int getSoldiers();
    void setMilitaryPoints(int militaryPoints);
}