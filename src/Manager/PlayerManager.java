package Manager;

import GameEntity.Player.Player;
import Utils.Config;
import Utils.Transform;
import Utils.Updatable;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerManager implements  Updatable {
    private static PlayerManager instance;
    public static Player player;
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
        setBioticRifleDamage(1);
        setProficiency(1);
        setBioticRifleFireRate(0.5);
        setMinimize(5);
        playerPerks = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 1, 1));
        this.weapon = new ArrayList<Pair<String, Integer>>();
        weapon.add(new Pair<>("Neuron Missile", 0));
    }

}
