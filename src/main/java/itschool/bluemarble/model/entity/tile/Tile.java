package itschool.bluemarble.model.entity.tile;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tile {
    protected String name;

    @Override
    public String toString() {
        return name;
    }
}
