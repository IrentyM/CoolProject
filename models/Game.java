package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Country> countries; // List of countries in the game
    private Scanner scanner; // Scanner for user input

    public Game() {
        this.countries = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeGame(); // Initialize game state
    }

    // Initialize game state and countries
    private void initializeGame() {
        // Initialize leaders
        ILeader peterI = new Leader("Peter I", 8, 7, 8);
        ILeader yongzheng = new Leader("Yongzheng Emperor", 7, 8, 7);
        ILeader tsewang = new Leader("Tsewang Rabtan", 8, 4, 3);

        // Initialize regions
        List<IRegion> russianRegions = new ArrayList<>();
        russianRegions.add(new Region("Moscow", 3, "Moscow"));

        List<IRegion> qingRegions = new ArrayList<>();
        qingRegions.add(new Region("Beijing", 4, "Beijing"));

        List<IRegion> zhungarRegions = new ArrayList<>();
        zhungarRegions.add(new Region("Ghulja", 3, "Ghulja"));

        // Initialize economies
        IEconomy russianEconomy = new Economy(1000, russianRegions, peterI);
        IEconomy qingEconomy = new Economy(1200, qingRegions, yongzheng);
        IEconomy zhungarEconomy = new Economy(800, zhungarRegions, tsewang);

        // Initialize militaries
        IMilitary russianMilitary = new Military(500, 8); // Example values
        IMilitary qingMilitary = new Military(600, 7);
        IMilitary zhungarMilitary = new Military(300, 8);

        // Initialize countries
        countries.add(new Country("Russian Empire", peterI, russianEconomy, russianMilitary, russianRegions));
        countries.add(new Country("Qing Dynasty", yongzheng, qingEconomy, qingMilitary, qingRegions));
        countries.add(new Country("Zhungar Khanate", tsewang, zhungarEconomy, zhungarMilitary, zhungarRegions));
    }

    // Start the game loop
    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    manageEconomy();
                    break;
                case 2:
                    manageMilitary();
                    break;
                case 3:
                    manageDiplomacy();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the game. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display main menu options
    private void displayMenu() {
        System.out.println("=== Game Menu ===");
        System.out.println("1. Manage Economy");
        System.out.println("2. Manage Military");
        System.out.println("3. Manage Diplomacy");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // Get user choice from input
    private int getUserChoice() {
        return scanner.nextInt();
    }

    // Manage economy for a specific country
    private void manageEconomy() {
        System.out.println("Manage Economy - Select a Country:");
        displayCountries();
        int countryIndex = getUserCountryChoice();
        Country selectedCountry = countries.get(countryIndex);
        selectedCountry.getEconomy().calculateIncome(); // Calculate income
        System.out.println("Current Money: " + selectedCountry.getEconomy().getMoney() + " ducats");
    }

    // Manage military for a specific country
    private void manageMilitary() {
        System.out.println("Manage Military - Select a Country:");
        displayCountries();
        int countryIndex = getUserCountryChoice();
        Country selectedCountry = countries.get(countryIndex);
        System.out.print("Enter number of recruits to add: ");
        int recruits = scanner.nextInt();
        selectedCountry.getMilitary().recruitSoldiers(recruits); // Recruit soldiers
        System.out.println("Total Soldiers: " + selectedCountry.getMilitary().getSoldiers());
    }

    // Manage diplomacy for a specific country
    private void manageDiplomacy() {
        System.out.println("Manage Diplomacy - Select a Country:");
        displayCountries();
        int countryIndex = getUserCountryChoice();
        Country selectedCountry = countries.get(countryIndex);
        System.out.println("1. Form Alliance");
        System.out.println("2. Form Non-Aggression Pact");
        System.out.println("0. Back to Menu");
        int actionChoice = scanner.nextInt();

        if (actionChoice == 1) {
            System.out.println("Select target country for Alliance:");
            displayCountries();
            int targetIndex = getUserCountryChoice();
            Country targetCountry = countries.get(targetIndex);
            selectedCountry.getDiplomacy().formAlliance(targetCountry); // Form alliance
        } else if (actionChoice == 2) {
            System.out.println("Select target country for Non-Aggression Pact:");
            displayCountries();
            int targetIndex = getUserCountryChoice();
            Country targetCountry = countries.get(targetIndex);
            selectedCountry.getDiplomacy().formNonAggressionPact(targetCountry); // Form pact
        }
    }

    // Display available countries
    private void displayCountries() {
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(i + ". " + countries.get(i).getName());
        }
    }

    // Get user choice for a country
    private int getUserCountryChoice() {
        return scanner.nextInt();
    }
}
