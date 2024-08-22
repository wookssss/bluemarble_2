// 담당자 : 오재헌
// 주사위 2개 (결과값 2~12)
//

package itschool.bluemarble.entity;

import lombok.Getter;
import java.util.Random;

@Getter
public class Dice {
    private int dice1; // 주사위1
    private int dice2; // 주사위2
    private static int doubleCount = 0; // 더블의 횟수를 가지고 있는 변수

    public int roll() { // 주사위 2개를 굴린다. 2 ~ 12
        dice1 = 1 + new Random().nextInt(6);
        dice2 = 1 + new Random().nextInt(6);

        System.out.println("dice1: " + dice1);
        System.out.println("dice2: " + dice2);

        if (isDouble()) {
                System.out.println("더블! 한번더!");
                doubleCount++;
        }else { //
            doubleCount = 0;
        }

        return dice1 + dice2;
    }

    public boolean isDouble() {
        return (dice1 == dice2);
    }
}
