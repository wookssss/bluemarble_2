package itschool.bluemarble.model.entity.tile.abs;

import itschool.bluemarble.model.entity.Bank;
import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.tile.Tile;
import lombok.Getter;

@Getter
public abstract class PurchasableTile extends Tile {
    protected Player owner;
    protected int price;
    protected int toll;

    public PurchasableTile(String name, int price) {
        super(name);
        this.price = price;
    }

    public PurchasableTile(String name, int price, int toll) {
        super(name);
        this.price = price;
        this.toll = toll;
    }

    public boolean isPurchasable(){
        return (owner == null)? true:false;
    }

    // 주인이 없는 경우 도시 구매
    public void purchaseTile(Player player) throws Exception{
        if(isPurchasable()) {
            player.pay(Bank.getInstance(), price);
            this.owner = player;
        } else {
            throw new Exception("이미 주인이 있는 땅입니다.");
        }
    }

    // 주인이 있는 경우 통행료 지불
    public abstract void payToll(Player player) throws Exception;
}
