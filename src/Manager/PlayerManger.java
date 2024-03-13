package Manager;

import Utils.Upgradable;
import javafx.util.Pair;

import java.util.ArrayList;

public class PlayerManger implements Upgradable {
    private double BioticRifleDamage;
    private double BioticRifleFirerate;
    private double Dexterity;
    private double Proficiency;
    private double Minimize;
    private ArrayList<Pair<String, Integer>> Weapon;

    public PlayerManger(){
        setDexterity(7);
        setBioticRifleDamage(1);
        setProficiency(1);
        setBioticRifleFirerate(0.5);
        setMinimize(5);
        this.Weapon = new ArrayList<Pair<String, Integer>>();
        Weapon.add(new Pair<>("Neuron Missile", 0));
    }

    public double getMinimize() {
        return Minimize;
    }

    public double getBioticRifleDamage() {
        return BioticRifleDamage;
    }

    public double getBioticRifleFirerate() {
        return BioticRifleFirerate;
    }

    public double getDexterity() {
        return Dexterity;
    }

    public double getProficiency() {
        return Proficiency;
    }

    public void setBioticRifleDamage(double bioticRifleDamage) {
        BioticRifleDamage = bioticRifleDamage;
    }

    public void setBioticRifleFirerate(double bioticRifleFirerate) {
        BioticRifleFirerate = bioticRifleFirerate;
    }

    public void setDexterity(double dexterity) {
        Dexterity = dexterity;
    }

    public void setProficiency(double proficiency) {
        Proficiency = proficiency;
    }

    public void setMinimize(double minimize) {
        Minimize = minimize;
    }
    public void addWeapon(String weapon){

    }

    @Override
    public void upgradeLevel() {

    }

    @Override
    public void clearLevel() {

    }
}
