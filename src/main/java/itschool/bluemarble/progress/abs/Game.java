package itschool.bluemarble.progress.abs;

import itschool.bluemarble.entity.Dice;
import itschool.bluemarble.entity.Player;
import itschool.bluemarble.factory.TileFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 게임 룰을 담당하는 클래스
// 게임 안에는 매턴이 발생하며 (플레이어가) 매턴마다 순서에 따라 주사위를 굴린다.
public abstract class Game {
    protected final int NUMBER_OF_PLAYER;
    protected int turn = 0;
    final protected List TILES = TileFactory.getTiles(); // Tiles에 getTiles 메소드 필요
    final protected List<Player> PLAYERS = new ArrayList<Player>();

    protected Game(int numberOfPlayer) {
        this.NUMBER_OF_PLAYER = numberOfPlayer;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.print("사용자" + (i+1) + "의 이름을 입력해주세요(5글자)");
            String playerName = sc.next();

            do {
                PLAYERS.add(new Player(playerName)); // name을 세팅할 생성자 필요
            } while (playerName.length() != 5);
        }
    }

    public abstract void showMapByConsole();

    public void start() {

        Scanner sc = new Scanner(System.in);

        while(true) {

            Dice dice = new Dice();

            for (Player player : PLAYERS) {

                String flag = "Y";

                int location = player.getCurPos();
                System.out.println(turn+"번째 턴입니다. "+ player.getPlayerName() +"님 주사위를 굴리시겠습니까? (Y/n)");

                String input = sc.nextLine();
                sc.reset(); // 스캐너 초기화

                int rollValue = 0;

                if ("y".equals(input) || "Y".equals(input) || "".equals(input)) {
                    int rollCount = 0;

                    do {
                        rollValue = dice.roll();
                        rollCount++;

                        if(rollCount == 3 & dice.isDouble()) {
                            player.moveByAbsoluteValue(10); // 무인도(10) 타일로 이동
                            break;
                        }
                    } while(dice.isDouble());
                }

                showMapByConsole();

                System.out.println(player.getPlayerName() + "님의 주사위 값 : " + rollValue);

                if(player.getCurMoney() < 0) {
                    System.out.println(player.getCurMoney() + "님이 패배하셨습니다.");
                    PLAYERS.remove(player);
                }

                turn++;
            }
            
            if(PLAYERS.size() == 1) break;

            // 라운드 개념을 추가하려면 추가 또는 수정 바람
        }
        System.out.println(PLAYERS.get(0).getPlayerName() + "님이 승리하셨습니다. 게임을 종료합니다.");

        // PLAYERS.get(0).setWinCount(PLAYERS.get(0).getWinCount()+1); // 승리 횟수 저장은 제거
    }
}
