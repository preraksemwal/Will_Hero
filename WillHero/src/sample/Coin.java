package sample;

public class Coin extends GameObject{
    private final int coinValue;
    public Coin(double posX, double posY, int coinValue){
        super(posX, posY);
        this.coinValue = coinValue;
    }
    public int getCoinValue() { return coinValue; }
}
