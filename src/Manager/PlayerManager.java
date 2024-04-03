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
    private double minimize;
    private double dexterity;
    private double proficiency;
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
        Player player = new Player(new Transform(200,400,0.1,0.1),30);
        this.player = player;
        GameObjectHolder.getInstance().add(player);
    }

    public void addWeapon(String weapon){

    }


    public Player getPlayer(){
        return player;
    }

    @Override
    public void onUpdate() {
        System.out.println(toString());

    }

    // what is reset?
    //Suchas Answer : Prestege
    public void reset(){
        addPlayer();
        setDexterity(Config.GRAZE_HITBOX_SIZE_BASE);
        setBioticRifleDamage(Config.DAMAGE_BASE);
        setProficiency(Config.PART_PER_GRAZE_BASE);
        setBioticRifleFireRate(Config.PLAYER_FIRE_RATE_BASE);
        setMinimize(Config.HITBOX_SIZE_BASE);
        playerPerks = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0));
        this.weapon = new ArrayList<Pair<String, Integer>>();
        weapon.add(new Pair<>("Neuron Missile", 0));
        //TODO: Config Player
//        player.setFireRate(getBioticRifleFireRate()*1000);
    }
    public void upgradeStat(int index){
        if(playerPerks.get(index) >= Config.player_maxLevels.get(index)){
            return;
        }
        playerPerks.set(index,playerPerks.get(index)+1);

        switch (index){
            case 0:

                setBioticRifleDamage(getBioticRifleDamage()+Config.DAMAGE_UPGRADE);

                break;
            case 1:
                setBioticRifleFireRate(getBioticRifleFireRate()+Config.PLAYER_FIRE_RATE_UPGRADE);
                break;
            case 2:
                setMinimize(getMinimize() + Config.MINIMIZE_UPGRADE);
                break;
            case 3:
                setDexterity(getDexterity() + Config.DEXTERITY_UPGRADE);
                break;
            case 4:
                setProficiency(getProficiency() + Config.PROFICIENCY_UPGRADE);
                break;
        }

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

    public String toString(){
        return "PlayerManager{" +
                "bioticRifleDamage=" + bioticRifleDamage +
                ", bioticRifleFireRate=" + bioticRifleFireRate +
                ", minimize=" + minimize +
                ", dexterity=" + dexterity +
                ", proficiency=" + proficiency +
                ", weapon=" + weapon +
                '}';
    }




}
