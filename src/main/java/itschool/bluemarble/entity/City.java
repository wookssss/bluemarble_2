package itschool.bluemarble.entity;

import itschool.bluemarble.entity.abs.ConstructibleTile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends ConstructibleTile {
    //도시 이름, 소유자, 가격, 지어진 건물

    public City(String name, int price) {
        super(name, price);
    }

    public void payToll(Player player){
        /*int totalToll = 0;

        for(int i=0;i<structure.length;i++){
            if(structure[i]) totalToll += toll[i];
        }*/
        // player.pay(owner,totalToll);
    }
}
