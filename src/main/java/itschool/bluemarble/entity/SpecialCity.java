package itschool.bluemarble.entity;

import itschool.bluemarble.entity.abs.PurchasableTile;

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
