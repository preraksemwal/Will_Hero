package sample;

public class TNT extends Obstacle{
    private final double explosionRadius;
    public TNT(double posX, double posY, double explosionRadius){
        super(posX, posY);
        this.explosionRadius = explosionRadius;
    }
    @Override
    public void onCollide(GameObject gameObject){
        /*
            To be done
        */
    }

    public void explode(){
        /*
            To be done
         */
    }
}
