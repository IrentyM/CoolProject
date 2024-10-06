package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private ArrayList<Country> countries; // List of countries in the game
    private Scanner scanner; // Scanner for user input
    private Country myCountry;

    public Game() {
        this.countries = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeGame(); // Initialize game state
    }

    // Initialize game state and countries
    private void initializeGame() {
        // Initialize leader
        Leader peterI = new Leader.Builder()
                .setName("Peter I")
                .setMilitarySkill(8)
                .setEconomySkill(7)
                .setDiplomacySkill(8)
                .build();

        Leader yongzheng = new Leader.Builder()
                .setName("Yongzheng Emperor")
                .setMilitarySkill(7)
                .setEconomySkill(8)
                .setDiplomacySkill(7)
                .build();

        Leader tsewang = new Leader.Builder()
                .setName("Tsewang Rabtan")
                .setMilitarySkill(8)
                .setEconomySkill(4)
                .setDiplomacySkill(3)
                .build();

        Leader shahMohammed = new Leader.Builder()
                .setName("Shah Mohammed")
                .setMilitarySkill(5)
                .setEconomySkill(6)
                .setDiplomacySkill(7)
                .build();

        Leader kartAbulkhair = new Leader.Builder()
                .setName("Kart-Abulkhair")
                .setMilitarySkill(4)
                .setEconomySkill(7)
                .setDiplomacySkill(5)
                .build();

        Leader abulkhair = new Leader.Builder()
                .setName("Abulkhair")
                .setMilitarySkill(8)
                .setEconomySkill(3)
                .setDiplomacySkill(4)
                .build();

        Leader sherGaziKhan = new Leader.Builder()
                .setName("Shergazi Khan")
                .setMilitarySkill(5)
                .setEconomySkill(5)
                .setDiplomacySkill(6)
                .build();

        Leader muhammadRahim = new Leader.Builder()
                .setName("Muhammad Rahim")
                .setMilitarySkill(4)
                .setEconomySkill(7)
                .setDiplomacySkill(4)
                .build();

        Leader abdurahimBey = new Leader.Builder()
                .setName("Abdurahim-bey")
                .setMilitarySkill(3)
                .setEconomySkill(6)
                .setDiplomacySkill(6)
                .build();


        // Initialize regions for each country
            List<IRegion> russianRegions = createRussianRegions();
            List<IRegion> qingRegions = createQingRegions();
            List<IRegion> zhungarRegions = createZhungarRegions();
            List<IRegion> middleJuzRegions = createMiddleJuzRegions();
            List<IRegion> ulyJuzRegions = createUlyJuzRegions();
            List<IRegion> kishiJuzRegions = createKishiJuzRegions();
            List<IRegion> xivaRegions = createXivaRegions();
            List<IRegion> bukharaRegions = createBukharaRegions();
            List<IRegion> kokandRegions = createKokandRegions();

            // Initialize economies
            IEconomy russianEconomy = new Economy(1000, russianRegions, peterI);
            IEconomy qingEconomy = new Economy(1200, qingRegions, yongzheng);
            IEconomy zhungarEconomy = new Economy(800, zhungarRegions, tsewang);
            IEconomy middleJuzEconomy = new Economy(500, middleJuzRegions, shahMohammed);
            IEconomy ulyJuzEconomy = new Economy(400, ulyJuzRegions, kartAbulkhair);
            IEconomy kishiJuzEconomy = new Economy(300, kishiJuzRegions, abulkhair);
            IEconomy xivaEconomy = new Economy(600, xivaRegions, sherGaziKhan);
            IEconomy bukharaEconomy = new Economy(550, bukharaRegions, muhammadRahim);
            IEconomy kokandEconomy = new Economy(500, kokandRegions, abdurahimBey);

            // Initialize militaries
            IMilitary russianMilitary = new Military(500, 8); // Example values
            IMilitary qingMilitary = new Military(600, 7);
            IMilitary zhungarMilitary = new Military(300, 8);
            IMilitary middleJuzMilitary = new Military(250, 5);
            IMilitary ulyJuzMilitary = new Military(200, 4);
            IMilitary kishiJuzMilitary = new Military(150, 8);
            IMilitary xivaMilitary = new Military(100, 5);
            IMilitary bukharaMilitary = new Military(80, 4);
            IMilitary kokandMilitary = new Military(90, 3);
            // Initialize countries
            countries.add(Country.createCountry("Russian Empire", peterI, russianEconomy, russianMilitary, russianRegions));
            countries.add(Country.createCountry("Qing Dynasty", yongzheng, qingEconomy, qingMilitary, qingRegions));
            countries.add(Country.createCountry("Zhungar Khanate", tsewang, zhungarEconomy, zhungarMilitary, zhungarRegions));
            countries.add(Country.createCountry("Middle Juz", shahMohammed, middleJuzEconomy, middleJuzMilitary, middleJuzRegions));
            countries.add(Country.createCountry("Uly Juz", kartAbulkhair, ulyJuzEconomy, ulyJuzMilitary, ulyJuzRegions));
            countries.add(Country.createCountry("Kishi Juz", abulkhair, kishiJuzEconomy, kishiJuzMilitary, kishiJuzRegions));
            countries.add(Country.createCountry("Xiva", sherGaziKhan, xivaEconomy, xivaMilitary, xivaRegions));
            countries.add(Country.createCountry("Bukhara", muhammadRahim, bukharaEconomy, bukharaMilitary, bukharaRegions));
            countries.add(Country.createCountry("Kokand", abdurahimBey, kokandEconomy, kokandMilitary, kokandRegions));
        }

        // Create Russian regions
        private List<IRegion> createRussianRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Moscow", 3, "Moscow"));
            regions.add(new Region("St. Petersburg", 3, "St. Petersburg"));
            regions.add(new Region("Novgorod", 2, "Novgorod"));
            regions.add(new Region("Kazan", 3, "Kazan"));
            regions.add(new Region("Siberia", 2, "Siberia"));
            regions.add(new Region("Astrakhan", 3, "Astrakhan"));
            regions.add(new Region("Caucasus", 3, "Caucasus"));
            regions.add(new Region("Tver", 3, "Tver"));
            regions.add(new Region("Smolensk", 2, "Smolensk"));
            regions.add(new Region("Vladimir", 2, "Vladimir"));
            regions.add(new Region("Voronezh", 3, "Voronezh"));
            regions.add(new Region("Tula", 2, "Tula"));
            regions.add(new Region("Rostov", 2, "Rostov"));
            regions.add(new Region("Saratov", 3, "Saratov"));
            regions.add(new Region("Krasnoyarsk", 2, "Krasnoyarsk"));
            regions.add(new Region("Irkutsk", 2, "Irkutsk"));
            regions.add(new Region("Kamchatka", 1, "Kamchatka"));
            regions.add(new Region("Chelyabinsk", 2, "Chelyabinsk"));
            regions.add(new Region("Perm", 2, "Perm"));
            regions.add(new Region("Kurgan", 2, "Kurgan"));
            regions.add(new Region("Orenburg", 3, "Orenburg"));
            return regions;
        }

        // Create Qing regions
        private List<IRegion> createQingRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Beijing", 4, "Beijing"));
            regions.add(new Region("Shenyang", 4, "Shenyang"));
            regions.add(new Region("Xi'an", 4, "Xi'an"));
            regions.add(new Region("Hangzhou", 4, "Hangzhou"));
            regions.add(new Region("Nanjing", 4, "Nanjing"));
            regions.add(new Region("Chengdu", 4, "Chengdu"));
            regions.add(new Region("Lanzhou", 3, "Lanzhou"));
            regions.add(new Region("Urumqi", 3, "Urumqi"));
            regions.add(new Region("Urumqi", 3, "Urumqi"));
            regions.add(new Region("Urumqi", 3, "Urumqi"));
            regions.add(new Region("Urumqi", 3, "Urumqi"));
            regions.add(new Region("Urumqi", 3, "Urumqi"));
            regions.add(new Region("Urumqi", 3, "Urumqi"));
            regions.add(new Region("Urumqi", 3, "Urumqi"));
            regions.add(new Region("Urumqi", 3, "Urumqi"));
            return regions;
        }

        // Create Zhungar regions
        private List<IRegion> createZhungarRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Ghulja", 3, "Ghulja"));
            regions.add(new Region("Uliastai", 3, "Uliastai"));
            regions.add(new Region("Turfan", 3, "Turfan"));

            regions.add(new Region("Kochkor-Ata", 2, "Kochkor-Ata"));
            regions.add(new Region("Kochkor-Ata", 2, "Kochkor-Ata"));
            regions.add(new Region("Kochkor-Ata", 2, "Kochkor-Ata"));
            regions.add(new Region("Kochkor-Ata", 2, "Kochkor-Ata"));
            regions.add(new Region("Kochkor-Ata", 2, "Kochkor-Ata"));
            regions.add(new Region("Kochkor-Ata", 2, "Kochkor-Ata"));
            regions.add(new Region("Kochkor-Ata", 2, "Kochkor-Ata"));

            Region Ata = new Region("Kochkor-Ata", 2, "Kochkor-Ata");
            Region sameAta = Ata.clone();
            regions.add(Ata);
            regions.add(sameAta);
            return regions;
        }

        // Create Middle Juz regions
        private List<IRegion> createMiddleJuzRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Pavlodar", 3, "Pavlodar"));
            regions.add(new Region("Semey", 3, "Semey"));
            regions.add(new Region("Ekibastuz", 3, "Ekibastuz"));
            regions.add(new Region("Aqmola", 3, "Aqmola"));
            regions.add(new Region("Aqmola", 3, "Aqmola"));
            regions.add(new Region("Aqmola", 3, "Aqmola"));
            regions.add(new Region("Aqmola", 3, "Aqmola"));

            // Add more regions as needed
            return regions;
        }

        // Create Uly Juz regions
        private List<IRegion> createUlyJuzRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Shy", 4, "Shy"));
            regions.add(new Region("Taldykorgan", 4, "Taldykorgan"));
            regions.add(new Region("Taldykorgan", 4, "Taldykorgan"));
            regions.add(new Region("Taldykorgan", 4, "Taldykorgan"));
            // Add more regions as needed
            return regions;
        }

        // Create Kishi Juz regions
        private List<IRegion> createKishiJuzRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Orenburg", 2, "Orenburg"));
            regions.add(new Region("Orenburg", 2, "Orenburg"));
            regions.add(new Region("Orenburg", 2, "Orenburg"));
            regions.add(new Region("Orenburg", 2, "Orenburg"));
            regions.add(new Region("Orenburg", 2, "Orenburg"));
            // Add more regions as needed
            return regions;
        }

        // Create Xiva regions
        private List<IRegion> createXivaRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Xiva", 4, "Xiva"));
            regions.add(new Region("Xiva", 4, "Xiva"));
            regions.add(new Region("Xiva", 4, "Xiva"));
            // Add more regions as needed
            return regions;
        }

        // Create Bukhara regions
        private List<IRegion> createBukharaRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Bukhara", 5, "Bukhara"));
            regions.add(new Region("Bukhara", 5, "Bukhara"));

            // Add more regions as needed
            return regions;
        }

        // Create Kokand regions
        private List<IRegion> createKokandRegions() {
            List<IRegion> regions = new ArrayList<>();
            regions.add(new Region("Kokand", 4, "Kokand"));
            regions.add(new Region("Kokand", 4, "Kokand"));
            regions.add(new Region("Kokand", 4, "Kokand"));

            // Add more regions as needed
            return regions;

    }
    private Country chooseCountry(ArrayList<Country> countries) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your country:");
        displayCountries();
        int choice = scanner.nextInt();
        return countries.get(choice - 1);
    }
    public void start() {
        // Choose a country
        myCountry = chooseCountry(countries);

        // Display chosen country
        System.out.println("You have chosen to play as: " + myCountry.getName());

        // Show the menu
        displayMenu();
    }
    // Start the game loop

    private Country chooseTargetCountry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available countries for diplomatic interaction:");

        // Exclude the chosen country from the diplomatic target list
        ArrayList<Country> availableCountries = new ArrayList<>(countries);
        availableCountries.remove(myCountry);

        for (int i = 0; i < availableCountries.size(); i++) {
            System.out.println((i + 1) + ". " + availableCountries.get(i).getName());
        }

        int choice = scanner.nextInt();
        return availableCountries.get(choice - 1); // Return the chosen country for diplomacy
    }
    // Display main menu options
    private void displayMenu() {

        boolean running = true;
        int choice;
        while (running) {
            System.out.println("=== Game Menu ===");
            System.out.println("1. Manage Economy");
            System.out.println("2. Manage Military");
            System.out.println("3. Manage Diplomacy");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageEconomy(myCountry);
                    break;
                case 2:
                    manageMilitary(myCountry);
                    break;
                case 3:
                    System.out.println("Choose a country to interact with diplomatically:");
                    Country targetCountry = chooseTargetCountry();
                    manageDiplomacy(myCountry,targetCountry);
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

    // Get user choice from input

    private void manageEconomy(Country myCountry) {
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

    // Manage military for a specific country
    private void manageMilitary(Country myCountry) {
        System.out.println("Manage Military of a Country:");
        System.out.print("Enter number of recruits to add: ");
        int recruits = scanner.nextInt();
        myCountry.getMilitary().recruitSoldiers(myCountry,recruits); // Recruit soldiers
        System.out.println("Total Soldiers: " + myCountry.getMilitary().getSoldiers());
    }

    // Manage diplomacy for a specific country
    private void manageDiplomacy(Country myCountry, Country targetCountry) {
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

    // Display available countries
    private void displayCountries() {
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(i + 1 + ". " + countries.get(i).getName());
        }
    }

    // Get user choice for a country
    private int getUserCountryChoice() {
        return scanner.nextInt();
    }
}
