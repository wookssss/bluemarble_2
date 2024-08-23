// 담당자 : 오재헌
// 주사위 2개 (결과값 2~12)
//

package itschool.bluemarble.model.entity;

import itschool.bluemarble.progress.GameByConsole;
import itschool.bluemarble.progress.abs.Game;
import lombok.Getter;
import java.util.Random;

@Getter
public class Dice {
    private int dice1 = 0; // 주사위1
    private int dice2 = 0; // 주사위2
    private static int doubleCount = 0; // 더블의 횟수를 가지고 있는 변수

    public int roll(Player player, Game game) { // 주사위 2개를 굴린다. 2 ~ 12
        dice1 = 1 + new Random().nextInt(6);
        dice2 = 1 + new Random().nextInt(6);

        if (isDouble()) {
            doubleCount++;
        }else { //
            doubleCount = 0;
        }

        ((GameByConsole)game).showDiceResult(player, dice1, dice2, isDouble());

        return dice1 + dice2;
    }

    public int getDoubleCount() {
        return doubleCount;
    }

    public boolean isDouble() {
        return (dice1 == dice2);
    }

}
