package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static ArrayList<Country> countries; // List of countries in the game
    private Scanner scanner; // Scanner for user input
    private static Country myCountry;
    private int currentCountryIndex = 0;
    private boolean gameOver = false;
    private int turnNumber = 1;
    private TurnState state;

    public Game() {
        this.countries = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeGame(); // Initialize game state
        this.state = new DiplomacyState();  // Start with Diplomacy State
    }

    // Initialize game state and countries
    private void initializeGame() {
        // Initialize leaders
        Leader peterI = createLeader("Peter I", 8, 7, 8);
        Leader yongzheng = createLeader("Yongzheng Emperor", 7, 8, 7);
        Leader tsewang = createLeader("Tsewang Rabtan", 8, 4, 3);
        Leader shahMohammed = createLeader("Shah Mohammed", 5, 6, 7);
        Leader kartAbulkhair = createLeader("Kart-Abulkhair", 4, 7, 5);
        Leader abulkhair = createLeader("Abulkhair", 8, 3, 4);
        Leader sherGaziKhan = createLeader("Shergazi Khan", 5, 5, 6);
        Leader muhammadRahim = createLeader("Muhammad Rahim", 4, 7, 4);
        Leader abdurahimBey = createLeader("Abdurahim-bey", 3, 6, 6);

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
        IMilitary russianMilitary = new Military(8); // Example values
        IMilitary qingMilitary = new Military(7);
        IMilitary zhungarMilitary = new Military(8);
        IMilitary middleJuzMilitary = new Military(5);
        IMilitary ulyJuzMilitary = new Military(4);
        IMilitary kishiJuzMilitary = new Military(8);
        IMilitary xivaMilitary = new Military(5);
        IMilitary bukharaMilitary = new Military(4);
        IMilitary kokandMilitary = new Military(3);

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

    private Leader createLeader(String name, int military, int economy, int diplomacy) {
        return new Leader.Builder()
                .setName(name)
                .setMilitarySkill(military)
                .setEconomySkill(economy)
                .setDiplomacySkill(diplomacy)
                .build();
    }

    // Create regions for each country
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
        return regions;
    }

    private List<IRegion> createZhungarRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(new Region("Ghulja", 3, "Ghulja"));
        regions.add(new Region("Uliastai", 3, "Uliastai"));
        regions.add(new Region("Turfan", 3, "Turfan"));
        return regions;
    }

    private List<IRegion> createMiddleJuzRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(new Region("Pavlodar", 3, "Pavlodar"));
        regions.add(new Region("Semey", 3, "Semey"));
        regions.add(new Region("Ekibastuz", 3, "Ekibastuz"));
        regions.add(new Region("Aqmola", 3, "Aqmola"));
        return regions;
    }

    private List<IRegion> createUlyJuzRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(new Region("Shy", 4, "Shy"));
        regions.add(new Region("Taldykorgan", 4, "Taldykorgan"));
        return regions;
    }

    private List<IRegion> createKishiJuzRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(new Region("Orenburg", 2, "Orenburg"));
        regions.add(new Region("Aktobe", 2, "Aktobe"));
        regions.add(new Region("Atyrau", 2, "Atyrau"));
        return regions;
    }

    private List<IRegion> createXivaRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(new Region("Xiva", 4, "Xiva"));
        regions.add(new Region("Urgench", 4, "Urgench"));
        return regions;
    }

    private List<IRegion> createBukharaRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(new Region("Bukhara", 5, "Bukhara"));
        regions.add(new Region("Samarkand", 5, "Samarkand"));
        return regions;
    }

    private List<IRegion> createKokandRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(new Region("Kokand", 4, "Kokand"));
        regions.add(new Region("Andijan", 4, "Andijan"));
        return regions;
    }
    public void setState(TurnState state) {
        this.state = state;
    }

    public Country getCurrentCountry() {
        return countries.get(currentCountryIndex);
    }

    public boolean isLastCountryInTurn() {
        return currentCountryIndex == countries.size() - 1;
    }

    public void nextTurn() {
        System.out.println("Turn: " + turnNumber + " - " + getCurrentCountry().getName());
        state.manageTurn(this);
        state.nextState(this);// Execute the current phase of the turn
        state.manageTurn(this);
        state.nextState(this);
        state.manageTurn(this);
        state.nextState(this);

        if (state instanceof EndTurnState) {
            startNewTurn();  // Reset for the new turn
        }
    }




    public void startNewTurn() {
        turnNumber++;
        currentCountryIndex = 0;  // Reset to the first country
        state = new DiplomacyState();  // Reset state to the first phase
    }

    public void moveToNextCountry() {
        currentCountryIndex++;
        if (currentCountryIndex < countries.size()) {
            state = new DiplomacyState();  // Start with Diplomacy for the next country
        }
    }

//    public void updateResources() {
//        for (Country country : countries) {
//            country.getEconomy().calculateIncome();
//            country.addRecruits();
//        }
//    }
    private void displayCountries() {
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(i + 1 + ". " + countries.get(i).getName());
        }
    }
    public static Country chooseTargetCountry() {
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

    public void endGame() {
        System.out.println("\nGame Over.");
        System.out.println("Final statistics:");

        // Display stats for each country (like regions controlled, economy, military, etc.)
        for (Country country : countries) {
            System.out.println("------------------------------");
            System.out.println("Country: " + country.getName());
            System.out.println("Regions controlled: " + country.getRegions().size());
        }

        // Optionally, you could calculate and display the winner (if there is one)
        Country winner = determineWinner();
        if (winner != null) {
            System.out.println("\nThe winner of the game is: " + winner.getName() + "!");
        } else {
            System.out.println("\nNo clear winner.");
        }

        System.out.println("\nThank you for playing!");
        gameOver = true;  // Mark the game as over
    }

    public boolean isGameOver() {
        return gameOver;
    }

    // Example method to determine the winner (could be based on regions, economy, etc.)
    private Country determineWinner() {
        Country winner = null;
        int maxRegions = 0;

        for (Country country : countries) {
            if (country.getRegions().size() > maxRegions) {
                maxRegions = country.getRegions().size();
                winner = country;
            }
        }

        return winner;
    }
}
