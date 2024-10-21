package models.factory;

public interface ISoldierFactory {
    Soldier createSoldier(String type, int Amount);

}
