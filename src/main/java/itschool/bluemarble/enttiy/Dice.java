package itschool.bluemarble.enttiy;

import java.util.Random;

public class Dice {
    int dice1;
    int dice2;

    public int roll() { // 주사위 2개를 굴린다. 2 ~ 12
        dice1 = 1 + new Random().nextInt(6);
        dice2 = 1 + new Random().nextInt(6);

        return dice1 + dice2;
    }

    public boolean isDouble() {
        return (dice1 == dice2);
    }
}
