package itschool.bluemarble.progress.abs;

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
    // final protected static List TILES = TileFactory.getTiles(); // Tiles에 getTiles 메소드 필요
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
            for (Player player : PLAYERS) {

                String flag = "Y";

                int location = player.getCurPos(); // ;
                System.out.println(turn+"번째 턴입니다. "+ player/*.getName()*/+"님 주사위를 굴리시겠습니까? (Y/n)");

                String input = sc.nextLine();
                // sc.reset();

                int rollValue = 0;

                if ("y".equals(input) || "Y".equals(input) || "".equals(input)) {
                    /*rollValue = player.rollDice();
                    location += rollValue;*/
                }

                if(location > 39) {
                    /*location = location - 40;*/
                }

                // player.setCurPos(location);

                showMapByConsole();

                System.out.println(player/*.getName()*/ + "님의 주사위 값 : " + rollValue);

                /*if (player.getBudget() < 0) {
                    System.out.println(player.getName() + "님이 패배하셨습니다.");
                    PLAYERS.remove(player);
                }*/

                turn++;
            }
            // 라운드 개념을 추가할 수도 있음
            if(PLAYERS.size() == 1) break;
        }
        System.out.println(PLAYERS/*.get(0).getName()*/ + "님이 승리하셨습니다. 게임을 종료합니다.");

        // PLAYERS.get(0).setWinCount(PLAYERS.get(0).getWinCount()+1);
    }
}
