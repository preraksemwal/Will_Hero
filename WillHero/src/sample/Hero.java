package sample;

public class Hero extends GameObject implements CanJump, CanCollide{
    private final Helmet helmet;
    private final double jumpHeight;
    public Hero(Helmet helmet, double jumpHeight){
        super(151,130);
        this.helmet = helmet;
        this.jumpHeight = jumpHeight;
    }


    @Override
    public void onCollide(GameObject gameObject) {
        /*
            TBD
         */
    }

    @Override
    public void jump() {
        /*
            TBD
         */
    }
}
