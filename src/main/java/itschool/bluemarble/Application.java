package itschool.bluemarble;

import itschool.bluemarble.progress.GameByConsole;
import itschool.bluemarble.progress.abs.Game;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfPlayer; // 기본값 2인

        do {
            System.out.print("플레이어 수를 입력하세요 : ");
            numberOfPlayer = sc.nextInt();
            // 플레이어 이름은 글자 수를 고정해야함.. 콘솔의 단점
        } while(numberOfPlayer >= 2 && numberOfPlayer <= 4);

        Game game = GameByConsole.createGame(numberOfPlayer);

        if(null != game) {
            game.start();
        }
    }
}
