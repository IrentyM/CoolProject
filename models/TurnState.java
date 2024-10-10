package models;

interface TurnState {
    void manageTurn(Game context);
    void nextState(Game context);
}

