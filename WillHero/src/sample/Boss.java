package sample;

public class Boss extends Orc{

    public Boss(double posX, double posY, double jumpheight, String colour){
        super(posX, posY, jumpheight, colour);
    }

    @Override
    public void jump() {

    }

    @Override
    public void onCollide(GameObject gameObject) {

    }

}
