package models;

import java.util.Objects;

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



