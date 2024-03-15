package Manager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StatManager {
   private static StatManager instance;
   private double time;
   private int completion;
   private int death;

   private int killed;

    public StatManager(){
        this.time = 0;
        this.completion = 0;
        this.death = 0;
        this.killed = 0;
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
    public static StatManager getInstance() {
        if (instance ==null){
            instance = new StatManager();
        }
        return instance;
    }
}
