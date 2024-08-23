package itschool.bluemarble.entity.ifs;

import itschool.bluemarble.entity.Player;
import itschool.bluemarble.entity.Tile;
import lombok.Getter;

@Getter
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
    public int purchaseTile(Player player) throws Exception{
        if(owner == null) {
            this.owner = player;
        } else{
            throw new Exception("이미 주인이 있는 땅입니다.");
        }
        return price;
    }

}
