package itschool.bluemarble.enttiy;

import java.util.Random;

public class Dice {
    public int roll() { // 주사위 2개를 굴린다. 2 ~ 12
        return 2 + new Random().nextInt(11);
    }
}
