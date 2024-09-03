package itschool.bluemarble.progress.phase;

import itschool.bluemarble.model.entity.Player;

public class MovePhase {
    public static int move(Player player, int rel) {
        int index = player.moveByRelativeValue(rel);
        return index;
    }
}
