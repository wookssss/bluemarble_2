package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.PurchasableTile;
import itschool.bluemarble.enumclass.Color;
import itschool.bluemarble.enumclass.Construction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends PurchasableTile {
    //지어진 건물에 대한 인덱스 상수
    public static final int LAND = Construction.LAND.ordinal();
    public static final int VILLA = Construction.VILLA.ordinal();
    public static final int BUILDING = Construction.BUILDING.ordinal();
    public static final int HOTEL = Construction.HOTEL.ordinal();

    //도시 이름, 소유자, 가격, 지어진 건물
    private Color color;
    private boolean structure[] = {false, false, false, false};

    public City(String name, Color color, int price, int[] toll) {
        super(name, price, toll);
        this.color = color;
    }

    public City(String name){
        super(name);
    }
}
