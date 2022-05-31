package sample;

public class ThrowingKnife extends Weapon{
    private static Helmet helmet;

    public ThrowingKnife(Helmet helmet){
        super();
        ThrowingKnife.helmet = helmet;
    }
    @Override
    protected void throwWeapon() {

    }
}
