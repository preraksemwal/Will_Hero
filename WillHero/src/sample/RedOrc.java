package sample;

public class RedOrc extends Orc{

    public RedOrc(double posX, double posY, double jumpheight){
        super(posX, posY, jumpheight,"RED");
    }

    @Override
    public void jump() {

    }

    @Override
    public void onCollide(GameObject gameObject) {

    }
}
