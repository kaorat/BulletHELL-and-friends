package Manager;

import GameEntity.Player.Player;
import Utils.Config;
import Utils.Transform;
import Utils.Updatable;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.pow;

public class PlayerManager implements  Updatable {
    private static PlayerManager instance;
    private Player player;
    private ArrayList<Integer> playerPerks;
    private double bioticRifleDamage;
    private double bioticRifleFireRate;
    private double dexterity;
    private double proficiency;
    private double minimize;
    private ArrayList<Pair<String, Integer>> weapon;

    public PlayerManager(){
        reset();
    }
    public static PlayerManager getInstance() {
        if (instance == null) {
            instance = new PlayerManager();
        }
        return instance;
    }

    private void addPlayer(){
        Player player = new Player(new Transform(200,400),30);
        this.player = player;
        GameObjectHolder.getInstance().add(player);
    }
    public double getMinimize() {
        return minimize;
    }

    public double getBioticRifleDamage() {
        return bioticRifleDamage;
    }

    public double getBioticRifleFireRate() {
        return bioticRifleFireRate;
    }

    public double getDexterity() {
        return dexterity;
    }

    public double getProficiency() {
        return proficiency;
    }

    public void setBioticRifleDamage(double bioticRifleDamage) {
        this.bioticRifleDamage = bioticRifleDamage;
    }

    public void setBioticRifleFireRate(double bioticRifleFireRate) {
        this.bioticRifleFireRate = bioticRifleFireRate;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public void setProficiency(double proficiency) {
        this.proficiency = proficiency;
    }

    public void setMinimize(double minimize) {
        this.minimize = minimize;
    }

    public ArrayList<Integer> getPlayerPerks() {
        return playerPerks;
    }
    public void addWeapon(String weapon){

    }


    public Player getPlayer(){
        return player;
    }

    @Override
    public void onUpdate() {
        // print all the player stats
//        System.out.println("Player Stats: ");
        System.out.println("Biotic Rifle Damage: " + getBioticRifleDamage());

    }

    // what is reset?
    public void reset(){
        addPlayer();
        setDexterity(7);
        setBioticRifleDamage(Config.DAMAGE_BASE);
        setProficiency(1);
        setBioticRifleFireRate(0.5);
        setMinimize(5);
        PlayerPerks = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0));
        this.Weapon = new ArrayList<Pair<String, Integer>>();
        Weapon.add(new Pair<>("Neuron Missile", 0));
    }
    public void upgradeStat(int index){
        playerPerks.set(index,playerPerks.get(index)+1);
        switch (index){
            case 0:
                double damage_price = Config.DAMAGE_BASE_PRICE*pow(Config.DAMAGE_PRICE_INCREMENT,playerPerks.get(index));
                setBioticRifleDamage(getBioticRifleDamage()+Config.DAMAGE_UPGRADE);
                break;
            case 1:
                double firerate_price = Config.PLAYER_FIRE_RATE_BASE_PRICE*pow(Config.PLAYER_FIRE_RATE_PRICE_INCREMENT,playerPerks.get(index));
                setBioticRifleFireRate(getBioticRifleFireRate()+Config.PLAYER_FIRE_RATE_UPGRADE);
                break;
            case 2:
                double minimize_price = Config.MINIMIZE_BASE_PRICE*pow(Config.MINIMIZE_PRICE_INCREMENT,playerPerks.get(index));
                setMinimize(getMinimize()-Config.MINIMIZE_UPGRADE);
                break;
            case 3:
                double dexterity_price = Config.DEXTERITY_BASE_PRICE*pow(Config.DEXTERITY_PRICE_INCREMENT,playerPerks.get(index));
                setDexterity(getDexterity()+Config.DEXTERITY_UPGRADE);
                break;
            case 4:
                double proficiency_price = Config.PROFICIENCY_BASE_PRICE*pow(Config.PROFICIENCY_PRICE_INCREMENT,playerPerks.get(index));
                setProficiency(getProficiency()+Config.PROFICIENCY_UPGRADE);
                break;
        }

    }


}
