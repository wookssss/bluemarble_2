package itschool.bluemarble.goldenKey.ifs;

import itschool.bluemarble.entity.Player;

@FunctionalInterface
public interface InstantFunction extends Function {
    void execute(Player player);
}
