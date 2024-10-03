package models;

import java.util.HashMap;
import java.util.Map;

public class RelationshipManager implements IRelationship {
    private Map<Country, RelationshipStatus> relationships = new HashMap<>();

    @Override
    public void setRelationship(Country targetCountry, RelationshipStatus status) {
        relationships.put(targetCountry, status);
    }

    @Override
    public RelationshipStatus getRelationship(Country targetCountry) {
        return relationships.getOrDefault(targetCountry, RelationshipStatus.NEUTRAL);
    }
}
