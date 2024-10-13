package models;

public class FarmFactory implements BuildingFactory {
    @Override
    public IBuilding createBuilding() {
        return new Farm();
    }
}
