package sample;

import java.util.ArrayList;

public class Helmet{
    private final Weapon weapon1;  // we can check to what weapon-subclass 'weapon1' is an 'instanceof'
    private final Weapon weapon2;
    private final ArrayList<Weapon> weapons = new ArrayList<>();
    public Helmet(){
        this.weapon1 = new Shuriken(this);
        this.weapon2 = new ThrowingKnife(this);
        weapons.add(weapon1);
        weapons.add(weapon2);
    }

    public ArrayList<Weapon> getWeapons(){ return weapons; }
}
