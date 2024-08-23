package itschool.bluemarble.model.entity.tile.abs;

import itschool.bluemarble.model.entity.tile.ifs.SpecialFunction;
import itschool.bluemarble.model.entity.tile.Tile;

public abstract class SpecialTile extends Tile {
    private SpecialFunction specialFunction;

    public SpecialTile(String name, SpecialFunction specialFunction) {
        super(name);
        this.specialFunction = specialFunction;
    }
}
