package models;

public interface BuildingFactory {
    IBuilding createBuilding();
    IBuilding deleteBuilding();
    IBuilding upgradeBuilding();
}