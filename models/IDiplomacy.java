package models;

public interface IDiplomacy {
    boolean canFormAlliance();
    boolean canFormNonAggressionPact();
    void formAlliance(Country targetCountry);
    void formNonAggressionPact(Country targetCountry);
    void sendGift(Country targetCountry, int amount);
    void humiliate(Country targetCountry, int amount);
    void breakAlliance(Country targetCountry);
    void declareWar(Country targetCountry);
}