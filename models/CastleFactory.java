package models;

public class CastleFactory implements BuildingFactory {
    @Override
    public IBuilding createBuilding() {

        return new Castle();
    }
}
