package Manager;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import Utils.Updatable;


public class StatManager implements Updatable {
   private static StatManager instance;
   private int coin;
   //TODO: every time, you get a coin -> increase totalCoin
    private int totalCoin;
    private int dna;
    private int honeyLevel;
    private int entireHoneylevel;
    private int soul;
    private int amber;
    private double time;
    private int completion;
    private int death;
    private int killed;
    private ArrayList<Boolean> enemyUnlocked;
    private ArrayList<Integer> gobletLevels;
    private ArrayList<Integer> dnaLevels;
    public StatManager(){
        setAmber(0);
        setCoin(1000000);
        setTotalCoin(10000000);
        setHoneyLevel(0);
        setEntireHoneylevel(1);
        setCompletion(0);
        setDeath(0);
        setKilled(0);
        setTime(0d);
        setSoul(0);
        gobletLevels = new ArrayList<>(Arrays.asList(1,1,1,0,1));
        dnaLevels = new ArrayList<>(Arrays.asList(0,0));
        enemyUnlocked = new ArrayList<>(Arrays.asList(true,false,false));
    }
    @Override
    public void onUpdate() {
        if(totalCoin>entireHoneylevel*100){
            totalCoin-=entireHoneylevel*100;
            entireHoneylevel++;
            honeyLevel++;
        }
    }
    public void reset(){
        setAmber(getAmber()+(honeyLevel* gobletLevels.get(0)));
        setCoin(0);
        setTotalCoin(0);
        setSoul(0);
        setHoneyLevel(0);
        PlayerManager.getInstance().reset();
        EnemyManager.getInstance().reset();
        BulletManager.getInstance().clearBullets();
        ItemManager.getInstance().clearItems();
    }
    public void addKilled(){
        killed+=1;
    }
    public void addDeath(){
        death+=1;
    }
    public void addCoin(long coin){
        this.coin+= (int) coin * gobletLevels.get(1);
        this.totalCoin+= (int) coin* gobletLevels.get(1);
    }
    public void addCompletion(int percent){
        completion+=percent;
    }

    public double getTime() {
        return time;
    }

    public int getCompletion() {
        return completion;
    }

    public int getDeath() {
        return death;
    }

    public int getKilled() {
        return killed;
    }

    public int getAmber() {
        return amber;
    }

    public int getCoin() {
        return coin;
    }

    public int getSoul() {
        return soul;
    }

    public void setAmber(int amber) {
        this.amber = amber;
    }

    public int getDna() {
        return dna;
    }

    public void setDna(int dna) {
        this.dna = dna;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public void setKilled(int killed) {
        this.killed = killed;
    }

    public void setSoul(int soul) {
        this.soul = soul;
    }

    public int getEntireHoneylevel() {
        return entireHoneylevel;
    }

    public void setEntireHoneylevel(int entireHoneylevel) {
        this.entireHoneylevel = entireHoneylevel;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public ArrayList<Boolean> getEnemyUnlocked() {
        return enemyUnlocked;
    }

    public void setEnemyUnlocked(ArrayList<Boolean> enemyUnlocked) {
        this.enemyUnlocked = enemyUnlocked;
    }

    public int getHoneyLevel() { return honeyLevel; }

    public void setHoneyLevel(int honeyLevel) { this.honeyLevel = honeyLevel; }

    public int getTotalCoin() { return totalCoin; }

    public void setTotalCoin(int totalCoin) { this.totalCoin = totalCoin; }

    public ArrayList<Integer> getGobletLevels() {
        return gobletLevels;
    }

    public void setGobletLevels(ArrayList<Integer> gobletLevels) {
        this.gobletLevels = gobletLevels;
    }

    public ArrayList<Integer> getDnaLevels() {
        return dnaLevels;
    }

    public void setDnaLevels(ArrayList<Integer> dnaLevels) {
        this.dnaLevels = dnaLevels;
    }

    public static StatManager getInstance() {
        if (instance ==null){
            instance = new StatManager();
        }
        return instance;
    }
    @Override
    public String toString(){
        return "Coin : "+coin+" Total Coin : "+totalCoin+" Honey Level : "+honeyLevel+" Soul : "+soul+" Amber : "+amber+" Time : "+time+" Completion : "+completion+" Death : "+death+" Killed : "+killed;
    }


}
