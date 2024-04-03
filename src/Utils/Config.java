package Utils;

import java.util.ArrayList;


public class Config {

    //TODO
    // might need to make a base for each enemy type
    //Enemy Multiplier -> multiply hp and price
    public static final int COW_MULTIPLIER = 100;
    public static final int CHICKEN_MULTIPLIER = 1000;

    // Parts Drop
    public static final double PARTS_DROP_BASE = 10;

    // Calcium Gene : 1
    public static final double ENEMY_HP_BASE = 10;
    public static final double CALC_G_HP_UPGRADE = 5;
    public static final double CALC_G_BASE_PRICE = 30;
    public static final double CALC_G_PRICE_INCREMENT = 1.2;//Power by level
    public static final double CALC_G_PARTS_DROP_UPGRADE = 2;
    public static final double CALC_G_MAX_LEVEL = 1000000;

    // Agility Gene : 2
    public static final double ENEMY_FIRE_RATE_BASE=5;
    public static final double AGILITY_FIRE_RATE_UPGRADE = -0.1;
    public static final double AGILITY_BASE_PRICE = 400;
    public static final double AGILITY_PRICE_INCREMENT = 1.2;//Power by level
    public static final double AGILITY_PARTS_DROP_UPGRADE = 5;
    public static final double AGILITY_MAX_LEVEL = 99;

    // Lethal Mutation : 3
    public static final double ENEMY_BULLET_SPEED_BASE = 5;
    public static final double LETHAL_BULLET_SPEED_UPGRADE = 0.2;
    public static final double LETHAL_BASE_PRICE = 300;
    public static final double LETHAL_PRICE_INCREMENT = 1.2;//Power by level
    public static final double LETHAL_PARTS_DROP_UPGRADE = 5;
    public static final double LETHAL_MAX_LEVEL = 1000;

    // Fuzzy Mutation : 4
    // Sheep multiply fire rate by n/10 , cow increase bullet number by n*6 , chicken increase bullet number (more shotgun) by n
    // bullet quantity
    public static final double SHEEP_BULLET_QUANTITY_BASE = 2;
    public static final double COW_BULLET_QUANTITY_BASE = 5;
    public static final double CHICKEN_BULLET_QUANTITY_BASE = 1;
    public static final double FUZZY_BULLET_QUANTITY_UPGRADE = 1;
    public static final double FUZZY_BASE_PRICE = 200;
    public static final double FUZZY_PRICE_INCREMENT = 1.25;//Power by level
    public static final double FUZZY_PARTS_DROP_UPGRADE = 10;
    public static final double FUZZY_MAX_LEVEL = 1000;



    // Elongation Sheep has no upgrade ?? : 5
    // chicken has no upgrade (random bullet spread)
    public static final double BULLET_LENGTH_BASE = 3;
    public static final double ELONGATION_BULLET_LENGTH_UPGRADE = 1;
    public static final double ELONGATION_BASE_PRICE = 800;
    public static final double ELONGATION_PRICE_INCREMENT = 1.25;//Power by level
    public static final double ELONGATION_PARTS_DROP_UPGRADE = 10;
    public static final double ELONGATION_MAX_LEVEL = 1000;



    // Genetic Drift : 6
    public static final double SOUL_CHANCE_BASE = 5;
    public static final double GENETIC_SOUL_CHANCE_UPGRADE = 5;
    public static final double GENETIC_BASE_PRICE = 1000;
    public static final double GENETIC_PRICE_INCREMENT = 1.25;//Power by level
    public static final double GENETIC_MAX_LEVEL = 20;

    // Fast Reproduction : 7
    public static final double SPAWN_TIME_BASE = 3.0;
    public static final double REPRODUCTION_SPAWN_TIME_UPGRADE = -0.05;
    public static final double REPRODUCTION_BASE_PRICE = 300;
    public static final double REPRODUCTION_PRICE_INCREMENT = 1.25;//Power by level
    public static final double REPRODUCTION_MAX_LEVEL = 75;

    //TODO : Player
    //Player Speed
    public static final double PLAYER_SPEED_BASE = 6;
    public static final double PLAYER_SPEED_SHIFT = 4;
    // no upgrade


    //Damage
    public static final double DAMAGE_BASE = 1;
    public static final double DAMAGE_UPGRADE = 0.25;
    public static final double DAMAGE_BASE_PRICE = 20;
    public static final double DAMAGE_PRICE_INCREMENT = 1.25;//Power by level
    public static final double DAMAGE_MAX_LEVEL = 50;//???????

    //Firerate
    public static final double PLAYER_FIRE_RATE_BASE = 0.5;
    public static final double PLAYER_FIRE_RATE_UPGRADE = -0.01;
    public static final double PLAYER_FIRE_RATE_BASE_PRICE = 100;
    public static final double PLAYER_FIRE_RATE_PRICE_INCREMENT = 1.25;//Power by level
    public static final double PLAYER_FIRE_RATE_MAX_LEVEL = 35;

