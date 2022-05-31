package sample;

public class GreenOrc extends Orc{

    public GreenOrc(double posX, double posY, double jumpheight, String colour){
        super(posX, posY, jumpheight, "GREEN");
    }

    @Override
    public void jump() {

    }

    @Override
    public void onCollide(GameObject gameObject) {

    }
}
