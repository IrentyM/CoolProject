package models;

import java.util.ArrayList;
import java.util.List;

public class RegionFactory {
    private static Region russianRegionPrototype;
    private static Region qingRegionPrototype;
    private static Region zhungarRegionPrototype;
    private static Region middleJuzRegionPrototype;
    private static Region ulyJuzRegionPrototype;
    private static Region kishiJuzRegionPrototype;
    private static Region xivaRegionPrototype;
    private static Region bukharaRegionPrototype;
    private static Region kokandRegionPrototype;

    static {
        // Initializing the region prototypes with base values
        russianRegionPrototype = new Region("Generic Russian Region", 3, "Generic Capital");
        qingRegionPrototype = new Region("Generic Qing Region", 4, "Generic Capital");
        zhungarRegionPrototype = new Region("Generic Zhungar Region", 3, "Generic Capital");
        middleJuzRegionPrototype = new Region("Generic Middle Juz Region", 3, "Generic Capital");
        ulyJuzRegionPrototype = new Region("Generic Uly Juz Region", 4, "Generic Capital");
        kishiJuzRegionPrototype = new Region("Generic Kishi Juz Region", 2, "Generic Capital");
        xivaRegionPrototype = new Region("Xiva", 4, "Xiva");
        bukharaRegionPrototype = new Region("Bukhara", 5, "Bukhara",);
        kokandRegionPrototype = new Region("Kokand", 4, "Kokand");
    }

    // Create Russian regions
    public List<IRegion> createRussianRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneRussianRegion("Moscow"));
        regions.add(cloneRussianRegion("St. Petersburg"));
        regions.add(cloneRussianRegion("Novgorod"));
        regions.add(cloneRussianRegion("Kazan"));
        regions.add(cloneRussianRegion("Siberia"));
        regions.add(cloneRussianRegion("Astrakhan"));
        regions.add(cloneRussianRegion("Caucasus"));
        regions.add(cloneRussianRegion("Tver"));
        regions.add(cloneRussianRegion("Smolensk"));
        regions.add(cloneRussianRegion("Vladimir"));
        regions.add(cloneRussianRegion("Voronezh"));
        regions.add(cloneRussianRegion("Tula"));
        regions.add(cloneRussianRegion("Rostov"));
        regions.add(cloneRussianRegion("Saratov"));
        regions.add(cloneRussianRegion("Krasnoyarsk"));
        regions.add(cloneRussianRegion("Irkutsk"));
        regions.add(cloneRussianRegion("Kamchatka"));
        regions.add(cloneRussianRegion("Chelyabinsk"));
        regions.add(cloneRussianRegion("Perm"));
        regions.add(cloneRussianRegion("Kurgan"));
        regions.add(cloneRussianRegion("Orenburg"));
        return regions;
    }

    private IRegion cloneRussianRegion(String name) {
        Region region = russianRegionPrototype.clone();
        region.setName(name); // Assuming you have a setter for name
        return region;
    }

    // Create Qing regions
    public List<IRegion> createQingRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneQingRegion("Beijing"));
        regions.add(cloneQingRegion("Shenyang"));
        regions.add(cloneQingRegion("Xi'an"));
        regions.add(cloneQingRegion("Hangzhou"));
        regions.add(cloneQingRegion("Nanjing"));
        regions.add(cloneQingRegion("Chengdu"));
        regions.add(cloneQingRegion("Lanzhou"));
        regions.add(cloneQingRegion("Urumqi"));
        return regions;
    }

    private IRegion cloneQingRegion(String name) {
        Region region = qingRegionPrototype.clone();
        region.setName(name);
        return region;
    }

    // Create Zhungar regions
    public List<IRegion> createZhungarRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneZhungarRegion("Ghulja"));
        regions.add(cloneZhungarRegion("Uliastai"));
        regions.add(cloneZhungarRegion("Turfan"));
        regions.add(cloneZhungarRegion("Kochkor-Ata"));
        return regions;
    }

    private IRegion cloneZhungarRegion(String name) {
        Region region = zhungarRegionPrototype.clone();
        region.setName(name);
        return region;
    }

    // Create Middle Juz regions
    public List<IRegion> createMiddleJuzRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneMiddleJuzRegion("Pavlodar"));
        regions.add(cloneMiddleJuzRegion("Semey"));
        regions.add(cloneMiddleJuzRegion("Ekibastuz"));
        regions.add(cloneMiddleJuzRegion("Aqmola"));
        return regions;
    }

    private IRegion cloneMiddleJuzRegion(String name) {
        Region region = middleJuzRegionPrototype.clone();
        region.setName(name);
        return region;
    }

    // Create Uly Juz regions
    public List<IRegion> createUlyJuzRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneUlyJuzRegion("Shy"));
        regions.add(cloneUlyJuzRegion("Taldykorgan"));
        return regions;
    }

    private IRegion cloneUlyJuzRegion(String name) {
        Region region = ulyJuzRegionPrototype.clone();
        region.setName(name);
        return region;
    }

    // Create Kishi Juz regions
    public List<IRegion> createKishiJuzRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneKishiJuzRegion("Orenburg"));
        return regions;
    }

    private IRegion cloneKishiJuzRegion(String name) {
        Region region = kishiJuzRegionPrototype.clone();
        region.setName(name);
        return region;
    }

    // Create Xiva regions
    public List<IRegion> createXivaRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneXivaRegion("Xiva"));
        return regions;
    }

    private IRegion cloneXivaRegion(String name) {
        Region region = xivaRegionPrototype.clone();
        region.setName(name);
        return region;
    }

    // Create Bukhara regions
    public List<IRegion> createBukharaRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneBukharaRegion("Bukhara"));
        return regions;
    }

    private IRegion cloneBukharaRegion(String name) {
        Region region = bukharaRegionPrototype.clone();
        region.setName(name);
        return region;
    }

    // Create Kokand regions
    public List<IRegion> createKokandRegions() {
        List<IRegion> regions = new ArrayList<>();
        regions.add(cloneKokandRegion("Kokand"));
        return regions;
    }

    private IRegion cloneKokandRegion(String name) {
        Region region = kokandRegionPrototype.clone();
        region.setName(name);
        return region;
    }
}