    //Minimize
    public static final double HITBOX_SIZE_BASE = 5;
    public static final double MINIMIZE_UPGRADE = -0.1;
    public static final double MINIMIZE_BASE_PRICE = 200;
    public static final double MINIMIZE_PRICE_INCREMENT = 1.25;//Power by level
    public static final double MINIMIZE_MAX_LEVEL = 40;

    //DEXTERITY
    public static final double GRAZE_HITBOX_SIZE_BASE = 7;
    public static final double DEXTERITY_UPGRADE = 0.05;
    public static final double DEXTERITY_BASE_PRICE = 100;
    public static final double DEXTERITY_PRICE_INCREMENT = 1.25;//Power by level
    public static final double DEXTERITY_MAX_LEVEL = 60;

    //Proficiency
    public static final double PART_PER_GRAZE_BASE = 1;
    public static final double PROFICIENCY_UPGRADE = 1;
    public static final double PROFICIENCY_BASE_PRICE = 1000;
    public static final double PROFICIENCY_PRICE_INCREMENT = 2;//Power by level
    public static final double PROFICIENCY_MAX_LEVEL = 100;

    //Goblet galore->10*level soul->level others->2^level
    //cost (level+1)!
    //reset -> gain honey ->

    // ArrayLists to store base values, upgrade values, and drop upgrade values
    //Enemy
    public static ArrayList<Double> enemy_baseValues = new ArrayList<Double>();
    public static ArrayList<Double> enemy_upgradeValues = new ArrayList<Double>();
    public static ArrayList<Double> enemy_basePrices = new ArrayList<Double>();
    public static ArrayList<Double> enemy_priceIncrements = new ArrayList<Double>();
    public static ArrayList<Double> enemy_dropUpgradeValues = new ArrayList<Double>();
    public static ArrayList<Double> enemy_maxLevels = new ArrayList<Double>();

    //Player
    public static ArrayList<Double> player_baseValues = new ArrayList<Double>();
    public static ArrayList<Double> player_upgradeValues = new ArrayList<Double>();
    public static ArrayList<Double> player_basePrices = new ArrayList<Double>();
    public static ArrayList<Double> player_priceIncrements = new ArrayList<Double>();
    public static ArrayList<Double> player_maxLevels = new ArrayList<Double>();

