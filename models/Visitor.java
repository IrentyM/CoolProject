package models;

public interface Visitor {
    void visit(Country country);
    void visit(Economy economy);
    void visit(Military military);
}


