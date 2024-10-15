package models.state;

import java.util.Objects;

import models.country.Country;
import models.country.CountryType;
import models.game.Game;

class MilitaryState implements TurnState {
    @Override
    public void manageTurn(Game context) {
        Country currentCountry = context.getCurrentCountry();
        if (Objects.requireNonNull(currentCountry.getType()) == CountryType.NEUTRAL) {
            System.out.println("Military phase for " + currentCountry.getName());
            currentCountry.manageMilitary(currentCountry);
        }
    }

    @Override
    public void nextState(Game context) {
        context.setState(new AIState());  // Move to the Military phase
    }
}



