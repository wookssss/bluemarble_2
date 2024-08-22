package itschool.bluemarble.entity;

public class SpecialCity extends Tile {
    private Player owner;
    private int price;
    private int toll;

    public SpecialCity(String name, int price, int toll){
        super(name);
        this.price = price;
        this.toll = toll;
    }

    void setOwner(Player player){
        this.owner = player;
    }
}
