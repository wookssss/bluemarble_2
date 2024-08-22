package itschool.bluemarble.entity.abs;

import itschool.bluemarble.entity.ifs.SpecialFunction;
import itschool.bluemarble.entity.Tile;

public abstract class SpecialTile extends Tile {
    private SpecialFunction specialFunction;

    public SpecialTile(String name, SpecialFunction specialFunction) {
        super(name);
        this.specialFunction = specialFunction;
    }
}
