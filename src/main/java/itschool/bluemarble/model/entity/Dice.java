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
    private int doubleCount = 0; // 더블의 횟수를 가지고 있는 변수

    private String[] doubleString = {"",
                                     "\n!!!!!!!!!!!!!! 더블 !!!!!!!!!!!!!!\n",
                                     "\n!!!!!!!!!! 엥.. 또 더블? !!!!!!!!!!\n",
                                     "\n!! 아이쿠야, 세 번째 더블은 무인도행... !!\n"};

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

    public boolean isDouble() {
        return (dice1 == dice2);
    }

    public String toString(Player player) {
        StringBuilder sb = new StringBuilder();

        sb.append(player.getName() + "님이 주사위를 굴렸습니다.\n");

        // double인 경우 축하 메시지
        sb.append(doubleString[doubleCount] + "\n");

        // 두 주사위를 나란히 배치하기 위한 문자열 배열
        String[] dice1Lines = getDiceFace(1, dice1).split("\n");
        String[] dice2Lines = getDiceFace(2, dice2).split("\n");;

        for (int i = 0; i < dice1Lines.length; i++) {
            sb.append(dice1Lines[i])  // 첫 번째 주사위의 한 줄
              .append("   ")          // 두 주사위 사이의 간격
              .append(dice2Lines[i])  // 두 번째 주사위의 한 줄
              .append("\n");          // 줄바꿈
        }

        sb.append("\n");
        sb.append(player.getName() + "님의 주사위 합산 결과 : " + (dice1 + dice2) + "\n\n");
        sb.append("============================================================================================\n");

        return sb.toString();
    }



    private static String getDiceFace(int order, int number) {
        String result;
        switch (number) {
            case 1:
                result = "주사위 " + order + " \n" +
                         "┌───────┐ \n" +
                         "│       │ \n" +
                         "│   *   │ \n" +
                         "│       │ \n" +
                         "└───────┘ ";
                break;
            case 2:
                result = "주사위 " + order + " \n" +
                         "┌───────┐ \n" +
                         "│   *   │ \n" +
                         "│       │ \n" +
                         "│   *   │ \n" +
                         "└───────┘ ";
                break;
            case 3:
                result = "주사위 " + order + " \n" +
                         "┌───────┐ \n" +
                         "│   *   │ \n" +
                         "│   *   │ \n" +
                         "│   *   │ \n" +
                         "└───────┘ ";
                break;
            case 4:
                result = "주사위 " + order + " \n" +
                         "┌───────┐ \n" +
                         "│  * *  │ \n" +
                         "│       │ \n" +
                         "│  * *  │ \n" +
                         "└───────┘ ";
                break;
            case 5:
                result = "주사위 " + order + " \n" +
                         "┌───────┐ \n" +
                         "│  * *  │ \n" +
                         "│   *   │ \n" +
                         "│  * *  │ \n" +
                         "└───────┘ ";
                break;
            case 6:
                result = "주사위 " + order + " \n" +
                         "┌───────┐ \n" +
                         "│  * *  │ \n" +
                         "│  * *  │ \n" +
                         "│  * *  │ \n" +
                         "└───────┘ ";
                break;
            default:
                result = "유효하지 않은 숫자";
                break;
        }
        return result;
    }
}