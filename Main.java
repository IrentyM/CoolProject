import java.util.Scanner;
import java.util.ArrayList;
import models.Leader;
import models.Country;
import models.Diplomacy;
import models.Economy;
import models.Military;
import models.Region;

public class Main {
    public static void main(String[] args) {
        // Create Leaders
        Leader peterTheGreat = new Leader("Peter the Great", 8, 7, 8);
        Leader yongzheng = new Leader("Yongzheng Emperor", 7, 8, 7);
        Leader tsewangRabtan = new Leader("Tsewang Rabtan", 8, 4, 3);
        Leader sherGaziKhan = new Leader("Shergazi Khan", 5, 5, 6);
        Leader muhammadRahim = new Leader("Muhammad Rahim", 4, 7, 4);
        Leader abdurahimBey = new Leader("Abdurahim-bey", 3, 6, 6);
        Leader shahMohammed = new Leader("Shah Mohammed", 5, 6, 7);
        Leader kartAbulkhair = new Leader("Kart-Abulkhair", 4, 7, 5);
        Leader abulkhair = new Leader("Abulkhair", 8, 3, 4);

        // Create Countries with Diplomacy, Economy, Military
        Country russia = new Country("Russian Empire",
                new Diplomacy(3 + 8), new Economy(300, 3 + 7), new Military(1000,3+8), peterTheGreat, "Moscow");
        Country qing = new Country("Qing Dynasty",
                new Diplomacy(3 + 7), new Economy(400,3 + 8), new Military(1100,3 + 7), yongzheng, "Beijing");
        Country zhungar = new Country("Zhungar Khanate",
                new Diplomacy(3 + 3), new Economy(100,3 + 4), new Military(700,3 + 8), tsewangRabtan, "Ghulja");
        Country xiva = new Country("Xiva Sultanate",
                new Diplomacy(3 + 6), new Economy(100,3 + 5), new Military(200,3 + 5), sherGaziKhan, "Xiva");
        Country bukhara = new Country("Bukhara Sultanate",
                new Diplomacy(3 + 4), new Economy(150,3 + 7), new Military(250,3 + 4), muhammadRahim, "Bukhara");
        Country kokand = new Country("Kokand Sultanate",
                new Diplomacy(3 + 6), new Economy(100,3 + 6), new Military(200,3 + 3), abdurahimBey, "Kokand");
        Country middleJuz = new Country("Middle Juz",
                new Diplomacy(3 + 7), new Economy(100,3 + 6), new Military(450,3 + 5), shahMohammed, "Pavlodar");
        Country ulyJuz = new Country("Uly Juz",
                new Diplomacy(3 + 5), new Economy(150,3 + 7), new Military(300,3 + 4), kartAbulkhair, "Shy");
        Country kishiJuz = new Country("Kishi Juz",
                new Diplomacy(3 + 4), new Economy(200,3 + 3), new Military(400,3 + 8), abulkhair, "Orenburg");

        // Add regions to each country with specific development levels
        addRegions(russia, new String[][]{
                {"Moscow", "6"},
                {"Saint Petersburg", "5"},
                {"Smolensk", "3"},
                {"Kazan", "4"},
                {"Novgorod", "3"},
                {"Tula", "3"},
                {"Ryazan", "2"},
                {"Kursk", "2"},
                {"Voronezh", "3"},
                {"Nizhny Novgorod", "4"},
                {"Saratov", "2"},
                {"Samara", "3"},
                {"Perm", "2"},
                {"Yaroslavl", "3"},
                {"Vladimir", "3"},
                {"Tver", "2"},
                {"Vologda", "1"},
                {"Arkhangelsk", "1"},
                {"Ufa", "2"},
                {"Tobolsk", "1"}
        });

        addRegions(qing, new String[][]{
                {"Beijing", "7"},
                {"Tianjin", "5"},
                {"Nanjing", "6"},
                {"Hangzhou", "6"},
                {"Guangzhou", "5"},
                {"Wuhan", "4"},
                {"Chongqing", "3"},
                {"Chengdu", "4"},
                {"Xian", "3"},
                {"Shenyang", "4"},
                {"Harbin", "3"},
                {"Kunming", "2"},
                {"Fuzhou", "3"},
                {"Nanning", "2"},
                {"Jinan", "3"}
        });

        addRegions(zhungar, new String[][]{
                {"Ghulja", "4"},
                {"Tarbagatai", "3"},
                {"Urumqi", "3"},
                {"Turpan", "2"},
                {"Kashgar", "3"},
                {"Khotan", "2"},
                {"Yarkand", "2"},
                {"Aksu", "3"},
                {"Karakorum", "2"},
                {"Altay", "2"}
        });

        addRegions(xiva, new String[][]{
                {"Xiva", "5"},
                {"Urgench", "4"},
                {"Kunya-Urgench", "3"},
                {"Khanka", "3"}
        });

        addRegions(bukhara, new String[][]{
                {"Bukhara", "6"},
                {"Kagan", "5"},
                {"Gijduvan", "4"}
        });

        addRegions(kokand, new String[][]{
                {"Kokand", "5"},
                {"Namangan", "4"},
                {"Andijan", "3"}
        });

        addRegions(middleJuz, new String[][]{
                {"Pavlodar", "4"},
                {"Ekibastuz", "3"},
                {"Karaganda", "3"},
                {"Kokshetau", "2"},
                {"Zhezkazgan", "3"},
                {"Semey", "2"},
                {"Temirtau", "3"}
        });

        addRegions(ulyJuz, new String[][]{
                {"Shy", "5"},
                {"Taraz", "4"},
                {"Taldykorgan", "4"},
                {"Almaty", "4"}
        });

        addRegions(kishiJuz, new String[][]{
                {"Orenburg", "3"},
                {"Atyrau", "2"},
                {"Aktobe", "1"},
                {"Uralsk", "2"},
                {"Mangystau", "2"}
        });

        // Add all countries to a list
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(russia);
        countries.add(qing);
        countries.add(zhungar);
        countries.add(xiva);
        countries.add(bukhara);
        countries.add(kokand);
        countries.add(middleJuz);
        countries.add(ulyJuz);
        countries.add(kishiJuz);

        // Choose a country
        Country chosenCountry = chooseCountry(countries);

        // Display chosen country
        System.out.println("You have chosen to play as: " + chosenCountry.getName());

        // Menu to show more information
        showMenu(chosenCountry);
    }

