package models;

public interface IRelationship {
    void setRelationship(Country targetCountry, RelationshipStatus status);
    RelationshipStatus getRelationship(Country targetCountry);
}