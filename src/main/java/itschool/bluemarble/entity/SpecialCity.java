package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.PurchasableTile;

public class SpecialCity extends PurchasableTile {

    public SpecialCity(String name, int price, int[] toll) {
        super(name, price, toll);
    }

    void setOwner(Player player){
        this.owner = player;
    }
}
