package sample;

public class CoinChest extends Chest{
    private final Coin coin;

    public CoinChest(double posX, double posY, Coin coin, int quantity){   // constructor overloading
        super(posX, posY, quantity);
        this.coin = coin;
    }
    public CoinChest(double posX, double posY, Coin coin){
        super(posX, posY, 10);
        this.coin = coin;
    }

    @Override
    public void onCollide(GameObject gameObject) {

    }
}
