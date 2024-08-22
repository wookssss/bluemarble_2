package itschool.bluemarble;

import itschool.bluemarble.progress.GameByConsole;
import itschool.bluemarble.progress.abs.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 스캐너는 GameByConsole에서 만든 하나의 스캐너를 공유받는다.
        Scanner sc = GameByConsole.getScanner();

        // 플레이어 수
        int numberOfPlayer = 0;

        // 플레이어 수 입력받기
        while (true) {
            try {
                System.out.print("플레이어 수를 입력하세요 (2~4인) : ");
                numberOfPlayer = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기

                if (numberOfPlayer >= 2 && numberOfPlayer <= 4) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(numberOfPlayer + "인 플레이 가능한 게임을 생성합니다.");
                    break; // 유효한 입력이므로 루프 종료
                } else {
                    System.out.println("2~4만 입력이 가능합니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
                sc.nextLine(); // 잘못된 입력을 처리하고 버퍼 비우기
            }
        }

        // 게임 생성
        Game game = GameByConsole.createGameByConsole(numberOfPlayer);

        // 게임 시작
        game.start();
    }
}
