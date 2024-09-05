package itschool.bluemarble.model.entity.tile.ifs;

import itschool.bluemarble.model.entity.Player;

public interface SpecialFunction {
    void execute(Player player) throws RuntimeException;
}
