package itschool.bluemarble.goldenKey.ifs;

import itschool.bluemarble.entity.Player;

@FunctionalInterface
public interface HoldableFunction extends Function {
    void use(Player player);
}
