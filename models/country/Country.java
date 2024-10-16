package models.country;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.AbstractFactory.*;
import models.general.*;
import models.game.Visitor;


public class Country {
    private String name;
    private IEconomy economy;
    private IMilitary military;
    private CountryType type;
    private IRelationship relationshipManager;
    private IDiplomacy diplomacy;
    private ILeader leader;
    private List<IRegion> regions;
    private Scanner scanner;

    // Constructor is now private to enforce Factory Method usage
    private Country(String name, ILeader leader, IEconomy economy, IMilitary military, List<IRegion> regions,CountryType type) {
        this.name = name;
        this.leader = leader;
        this.economy = economy;
        this.type = type;
        this.military = military;
        this.relationshipManager = RelationshipManager.getInstance(); // Use Singleton
        this.diplomacy = new Diplomacy(3, economy);
        this.regions = regions;
        this.scanner = new Scanner(System.in);

    }

    // Factory Method to create Country instances
    public static Country createCountry(String name, ILeader leader, IEconomy economy, IMilitary military, List<IRegion> regions,CountryType type) {
        return new Country(name, leader, economy, military, regions,type);
    }

    public String getName() {
        return name;
    }

    public ILeader getLeader() {
        return leader;
    }

    public IEconomy getEconomy() {
        return economy;
    }

    public IMilitary getMilitary() {
        return military;
    }

    public IRelationship getRelationshipManager() {
        return relationshipManager;
    }

    public IDiplomacy getDiplomacy() {
        return diplomacy;
    }

