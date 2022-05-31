package sample;

public abstract class Chest extends GameObject implements CanCollide{
    private final int quantity;

    public Chest(double posX, double posY, int quantity){
        super(posX, posY);
        this.quantity = quantity;
    }
    protected int getQuantity(){ return this.quantity; }

    public abstract void onCollide(GameObject gameObject);
}
