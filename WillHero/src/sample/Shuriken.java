package sample;

public class Shuriken extends Weapon{
    private static Helmet helmet;

    public Shuriken(Helmet helmet){
        super();
        Shuriken.helmet = helmet;
    }
    @Override
    protected void throwWeapon() {

    }
    public Helmet getHelmet(){ return this.helmet; }
}