    public List<IRegion> getRegions() {
        return regions;
    }
    public void manageDiplomacy(Country myCountry, Country targetCountry) {
        System.out.println("\nDiplomatic Actions with: " + targetCountry.getName());
        System.out.println("Diplomacy Points: " + myCountry.getDiplomacy().getDiplomacyPoints(myCountry));
        System.out.println("Opinion of " + targetCountry.getName() + ": " + myCountry.getRelationshipManager().getOpinion(targetCountry));
        System.out.println("Status of " + targetCountry.getName() + ": " + myCountry.getRelationshipManager().getRelationship(targetCountry));
        System.out.println("\nManage Diplomacy of a Country:");
        System.out.println("1. Form Alliance");
        System.out.println("2. Form Non-Aggression Pact");
        System.out.println("3. Send Gift");
        System.out.println("4. Humilate Country");
        System.out.println("5. Break Alliance");
        System.out.println("6. Declaining WAR");
        System.out.println("7. End War");
        System.out.println("8. Break Pact");
        System.out.println("9. End War");
        System.out.println("0. Back to Menu");
        int actionChoice = scanner.nextInt();

        boolean running = true;
        while (running) {
            if (actionChoice == 1) {
                myCountry.getDiplomacy().formAlliance(myCountry,targetCountry); // Form alliance
                break;
            } else if (actionChoice == 2) {
                myCountry.getDiplomacy().formNonAggressionPact(myCountry,targetCountry);// Form pact
                break;
            } else if (actionChoice == 3) {
                System.out.println("How many money spent?");
                int actionGift = scanner.nextInt();
                myCountry.getDiplomacy().sendGift(myCountry,targetCountry,actionGift);
                break;
            }else if (actionChoice == 4) {
                System.out.println("How many money spent?");
                int actionHumilate = scanner.nextInt();
                myCountry.getDiplomacy().humiliate(myCountry,targetCountry,actionHumilate);
                break;
            }else if (actionChoice == 5) {
                myCountry.getDiplomacy().breakAlliance(myCountry,targetCountry);
                break;
            }else if (actionChoice == 6) {
                myCountry.getDiplomacy().declareWar(myCountry,targetCountry);
                break;
            }else if (actionChoice == 7) {
                myCountry.getDiplomacy().EndWar(myCountry,targetCountry);
                break;
            }else if (actionChoice == 8) {
                myCountry.getDiplomacy().breakPact(myCountry,targetCountry);
                break;
            }else if (actionChoice == 9) {
                myCountry.getDiplomacy().ShowInfo(targetCountry);
                break;
            }else{
                running = false;
                System.out.println("Invalid choice. Please try again.");
            }
        }


    }
    public void manageMilitary(Country myCountry) {
        IMilitary military = myCountry.getMilitary();
        List<IRegion> regions = myCountry.getRegions();

        System.out.println("Manage Military of " + myCountry.getName() + ":");

        // Display current military stats
        System.out.println("Total Soldiers: " + military.getSoldierCount());
        System.out.println("Available Recruits: " + military.getAvailableRecruits());

        // Display soldier counts
        Map<String, Integer> soldierCounts = military.getSoldierCount();
        System.out.println("Soldier Counts:");
        for (Map.Entry<String, Integer> entry : soldierCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Ask how many recruits to add
        System.out.print("Enter the amount of soldiers to recruit: ");
        Scanner scanner = new Scanner(System.in);
        int soldierAmount = scanner.nextInt();

        if (soldierAmount <= military.getAvailableRecruits()) {
            System.out.println("Select the region where you want to recruit soldiers:");
            for (int i = 0; i < regions.size(); i++) {
                System.out.println((i + 1) + ". " + regions.get(i).getName() + " (Development Level: " + regions.get(i).getDevelopmentLevel() + ")");
            }

            int regionIndex = -1;
            boolean validRegion = false;

            while (!validRegion) {
                try {
                    regionIndex = scanner.nextInt();
                    if (regionIndex > 0 && regionIndex <= regions.size()) {
                        validRegion = true;
                    } else {
                        System.out.println("Invalid region selection. Please enter a number between 1 and " + regions.size() + ".");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                }
            }

            IRegion selectedRegion = regions.get(regionIndex - 1);
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Select type of soldier to recruit (infantry, cavalry): ");
                String soldierType = scanner.next();

                // Check if the input matches the expected soldier types
                if (soldierType.equalsIgnoreCase("infantry") || soldierType.equalsIgnoreCase("cavalry")) {
                    military.recruitSoldier(soldierType, soldierAmount, selectedRegion);
                    validInput = true; // Valid input, break the loop
                } else {
                    System.out.println("Invalid input. Please enter 'infantry' or 'cavalry'.");
                }
            }

            military.spendRecruits(soldierAmount);

            // Display updated stats
            System.out.println("Updated Military Stats:");
            System.out.println("Total Soldiers: " + military.getSoldierCount());
            System.out.println("Available Recruits: " + military.getAvailableRecruits());

            // Display updated soldier counts
            soldierCounts = military.getSoldierCount();
            System.out.println("Updated Soldier Counts:");
            for (Map.Entry<String, Integer> entry : soldierCounts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Ask the player if they want to move soldiers
            System.out.print("Do you want to move soldiers? (yes/no): ");
            String moveChoice = scanner.next();

            if (moveChoice.equalsIgnoreCase("yes")) {
                String soldierTypeToMove = "";
                System.out.println("Select the type of soldier to move (infantry, cavalry): ");
                soldierTypeToMove = scanner.next();
                System.out.println("Regions with soldiers:");
                for (int i = 0; i < regions.size(); i++) {
                    IRegion region = regions.get(i);
                    if (region.getRegionSoldier(soldierTypeToMove) > 0) { // Assuming getSoldierCount returns the total number of soldiers
                        System.out.println((i + 1) + ". " + region.getName() + " - Soldiers: " + region.getRegionSoldier(soldierTypeToMove));
                    }
                }

                // Select the region to move soldiers from
                System.out.print("Select the region from which to move soldiers: ");
                regionIndex = -1;
                validRegion = false;
                while (!validRegion) {
                    try {
                        regionIndex = scanner.nextInt();
                        if (regionIndex > 0 && regionIndex <= regions.size() && regions.get(regionIndex - 1).getRegionSoldier(soldierTypeToMove) > 0) {
                            validRegion = true;
                        } else {
                            System.out.println("Invalid region selection or no soldiers in the selected region.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                    }
                }

                IRegion sourceRegion = regions.get(regionIndex - 1);

                // Select soldier type to move
                validInput = false;
                while (!validInput) {;
                    if (sourceRegion.getRegionSoldier(soldierTypeToMove) > 0) {
                        validInput = true;
                    } else {
                        System.out.println("No soldiers of type " + soldierTypeToMove + " in the selected region.");
                    }
                }

                // Select the target region
                System.out.println("Select the target region to move soldiers to:");
                for (int i = 0; i < regions.size(); i++) {
                    System.out.println((i + 1) + ". " + regions.get(i).getName() + " (Development Level: " + regions.get(i).getDevelopmentLevel() + ")");
                }

                regionIndex = -1;
                validRegion = false;
                while (!validRegion) {
                    try {
                        regionIndex = scanner.nextInt();
                        if (regionIndex > 0 && regionIndex <= regions.size()) {
                            validRegion = true;
                        } else {
                            System.out.println("Invalid region selection. Please enter a number between 1 and " + regions.size() + ".");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                    }
                }

                IRegion targetRegion = regions.get(regionIndex - 1);

                // Move soldiers
                sourceRegion.moveSoldier(soldierTypeToMove, sourceRegion, targetRegion);

                // Display confirmation
                System.out.println("Soldiers moved from " + sourceRegion.getName() + " to " + targetRegion.getName());
            }
        } else {
            System.out.println("Not enough recruits available.");
        }
    }

    public void manageEconomy(Country myCountry) {
        Scanner scanner = new Scanner(System.in);

        BuildingFactory castleFactory = new CastleFactory();
        IBuilding castle = castleFactory.createBuilding();
        castle.addMoney(20); // Adding money to the castle

        BuildingFactory farmFactory = new FarmFactory();
        IBuilding farm = farmFactory.createBuilding();
        farm.addMoney(10); // Adding money to the farm

        BuildingFactory marketFactory = new MarketFactory();
        IBuilding market = marketFactory.createBuilding();

        System.out.println("Manage Economy of a Country:");
        myCountry.getEconomy().calculateIncome(); // Calculating income
        System.out.println("Current Money: " + myCountry.getEconomy().getMoney(myCountry) + " ducats");

        System.out.println("\nManage Buildings of a Country:");
        System.out.println("1. Adding money to the building");
        System.out.println("2. Take money from buildings");
        System.out.println("3. Exit");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Select building to add money:");
                System.out.println("1. Castle");
                System.out.println("2. Farm");
                System.out.println("3. Market");
                int buildingChoice = scanner.nextInt();
                System.out.println("Enter amount to add:");
                int amountToAdd = scanner.nextInt();

                switch (buildingChoice) {
                    case 1:
                        castle.addMoney(amountToAdd);
                        myCountry.getEconomy().spentMoney(amountToAdd);
                        System.out.println(amountToAdd + " ducats added to Castle.");
                        break;
                    case 2:
                        farm.addMoney(amountToAdd);
                        myCountry.getEconomy().spentMoney(amountToAdd);
                        System.out.println(amountToAdd + " ducats added to Farm.");
                        break;
                    case 3:
                        market.addMoney(amountToAdd);
                        myCountry.getEconomy().spentMoney(amountToAdd);
                        System.out.println(amountToAdd + " ducats added to Market.");
                        break;
                    default:
                        System.out.println("Invalid building choice.");
                        break;
                }
                break;

            case 2:
                System.out.println("Select building to take money from:");
                System.out.println("1. Castle");
                System.out.println("2. Farm");
                System.out.println("3. Market");
                buildingChoice = scanner.nextInt();
                System.out.println("Enter amount to take:");
                int amountToTake = scanner.nextInt();

                switch (buildingChoice) {
                    case 1:
                        if (castle.getIncome() >= amountToTake) {
                            castle.addMoney(-amountToTake); // We extract money
                            System.out.println(amountToTake + " ducats taken from Castle.");
                            myCountry.getEconomy().addMoney(amountToTake);
                        } else {
                            System.out.println("Not enough money in Castle.");
                        }
                        break;
                    case 2:
                        if (farm.getIncome() >= amountToTake) {
                            farm.addMoney(-amountToTake); // We extract money
                            System.out.println(amountToTake + " ducats taken from Farm.");
                            myCountry.getEconomy().addMoney(amountToTake);
                        } else {
                            System.out.println("Not enough money in Farm.");
                        }
                        break;
                    case 3:
                        if (market.getIncome() >= amountToTake) {
                            market.addMoney(-amountToTake); // We extract money
                            System.out.println(amountToTake + " ducats taken from Market.");
                            myCountry.getEconomy().addMoney(amountToTake);
                        } else {
                            System.out.println("Not enough money in Market.");
                        }
                        break;
                    default:
                        System.out.println("Invalid building choice.");
                        break;
                }
                break;

            case 3:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
        economy.accept(visitor);
//      military.accept(visitor);
    }

    public CountryType getType() {
        return type;
    }

    public void setType(CountryType type) {
        this.type = type;
    }

    public boolean isEnemy(CountryType type) {
        if (this.type == type) {
            return true;
        }
        return false;
    }
}
