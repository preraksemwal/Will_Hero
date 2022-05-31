package sample;

public abstract class Orc extends GameObject implements CanCollide, CanJump{

    private final String orcColour;
    private final double jumpHeight;

    public Orc(double posX, double posY, double jumpHeight, String colour){
        super(posX, posY);
        this.orcColour = colour;
        this.jumpHeight = jumpHeight;
    }

    @Override
    abstract public void jump();

    @Override
    abstract public void onCollide(GameObject gameObject);

    public double getJumpHeight() { return this.jumpHeight; }
    public String getOrcColour() { return orcColour; }
}
