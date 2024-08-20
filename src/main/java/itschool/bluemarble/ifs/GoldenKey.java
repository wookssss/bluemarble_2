package itschool.bluemarble.ifs;

import itschool.bluemarble.entity.Player;

@FunctionalInterface
public interface GoldenKey {
    void execute(Player player);
}