    // Initialize base, upgrade, and drop upgrade values
    static {
        // Parts Drop (no need , all zero)
        enemy_baseValues.add(0d);
        enemy_upgradeValues.add(0d);
        enemy_basePrices.add(0d);
        enemy_priceIncrements.add(0d);
        enemy_dropUpgradeValues.add(0d);
        enemy_maxLevels.add(0d);

        // Calcium Gene
        enemy_baseValues.add(ENEMY_HP_BASE);
        enemy_upgradeValues.add(CALC_G_HP_UPGRADE);
        enemy_basePrices.add(CALC_G_BASE_PRICE);
        enemy_priceIncrements.add(CALC_G_PRICE_INCREMENT);
        enemy_dropUpgradeValues.add(CALC_G_PARTS_DROP_UPGRADE);
        enemy_maxLevels.add(CALC_G_MAX_LEVEL);

        // Agility Gene
        enemy_baseValues.add(ENEMY_FIRE_RATE_BASE);
        enemy_upgradeValues.add(AGILITY_FIRE_RATE_UPGRADE);
        enemy_basePrices.add(AGILITY_BASE_PRICE);
        enemy_priceIncrements.add(AGILITY_PRICE_INCREMENT);
        enemy_dropUpgradeValues.add(AGILITY_PARTS_DROP_UPGRADE);
        enemy_maxLevels.add(AGILITY_MAX_LEVEL);

        // Lethal Mutation
        enemy_baseValues.add(ENEMY_BULLET_SPEED_BASE);
        enemy_upgradeValues.add(LETHAL_BULLET_SPEED_UPGRADE);
        enemy_basePrices.add(LETHAL_BASE_PRICE);
        enemy_priceIncrements.add(LETHAL_PRICE_INCREMENT);
        enemy_dropUpgradeValues.add(LETHAL_PARTS_DROP_UPGRADE);
        enemy_maxLevels.add(LETHAL_MAX_LEVEL);

        // Fuzzy Mutation //TODO:base values -> manual add
        enemy_baseValues.add(SHEEP_BULLET_QUANTITY_BASE);
        enemy_upgradeValues.add(FUZZY_BULLET_QUANTITY_UPGRADE);
        enemy_basePrices.add(FUZZY_BASE_PRICE);
        enemy_priceIncrements.add(FUZZY_PRICE_INCREMENT);
        enemy_dropUpgradeValues.add(FUZZY_PARTS_DROP_UPGRADE);
        enemy_maxLevels.add(FUZZY_MAX_LEVEL);

        // Elongation
        enemy_baseValues.add(BULLET_LENGTH_BASE);
        enemy_upgradeValues.add(ELONGATION_BULLET_LENGTH_UPGRADE);
        enemy_basePrices.add(ELONGATION_BASE_PRICE);
        enemy_priceIncrements.add(ELONGATION_PRICE_INCREMENT);
        enemy_dropUpgradeValues.add(ELONGATION_PARTS_DROP_UPGRADE);
        enemy_maxLevels.add(ELONGATION_MAX_LEVEL);

        // Genetic Drift
        enemy_baseValues.add(SOUL_CHANCE_BASE);
        enemy_upgradeValues.add(GENETIC_SOUL_CHANCE_UPGRADE);
        enemy_basePrices.add(GENETIC_BASE_PRICE);
        enemy_priceIncrements.add(GENETIC_PRICE_INCREMENT);
        enemy_dropUpgradeValues.add(0d);
        enemy_maxLevels.add(GENETIC_MAX_LEVEL);

        // Fast Reproduction (Only base and upgrade values, no drop upgrade)
        enemy_baseValues.add(SPAWN_TIME_BASE);
        enemy_upgradeValues.add(REPRODUCTION_SPAWN_TIME_UPGRADE);
        enemy_basePrices.add(REPRODUCTION_BASE_PRICE);
        enemy_priceIncrements.add(REPRODUCTION_PRICE_INCREMENT);
        enemy_dropUpgradeValues.add(0d);
        enemy_maxLevels.add(REPRODUCTION_MAX_LEVEL);

        //Player
        //Damage
        player_baseValues.add(DAMAGE_BASE);
        player_upgradeValues.add(DAMAGE_UPGRADE);
        player_basePrices.add(DAMAGE_BASE_PRICE);
        player_priceIncrements.add(DAMAGE_PRICE_INCREMENT);
        player_maxLevels.add(DAMAGE_MAX_LEVEL);

        //Firerate
        player_baseValues.add(PLAYER_FIRE_RATE_BASE);
        player_upgradeValues.add(PLAYER_FIRE_RATE_UPGRADE);
        player_basePrices.add(PLAYER_FIRE_RATE_BASE_PRICE);
        player_priceIncrements.add(PLAYER_FIRE_RATE_PRICE_INCREMENT);
        player_maxLevels.add(PLAYER_FIRE_RATE_MAX_LEVEL);

        //Minimize
        player_baseValues.add(HITBOX_SIZE_BASE);
        player_upgradeValues.add(MINIMIZE_UPGRADE);
        player_basePrices.add(MINIMIZE_BASE_PRICE);
        player_priceIncrements.add(MINIMIZE_PRICE_INCREMENT);
        player_maxLevels.add(MINIMIZE_MAX_LEVEL);

        //Dexterity
        player_baseValues.add(GRAZE_HITBOX_SIZE_BASE);
        player_upgradeValues.add(DEXTERITY_UPGRADE);
        player_basePrices.add(DEXTERITY_BASE_PRICE);
        player_priceIncrements.add(DEXTERITY_PRICE_INCREMENT);
        player_maxLevels.add(DEXTERITY_MAX_LEVEL);

        //Proficiency
        player_baseValues.add(PART_PER_GRAZE_BASE);
        player_upgradeValues.add(PROFICIENCY_UPGRADE);
        player_basePrices.add(PROFICIENCY_BASE_PRICE);
        player_priceIncrements.add(PROFICIENCY_PRICE_INCREMENT);
        player_maxLevels.add(PROFICIENCY_MAX_LEVEL);
    }


//    //TODO : Image Config
//    public static final double PLAYER_OFFSET_WIDTH = 0;
//    public static final double PLAYER_OFFSET_HEIGHT = 0;
//    public static final double PLAYER_WIDTH = 60;
//    public static final double PLAYER_HEIGHT = 60;
//
//    public static final double CHICKEN_OFFSET_WIDTH = 0;
//    public static final double CHICKEN_OFFSET_HEIGHT = 0;
//    public static final double CHICKEN_WIDTH = 40;
//    public static final double CHICKEN_HEIGHT = 60;
//
//    public static final double SHEEP_OFFSET_WIDTH = 0;
//    public static final double SHEEP_OFFSET_HEIGHT = 0;
//    public static final double SHEEP_WIDTH = 60;
//    public static final double SHEEP_HEIGHT = 60;
//
//    public static final double COW_OFFSET_WIDTH = 0;
//    public static final double COW_OFFSET_HEIGHT = 0;
//    public static final double COW_WIDTH = 60;
//    public static final double COW_HEIGHT = 60;
//
//    public static final double ENEMY_BULLET_OFFSET_WIDTH = 0;
//    public static final double ENEMY_BULLET_OFFSET_HEIGHT = 0;
//    public static final double ENEMY_BULLET_WIDTH = 2;
//    public static final double ENEMY_BULLET_HEIGHT = 2;
//
//    public static final double PLAYER_BULLET_OFFSET_WIDTH = 0;
//    public static final double PLAYER_BULLET_OFFSET_HEIGHT = 0;
//    public static final double PLAYER_BULLET_WIDTH = 10;
//    public static final double PLAYER_BULLET_HEIGHT = 10;
//
//    public static final double COIN_OFFSET_WIDTH = 0;
//    public static final double COIN_OFFSET_HEIGHT = 0;
//    public static final double COIN_WIDTH = 20;
//    public static final double COIN_HEIGHT = 20;

}
