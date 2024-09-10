package itschool.bluemarble.model.entity.tile;

import itschool.bluemarble.model.entity.tile.abs.SpecialTile;
import itschool.bluemarble.model.entity.tile.ifs.SpecialFunction;

public class SpaceTravel extends SpecialTile {

    public SpaceTravel(String name) {
        super(name, (player) -> {
            System.out.println(player.getName() + "님이 우주여행을 시작합니다.");
        });
    }

    public void checkOwner(SpecialVehicle special){
        if(special.getOwner() != null){

        }
    }
}
