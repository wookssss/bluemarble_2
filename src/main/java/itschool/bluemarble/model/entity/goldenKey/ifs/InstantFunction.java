package itschool.bluemarble.model.entity.goldenKey.ifs;

import itschool.bluemarble.model.entity.Player;

@FunctionalInterface
public interface InstantFunction extends Function {
    void execute(Player player);
}
