package itschool.bluemarble.model.entity.goldenKey.ifs;

import itschool.bluemarble.model.entity.Player;

@FunctionalInterface
public interface HoldableFunction extends Function {
    void use(Player player);
}
