package itschool.bluemarble.goldenKey.ifs;

import itschool.bluemarble.entity.Player;

@FunctionalInterface
public interface HoldableKey extends GoldenKey {
    void use(Player player);
}
