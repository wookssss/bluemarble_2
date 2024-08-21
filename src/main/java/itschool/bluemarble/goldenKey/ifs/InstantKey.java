package itschool.bluemarble.goldenKey.ifs;

import itschool.bluemarble.entity.Player;

@FunctionalInterface
public interface InstantKey extends GoldenKey {
    void execute(Player player);
}
