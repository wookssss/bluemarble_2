package itschool.bluemarble.entity;

public class Special extends Tile{
    private String type;
    private int price;
    private int toll;

    public Special(String name, String type, int price, int toll){
        super(name);
        this.type = type;
        this.price = price;
        this.toll = toll;
    }
}
