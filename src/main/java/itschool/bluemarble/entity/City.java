package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.Tile;
import itschool.bluemarble.enumclass.Color;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends Tile {
    //지어진 건물에 대한 인덱스 상수
    public static final int LAND = 0;
    public static final int VILLA = 1;
    public static final int BUILDING = 2;
    public static final int HOTEL = 3;

    //도시 이름, 소유자, 가격, 지어진 건물
    private Player owner;
    private Color color;
    private int price;
    private int[] toll;
    private boolean structure[] = {false, false, false, false};

    public City(String name, Color color, int price, int toll[]) {
        super(name);
        this.color = color;
        this.price = price;
        this.toll = toll;
    }

    public City(String name) {
        super(name);
    }
}
