package Manager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StatManager {
   private static StatManager instance;
   private int coin;
   //TODO: every time, you get a coin -> increase totalCoin
   private int totalCoin;
   private int honeyLevel;
   private int soul;
   private int amber;
   private double time;
   private int completion;
   private int death;

   private int killed;

    public StatManager(){
        setAmber(0);
        setCoin(0);
        setTotalCoin(0);
        setHoneyLevel(1);
        setCompletion(0);
        setDeath(0);
        setKilled(0);
        setTime(0d);
        setSoul(0);
    }
    public void addKilled(){
        killed+=1;
    }
    public void addDeath(){
        death+=1;
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

    public void setTime(double time) {
        this.time = time;
    }

    public int getHoneyLevel() { return honeyLevel; }

    public void setHoneyLevel(int honeyLevel) { this.honeyLevel = honeyLevel; }

    public int getTotalCoin() { return totalCoin; }

    public void setTotalCoin(int totalCoin) { this.totalCoin = totalCoin; }

    public static StatManager getInstance() {
        if (instance ==null){
            instance = new StatManager();
        }
        return instance;
    }
}
