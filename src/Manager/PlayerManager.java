package Manager;

import GameEntity.Player.Player;
import Utils.Config;
import Utils.Transform;
import Utils.Updatable;
import Utils.Utility;
import javafx.animation.AnimationTimer;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerManager implements Updatable {
    private static PlayerManager instance;
    private Player player;
    private ArrayList<Integer> playerPerks;
    private double bioticRifleDamage;
    private double bioticRifleFireRate;
    private double minimize;
    private double dexterity;
    private double proficiency;
    private ArrayList<Pair<String, Integer>> weapon;

    public PlayerManager() {
        reset();
    }

    public static PlayerManager getInstance() {
        if (instance == null) {
            instance = new PlayerManager();
        }
        return instance;
    }

    private void addPlayer() {
        Player player = new Player(new Transform(Utility.getGameScreenX() / 2 - 30, Utility.getScreenY() - 100, 0.2, 0.2), 25);
        this.player = player;
        GameObjectHolder.getInstance().add(player);
    }


    public Player getPlayer() {
        return player;
    }

    @Override
    public void onUpdate() {
//        System.out.println(toString());
        if (player == null) {
            return;
        }
        if (player.isDestroyed()) {
            player = null;
            respawnDelay();
        }
    }

    private void respawnDelay() {
        double startFrame = System.currentTimeMillis();
        double respawnTime = 3000;
        new AnimationTimer() {
            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame > respawnTime) {
                    addPlayer();
                    this.stop();
                }
            }
        }.start();
    }

    // what is reset?
    //Suchas Answer : Prestege
    public void reset() {
        if (player != null) {
            player.setDestroyed(true);
        }
        addPlayer();
        setDexterity(Config.GRAZE_HITBOX_SIZE_BASE);
        setBioticRifleDamage(Config.DAMAGE_BASE);
        setProficiency(Config.PART_PER_GRAZE_BASE);
        setBioticRifleFireRate(Config.PLAYER_FIRE_RATE_BASE);
        setMinimize(Config.HITBOX_SIZE_BASE);
        playerPerks = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        this.weapon = new ArrayList<>();
        weapon.add(new Pair<>("Neuron Missile", 0));
        //TODO: Config Player
//        player.setFireRate(getBioticRifleFireRate()*1000);
    }

    public void upgradeStat(int index) {
        if (playerPerks.get(index) >= Config.player_maxLevels.get(index)) {
            return;
        }
        playerPerks.set(index, playerPerks.get(index) + 1);

        switch (index) {
            case 0:
                setBioticRifleDamage(getBioticRifleDamage() + Config.DAMAGE_UPGRADE);
                break;
            case 1:
                setBioticRifleFireRate(getBioticRifleFireRate() + Config.PLAYER_FIRE_RATE_UPGRADE);
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

    public void setMinimize(double minimize) {
        this.minimize = minimize;
    }

    public double getBioticRifleDamage() {
        return bioticRifleDamage;
    }

    public void setBioticRifleDamage(double bioticRifleDamage) {
        this.bioticRifleDamage = bioticRifleDamage;
    }

    public double getBioticRifleFireRate() {
        return bioticRifleFireRate;
    }

    public void setBioticRifleFireRate(double bioticRifleFireRate) {
        this.bioticRifleFireRate = bioticRifleFireRate;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getProficiency() {
        return proficiency;
    }

    public void setProficiency(double proficiency) {
        this.proficiency = proficiency;
    }

    public ArrayList<Integer> getPlayerPerks() {
        return playerPerks;
    }

    public String toString() {
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
