package sample;

public class WeaponChest extends Chest{
    private final Weapon weapon;
    public WeaponChest(double posX, double posY, Weapon weapon){
        super(posX, posY,1);
        this.weapon = weapon;
    }

    @Override
    public void onCollide(GameObject gameObject) {
        /*
                tbd
         */
    }
}

