// 담당자 : 오재헌
// 부루마블 판이 나오고 주사위 결과 나오도록 수정

package itschool.bluemarble.progress.abs;

import itschool.bluemarble.entity.Dice;
import itschool.bluemarble.entity.Player;
import itschool.bluemarble.factory.GoldenKeyTile;
import itschool.bluemarble.factory.TileFactory;
import itschool.bluemarble.goldenKey.GoldenKey;
import itschool.bluemarble.goldenKey.ifs.InstantFunction;
import itschool.bluemarble.progress.GameByConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 게임 룰을 담당하는 클래스
// 게임 안에는 매턴이 발생하며 (플레이어가) 매턴마다 순서에 따라 주사위를 굴린다.
public abstract class Game {
    protected final int NUMBER_OF_PLAYER;
    protected int turn = 1;
    final protected List TILES = TileFactory.getTiles(); // Tiles에 getTiles 메소드 필요
    final protected List<Player> PLAYERS = new ArrayList<Player>();
    final protected GoldenKeyTile goldenKeyTile = GoldenKeyTile.getInstance();

    protected Game(int numberOfPlayer) {
        this.NUMBER_OF_PLAYER = numberOfPlayer;
    }

    public abstract void showMapByConsole();

    public void start() {

        Scanner sc = GameByConsole.getScanner();
        sc.nextLine();

        while (true) {

            Dice dice = new Dice();

            for (Player player : PLAYERS) {
                do {
                    String flag = "Y";

                    int location = player.getCurPos();
                    System.out.println(turn + "번째 턴입니다. " + player.getPlayerName() + "님 주사위를 굴리시겠습니까? (Y)");

                    String input = sc.nextLine();
                    sc.reset(); // 스캐너 초기화

                    int rollValue = 0;

                    if ("y".equals(input) || "Y".equals(input) || "".equals(input)) {
                        rollValue = dice.roll();

                        int index = player.moveByRelativeValue(rollValue);

                        showMapByConsole();
                        System.out.println(dice.toresultString(player.getPlayerName()));

                        if (TILES.get(index) instanceof GoldenKeyTile) {
                            GoldenKey goldenKey = player.drawGoldenKey(goldenKeyTile);
                            if (goldenKey.getFunction() instanceof InstantFunction) {// 인스턴트 평션을 뽑았구나
                                ((InstantFunction) goldenKey.getFunction()).execute(player);
                            } // 폴더블 펑션을 뽑았으면 아무것도 수행하지 않는다.
                            System.out.println("----------------------------------------------------------------");
                            System.out.println("황금 열쇠를 뽑습니다.");
                            System.out.println(player.getPlayerName() + "님이 황금열쇠 " + goldenKey.getTitle());
                            System.out.println("----------------------------------------------------------------");
                        }

                        if (dice.getDoubleCount() == 3 & dice.isDouble()) {
                            player.moveByAbsoluteValue(10); // 무인도(10) 타일로 이동
                            break;
                        }
                    }

                    if (player.getCurMoney() < 0) {
                        System.out.println(player.getCurMoney() + "님이 패배하셨습니다.");
                        PLAYERS.remove(player);
                    }

                } while (dice.isDouble());
                turn++;
            }

            if (PLAYERS.size() == 1) break;

            // 라운드 개념을 추가하려면 추가 또는 수정 바람
        }
        System.out.println(PLAYERS.get(0).getPlayerName() + "님이 승리하셨습니다. 게임을 종료합니다.");

        // PLAYERS.get(0).setWinCount(PLAYERS.get(0).getWinCount()+1); // 승리 횟수 저장은 제거
    }
}