    // Method to add regions to a country with specific development levels
    private static void addRegions(Country country, String[][] regionData) {
        for (String[] regionInfo : regionData) {
            String regionName = regionInfo[0];
            int developmentLevel = Integer.parseInt(regionInfo[1]);
            country.addRegion(new Region(regionName, developmentLevel, regionName)); // Capital is same as region
        }
    }

    // Method to choose a country
    private static Country chooseCountry(ArrayList<Country> countries) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your country:");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println((i + 1) + ". " + countries.get(i).getName());
        }
        int choice = scanner.nextInt();
        return countries.get(choice - 1);
    }

    // Method to display menu options
    private static void showMenu(Country country) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose an option for more information:");
            System.out.println("1. Leader Information");
            System.out.println("2. Regions Information");
            System.out.println("3. Diplomacy");
            System.out.println("4. Economy");
            System.out.println("5. Military");
            System.out.println("6. Country Information");
            System.out.println("7. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayLeaderInfo(country.getLeader()); // Changed logic to call leader directly from country
                    break;
                case 2:
                    displayRegionsInfo(country);
                    break;
                case 3:
                    displayDiplomacyInfo(country.getDiplomacy());
                    break;
                case 4:
                    displayEconomyInfo(country.getEconomy());
                    break;
                case 5:
                    displayMilitaryInfo(country.getMilitary());
                    break;
                case 6:
                    displayCountryInfo(country,country.getLeader());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    // Method to display leader information
    private static void displayLeaderInfo(Leader leader) {
        System.out.println("\nLeader Name: " + leader.getName());
        System.out.println("Military Skill: " + leader.getMilitarySkill());
        System.out.println("Economic Skill: " + leader.getEconomySkill());
        System.out.println("Diplomatic Skill: " + leader.getDiplomacySkill());
    }
    private static void displayCountryInfo(Country country,Leader leader) {
        System.out.println("\nCountry Name: " + country.getName());
        System.out.println("\nCountry Leader: " + leader.getName());
        System.out.println("\nCountry Capital: " + country.getCapital());
        System.out.println("Military Skill: " + country.getFinalMilitarySkill());
        System.out.println("Economic Skill: " + country.getFinalEconomySkill());
        System.out.println("Diplomatic Skill: " + country.getFinalDiplomacySkill());
    }


    // Method to display regions information
    private static void displayRegionsInfo(Country country) {
        System.out.println("\nRegions in " + country.getName() + ":");
        for (Region region : country.getRegions()) {
            System.out.println("Region: " + region.getName() + ", Capital: " + country.getCapital() + ", Development Level: " + region.getDevelopmentLevel());
        }
    }

    // Method to display diplomacy information
    private static void displayDiplomacyInfo(Diplomacy diplomacy) {
        System.out.println("\nDiplomacy Points: " + diplomacy.getDiplomacySkill());
    }

    // Method to display economy information
    private static void displayEconomyInfo(Economy economy) {
        System.out.println("\nEconomic Points: " + economy.getEconomicPoints());
        System.out.println("Money: " + economy.getMoney() + "ducats.");
    }

    // Method to display military information
    private static void displayMilitaryInfo(Military military) {
        System.out.println("\nMilitary Points: " + military.getMilitaryPointsPoints());
        System.out.println("Available Recruits " + military.getAvailableRecruits());
        System.out.println("Soldiers: " + military.getSoldiers());
    }
}
