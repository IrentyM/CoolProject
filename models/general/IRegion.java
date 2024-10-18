package models.general;

import models.country.Country;

public interface IRegion {
    String getName();
    int getDevelopmentLevel();
    void upgradeDevelopmentLevel();
    void addSoldiers(String soldierType, int count);

    boolean isNeutral();

    boolean isEnemy(Country targetcountry);

    boolean isOwnedByAlly(Country targetcountry);

    void removeSoldiers(String type, int i);
    int getRegionSoldier(String soldierType);
    boolean moveSoldier(String soldier, IRegion currentRegion, IRegion targetRegion);
}
