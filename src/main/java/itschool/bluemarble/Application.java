package itschool.bluemarble;

import itschool.bluemarble.progress.GameByConsole;
import itschool.bluemarble.progress.abs.Game;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = GameByConsole.getScanner();

        int numberOfPlayer; // 기본값 2인

        do {
            System.out.print("플레이어 수를 입력하세요 (2 ~ 4인) : ");
            numberOfPlayer = sc.nextInt();
            // 플레이어 이름은 글자 수를 고정해야함.. 콘솔의 단점
        } while(numberOfPlayer < 2 || numberOfPlayer > 4);

        Game game = GameByConsole.createGameByConsole(numberOfPlayer);

        game.start();

    }
}
