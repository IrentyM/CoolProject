package models;


public interface ISoldierFactory {
    Soldier createSoldier(String type, int Amount);

}
