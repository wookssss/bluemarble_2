package itschool.bluemarble.entity.ifs;

import itschool.bluemarble.entity.Player;
import itschool.bluemarble.entity.Tile;

public abstract class PurchasableTile extends Tile {
    protected Player owner;
    protected int price;
    protected int toll[];

    public PurchasableTile(String name, int price, int[] toll) {
        super(name);
        this.price = price;
        this.toll = toll;
    }

    public PurchasableTile(String name){
        super(name);
    }
    public void purchaseTile(Player player){
        this.owner = player;
    }

}
