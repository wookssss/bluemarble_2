package itschool.bluemarble.model.entity.tile;

import itschool.bluemarble.model.entity.Player;

public class SpecialVehicle extends Tile {
    private Player owner;
    private int price;
    private int toll;

    public SpecialVehicle(String name, int price, int toll){
        super(name);
        this.price = price;
        this.toll = toll;
    }

    void setOwner(Player player){
        this.owner = player;
    }
}
