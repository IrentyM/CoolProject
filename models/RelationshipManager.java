package models;

import java.util.HashMap;
import java.util.Map;

public class RelationshipManager implements IRelationship {
    private Map<Country, RelationshipStatus> relationships = new HashMap<>();
    private Map<Country, Integer> opinions;

    public RelationshipManager() {
        this.relationships = new HashMap<>();
        this.opinions = new HashMap<>();
    }
    @Override
    public void setRelationship(Country targetCountry, RelationshipStatus status) {
        relationships.put(targetCountry, status);
    }

    @Override
    public RelationshipStatus getRelationship(Country targetCountry) {
        return relationships.getOrDefault(targetCountry, RelationshipStatus.NEUTRAL);
    }
    @Override
    public void setOpinion(Country targetCountry, int opinion) {
        // Ensure the opinion value is within the range of -100 to +100
        if (opinion < -100) {
            opinion = -100;
        } else if (opinion > 100) {
            opinion = 100;
        }
        opinions.put(targetCountry, opinion);
    }

    // Method to modify the opinion by a delta value (positive or negative)
    @Override
    public void modifyOpinion(Country targetCountry, int delta) {
        int currentOpinion = opinions.getOrDefault(targetCountry, 0);
        setOpinion(targetCountry, currentOpinion + delta); // Adjust opinion within range
    }

    // Method to get the opinion of the current country towards another country
    @Override
    public int getOpinion(Country targetCountry) {
        return opinions.getOrDefault(targetCountry, 0); // Default opinion is 0
    }
}
