package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.Tile;
import itschool.bluemarble.entity.ifs.TileFunction;

public class SpecialFunctionTile extends Tile {
    private TileFunction function;

    public SpecialFunctionTile(String name, TileFunction funtion) {
        super(name);
        this.function = funtion;
    }
}
