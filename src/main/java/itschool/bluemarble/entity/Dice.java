package itschool.bluemarble.entity;

import java.util.Random;

public class Dice {
    private int dice1; // 주사위1
    private int dice2; // 주사위2
    private static int diceResult = 0; // 주사위의 결과를 누적시키는 변수
    private static int doubleCount = 0; // 더블의 횟수를 가지고 있는 변수



    public int roll() { // 주사위 2개를 굴린다. 2 ~ 12
        if (doubleCount == 0) {
            diceResult = 0;} // 새로운 플레이어가 주사위를 굴릴경우 결과를 0으로 초기화후 주사위 굴리기
        dice1 = 1 + new Random().nextInt(6);
        dice2 = 1 + new Random().nextInt(6);
        diceResult = dice1 + dice2 + diceResult; // 이전에 더블이 있었을 경우 결과 값을 누적

        System.out.println("dice1: " + dice1);
        System.out.println("dice2: " + dice2);

        if (isDouble()) {
            if (doubleCount < 3) {
                System.out.println("더블! 한번더!");
                doubleCount++;
                return 0; // 더블이 나오면 0을 리턴
            }else{
                System.out.println("더블이 3회입니다. 무인도로 이동!");
                return 1; // 더블이 3회나올 경우 1을 리턴
            }
        }else { //
            doubleCount = 0;
        }

        return diceResult;
    }

    public boolean isDouble() {
        return (dice1 == dice2);
    }
}
