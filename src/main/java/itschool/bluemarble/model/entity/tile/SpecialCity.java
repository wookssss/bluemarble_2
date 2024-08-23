package itschool.bluemarble.model.entity.tile;

import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.tile.abs.PurchasableTile;

public class SpecialCity extends PurchasableTile {

    public SpecialCity(String name, int price, int toll) {
        super(name, price, toll);
    }

    void setOwner(Player player){
        this.owner = player;
    }
    public void payToll(Player player) throws Exception{
        player.pay(owner, toll);
    }
}
