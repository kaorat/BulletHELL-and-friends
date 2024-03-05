package Utils;

import java.util.ArrayList;


public class Config {

    // Parts Drop
    public static final double PARTS_DROP_BASE = 25;

    // Calcium Gene
    public static final double CALC_G_ENEMY_HP_BASE = 100;
    public static final double CALC_G_ENEMY_HP_UPGRADE = 15;
    public static final double CALC_G_PARTS_DROP_UPGRADE = 8;

    // Agility Gene
    public static final double AGILITY_ENEMY_FIRE_RATE_BASE = 2.4;
    public static final double AGILITY_ENEMY_FIRE_RATE_UPGRADE = 0.7;
    public static final double AGILITY_PARTS_DROP_UPGRADE = 11;

    // Lethal Mutation
    public static final double LETHAL_BULLET_SPEED_BASE = 1.2;
    public static final double LETHAL_BULLET_SPEED_UPGRADE = 0.25;
    public static final double LETHAL_PARTS_DROP_UPGRADE = 16;

    // Fuzzy Mutation
    public static final double FUZZY_BULLET_QUANTITY_BASE = 8;
    public static final double FUZZY_BULLET_QUANTITY_UPGRADE = 1;
    public static final double FUZZY_PARTS_DROP_UPGRADE = 16;

    // Elongation
    public static final double ELONGATION_BULLET_LENGTH_BASE = 2;
    public static final double ELONGATION_BULLET_LENGTH_UPGRADE = 1;
    public static final double ELONGATION_PARTS_DROP_UPGRADE = 8;

    // Genetic Drift
    public static final double GENETIC_CHANCE_OBTAIN_SOUL_BASE = 10;
    public static final double GENETIC_CHANCE_OBTAIN_SOUL_UPGRADE = 5;

    // Fast Reproduction
    public static final double FAST_SPAWN_TIME_BASE = 2.0;
    public static final double FAST_SPAWN_TIME_UPGRADE = -0.05;


    // ArrayLists to store base values, upgrade values, and drop upgrade values

    public static ArrayList<Double> baseValues = new ArrayList<Double>();
    public static ArrayList<Double> upgradeValues = new ArrayList<Double>();
    public static ArrayList<Double> dropUpgradeValues = new ArrayList<Double>();

    // Initialize base, upgrade, and drop upgrade values
    static {
        // Calcium Gene
        baseValues.add(CALC_G_ENEMY_HP_BASE);
        upgradeValues.add(CALC_G_ENEMY_HP_UPGRADE);
        dropUpgradeValues.add(CALC_G_PARTS_DROP_UPGRADE);

        // Agility Gene
        baseValues.add(AGILITY_ENEMY_FIRE_RATE_BASE);
        upgradeValues.add(AGILITY_ENEMY_FIRE_RATE_UPGRADE);
        dropUpgradeValues.add(AGILITY_PARTS_DROP_UPGRADE);

        // Lethal Mutation
        baseValues.add(LETHAL_BULLET_SPEED_BASE);
        upgradeValues.add(LETHAL_BULLET_SPEED_UPGRADE);
        dropUpgradeValues.add(LETHAL_PARTS_DROP_UPGRADE);

        // Fuzzy Mutation
        baseValues.add(FUZZY_BULLET_QUANTITY_BASE);
        upgradeValues.add(FUZZY_BULLET_QUANTITY_UPGRADE);
        dropUpgradeValues.add(FUZZY_PARTS_DROP_UPGRADE);

        // Elongation
        baseValues.add(ELONGATION_BULLET_LENGTH_BASE);
        upgradeValues.add(ELONGATION_BULLET_LENGTH_UPGRADE);
        dropUpgradeValues.add(ELONGATION_PARTS_DROP_UPGRADE);

        // Genetic Drift (Only base and upgrade values, no drop upgrade)
        baseValues.add(GENETIC_CHANCE_OBTAIN_SOUL_BASE);
        upgradeValues.add(GENETIC_CHANCE_OBTAIN_SOUL_UPGRADE);

        // Fast Reproduction (Only base and upgrade values, no drop upgrade)
        baseValues.add(FAST_SPAWN_TIME_BASE);
        upgradeValues.add(FAST_SPAWN_TIME_UPGRADE);

    }
}
