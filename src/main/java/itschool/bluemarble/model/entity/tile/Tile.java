package itschool.bluemarble.model.entity.tile;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

@Getter
@AllArgsConstructor
public class Tile {
    protected int index;
    protected String name;

    @Override
    public String toString() {
        return name;
    }
}
