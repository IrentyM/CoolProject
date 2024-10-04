package models;

public interface IDiplomacy {
    boolean canFormAlliance(Country myCountry, Country targetCountry);
    boolean canFormNonAggressionPact(Country myCountry, Country targetCountry);
    void formAlliance(Country myCountry, Country targetCountry);
    void formNonAggressionPact(Country myCountry, Country targetCountry);
    void sendGift(Country myCountry, Country targetCountry, int amount);
    void humiliate(Country myCountry, Country targetCountry, int amount);
    void breakAlliance(Country myCountry,Country targetCountry);
    void declareWar(Country myCountry,Country targetCountry);
    int getDiplomacyPoints(Country myCountry);
    void EndWar(Country myCountry,Country targetCountry);
}