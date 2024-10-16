package models.EventTemplate;

import models.country.Country;

public class MilitaryBoostEvent extends GameEvent {
    private Country country;

    public MilitaryBoostEvent(Country country) {
        this.country = country;
    }
    @Override
    protected void executeEvent() {
        System.out.println(country.getName() + " receives an Military boost.");
        String type = "cavalry";
        country.getMilitary().recruitSoldier(type,200);  // Boost the economy
    }
}
