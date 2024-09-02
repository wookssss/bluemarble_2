package itschool.bluemarble.progress.ifs;

import itschool.bluemarble.exception.event.HoldableKeyEvent;
import itschool.bluemarble.model.entity.Dice;
import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.goldenKey.GoldenKey;

public interface GameInterface {
    void showMap();

    void confirmToUseGoldenKey(Player player, GoldenKey goldenKey) throws HoldableKeyEvent;

    boolean confirm(String message);

    void printOutDiceResult(Player player, Dice dice);

    void printOutOfDrawedGoldenKey(Player player, GoldenKey goldenKey);

    void printOutOfException(RuntimeException exception);

    void printOutOfPlayerInfo(Player player);

    void printOutOfMoving(Player player);
}
