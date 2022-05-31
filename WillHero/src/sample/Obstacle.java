package sample;

public abstract class Obstacle extends GameObject implements CanCollide{
    public Obstacle(double posX, double posY){ super(posX, posY); }
    public abstract void onCollide(GameObject gameObject);
}
