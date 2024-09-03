package itschool.bluemarble.progress.phase;

import itschool.bluemarble.model.entity.Dice;
import itschool.bluemarble.model.entity.Player;

public class RollDicePhase {
    public static Dice rollDice(Player player, Dice dice) {

        dice.roll();

        return dice;
    }
}
