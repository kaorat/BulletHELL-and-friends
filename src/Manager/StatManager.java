package Manager;

import Utils.Updatable;

import java.util.ArrayList;
import java.util.Arrays;


public class StatManager implements Updatable {
    private static StatManager instance;
    private final ArrayList<Boolean> enemyUnlocked;
    private final ArrayList<Integer> gobletLevels;
    private final ArrayList<Integer> dnaLevels;
    private int coin;
    private int totalCoin;
    private int dna;
    private int honeyLevel;
    private int entireHoneyLevel;
    private int soul;
    private int amber;
    private long time;
    private double completion;
    private int death;
    private int killed;
    private int bossDefeated;
    private final long initTime;

    public StatManager() {
        setAmber(0);
        setCoin(0);
        setTotalCoin(0);
        setHoneyLevel(0);
        setEntireHoneyLevel(1);
        setDna(0);
        setCompletion(0);
        setDeath(0);
        setKilled(0);
        setTime(0);
        setSoul(0);
        gobletLevels = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        dnaLevels = new ArrayList<>(Arrays.asList(0, 0));
        enemyUnlocked = new ArrayList<>(Arrays.asList(true, false, false));
        bossDefeated = 0;
        initTime = System.currentTimeMillis();
    }

    public static StatManager getInstance() {
        if (instance == null) {
            instance = new StatManager();
        }
        return instance;
    }

    @Override
    public void onUpdate() {
        if (totalCoin > entireHoneyLevel * 80) {
            totalCoin -= entireHoneyLevel * 80;
            entireHoneyLevel++;
            honeyLevel++;
        }
        time = System.currentTimeMillis() - initTime;
    }

    public void reset() {
        setAmber(getAmber() + (honeyLevel * gobletLevels.get(0)));
        setCoin(0);
        setSoul(0);
        setHoneyLevel(0);
        PlayerManager.getInstance().reset();
        EnemyManager.getInstance().reset();
        BulletManager.getInstance().clearBullets();
        ItemManager.getInstance().clearItems();
    }

    public void addKilled() {
        killed += 1;
    }

    public void addDeath() {
        death += 1;
    }

    public void addCoin(long coin) {
        this.coin += (int) coin * gobletLevels.get(1);
        this.totalCoin += (int) coin * gobletLevels.get(1);
    }

    public void addCompletion(double percent) {
        completion += percent;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getCompletion() {
        return completion;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getKilled() {
        return killed;
    }

    public void setKilled(int killed) {
        this.killed = killed;
    }

    public int getAmber() {
        return amber;
    }

    public void setAmber(int amber) {
        this.amber = amber;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getSoul() {
        return soul;
    }

    public void setSoul(int soul) {
        this.soul = soul;
    }
    public void addSoul() {
        soul++;
    }

    public int getDna() {
        return dna;
    }

    public void setDna(int dna) {
        this.dna = dna;
    }

    public int getBossDefeated() {
        return bossDefeated;
    }
    public void BossDefeated() {
        this.bossDefeated++;
    }

    public void setEntireHoneyLevel(int entireHoneyLevel) {
        this.entireHoneyLevel = entireHoneyLevel;
    }

    public ArrayList<Boolean> getEnemyUnlocked() {
        return enemyUnlocked;
    }

    public int getHoneyLevel() {
        return honeyLevel;
    }

    public void setHoneyLevel(int honeyLevel) {
        this.honeyLevel = honeyLevel;
    }

    public void setTotalCoin(int totalCoin) {
        this.totalCoin = totalCoin;
    }

    public ArrayList<Integer> getGobletLevels() {
        return gobletLevels;
    }

    public ArrayList<Integer> getDnaLevels() {
        return dnaLevels;
    }

    @Override
    public String toString() {
        return "Coin : " + coin + " Total Coin : " + totalCoin + " Honey Level : " + honeyLevel + " Soul : " + soul + " Amber : " + amber + " Time : " + time + " Completion : " + completion + " Death : " + death + " Killed : " + killed;
    }



}
