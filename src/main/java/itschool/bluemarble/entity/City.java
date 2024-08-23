package itschool.bluemarble.entity;

import itschool.bluemarble.entity.abs.PurchasableTile;
import itschool.bluemarble.enumclass.Color;
import itschool.bluemarble.enumclass.Construction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends PurchasableTile {
    //지어진 건물에 대한 인덱스 상수
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

    public void payToll(Player player){
        int totalToll = 0;

        for(int i=0;i<structure.length;i++){
            if(structure[i]) totalToll += toll[i];
        }
        // player.pay(owner,totalToll);
    }
}
