package itschool.bluemarble.model.entity.tile;

import itschool.bluemarble.model.entity.tile.abs.ConstructibleTile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends ConstructibleTile {
    //도시 이름, 소유자, 가격, 지어진 건물

    public City(String name) {
        super(name);
    }

    @Override
    public int getToll() throws Exception {
        if(!isPurchasable()) {
            // ConstructibleTile에서 건물 여부를 체크하고 합산하는 메소드가 필요함

        }
        return 0;
    }
}
