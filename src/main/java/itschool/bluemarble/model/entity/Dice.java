// 담당자 : 오재헌
// 주사위 2개 (결과값 2~12)
//

package itschool.bluemarble.model.entity;

import lombok.Getter;
import java.util.Random;

@Getter
public class Dice {
    private int dice1 = 0; // 주사위1
    private int dice2 = 0; // 주사위2
    private static int doubleCount = 0; // 더블의 횟수를 가지고 있는 변수

    public int roll() { // 주사위 2개를 굴린다. 2 ~ 12
        dice1 = 1 + new Random().nextInt(6);
        dice2 = 1 + new Random().nextInt(6);

        if (isDouble()) {
                doubleCount++;
        }else { //
            doubleCount = 0;
        }
        return dice1 + dice2;
    }

    public int getDoubleCount() {
        return doubleCount;
    }

    public String toresultString(String name) {
        String result = "dice1=" + dice1 +
                "\ndice2=" + dice2;

        if (isDouble()) {result += "\n더블입니다.";}
        result += "\n" + name + "님의 주사위 값 : " + (dice1 + dice2);

        return  result;
    }

    public boolean isDouble() {
        return (dice1 == dice2);
    }
}
