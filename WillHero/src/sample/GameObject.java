package sample;

public abstract class GameObject {
    private double positionX;  // using double as a better practice
    private double positionY;
    public GameObject(double posX, double posY){
        this.positionX = posX;
        this.positionY = posY;
    }
    protected void setPositionX(double x){ this.positionX = x; }
    protected void setPositionY(double y){ this.positionY = y; }
    protected double getPositionX(){ return this.positionX; }
    protected double getPositionY(){ return this.positionY; }
    protected void vanish(){}
    private void show(){}
}
