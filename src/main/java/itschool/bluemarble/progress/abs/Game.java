// 담당자 : 오재헌
// 부루마블 판이 나오고 주사위 결과 나오도록 수정

package itschool.bluemarble.progress.abs;

import itschool.bluemarble.exception.rule.HoldableKeyEvent;
import itschool.bluemarble.exception.violation.BankruptPlayerViolation;
import itschool.bluemarble.exception.needchecked.GameOver;
import itschool.bluemarble.exception.violation.PlayerHasNoLandViolation;
import itschool.bluemarble.model.entity.Dice;
import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.goldenKey.GoldenKeyTile;
import itschool.bluemarble.model.entity.tile.Island;
import itschool.bluemarble.model.entity.tile.SpecialVehicle;
import itschool.bluemarble.model.entity.tile.Tile;
import itschool.bluemarble.model.entity.tile.abs.PurchasableTile;
import itschool.bluemarble.model.factory.TileFactory;
import itschool.bluemarble.model.entity.goldenKey.GoldenKey;
import itschool.bluemarble.model.entity.goldenKey.ifs.InstantFunction;
import itschool.bluemarble.progress.GameByConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 게임 룰을 담당하는 클래스
// 게임 안에는 매턴이 발생하며 (플레이어가) 매턴마다 순서에 따라 주사위를 굴린다.
public abstract class Game {
    final protected Scanner sc = GameByConsole.getScanner();
    final protected int NUMBER_OF_PLAYER;
    final protected List TILES = TileFactory.getTiles(); // Tiles에 getTiles 메소드 필요
    final protected List<Player> PLAYERS = new ArrayList<Player>();
    protected int turn = 1;

    protected Game(int numberOfPlayer) {
        this.NUMBER_OF_PLAYER = numberOfPlayer;
    }

    abstract public void showMapPhase();

    abstract public void wantToUseGoldenKey(Player player, GoldenKey goldenKey) throws HoldableKeyEvent;

    abstract public boolean checkYesOrNo(String message);

    abstract public void showDiceResult(Player player, int dice1, int dice2, boolean isDouble);

    abstract public void println(String message);

    abstract public void print(String message);

    public void start() throws GameOver {
        while (true) {
            for (Player player : PLAYERS) {
                try {
                    startPhase(player);
                    turn++;
                } catch (BankruptPlayerViolation e) {
                    println(player.getName() + e.getMessage()); // "님이 파산하셨습니다."
                    PLAYERS.remove(player);
                }

                if (PLAYERS.size() == 1) throw new GameOver(PLAYERS.get(0).getName());
                // 라운드 개념을 추가하려면 추가 또는 수정 바람
            }
        }
        // PLAYERS.get(0).setWinCount(PLAYERS.get(0).getWinCount()+1); // 승리 횟수 저장은 제거
    }

    public void startPhase(Player player) throws RuntimeException {
        if (checkTurnPhase(player)) { // 턴 수행 여부 확인
            int diceValue = rollDicePhase(player);

            int locationIdx = movePhase(player, diceValue);

            showMapPhase(); // 이 페이즈의 위치가 적절한가?

            // 도착한 타일에 대한 수행 페이즈(황금열쇠, 도시, 특수 도시)
            arriveTilePhase(player, locationIdx);
        }
    }

    public boolean checkTurnPhase(Player player) {
        return checkYesOrNo(turn + "번째 턴입니다. " + player.getName() + "님 주사위를 굴리시겠습니까? (Y)");
    }

    public int rollDicePhase(Player player) {
        Dice dice = new Dice();

        int rollValue;

        do {
            rollValue = dice.roll(player, this);
        } while (dice.isDouble());

        if (dice.getDoubleCount() == 3 & dice.isDouble()) {
            player.moveByAbsoluteValue(10); // 무인도(10) 타일로 이동
        }

        return rollValue;
    }


    public int movePhase(Player player, int rel) {
        return player.moveByRelativeValue(rel);
    }

    public void arriveTilePhase(Player player, int index) throws RuntimeException {

        Tile currentTile = (Tile) TILES.get(index);

        // 도착한 타일이 무엇인지 확인
        if (currentTile instanceof GoldenKeyTile) { // 황금열쇠 타일 도착
            GoldenKey goldenKey = null;

            goldenKey = player.drawGoldenKey((GoldenKeyTile) currentTile);

            if (goldenKey.getFunction() instanceof InstantFunction) {// 인스턴트 평션을 뽑았구나
                try {
                    ((InstantFunction) goldenKey.getFunction()).execute(player);
                } catch (PlayerHasNoLandViolation e) {
                    println("----------------------------------------------------------------");
                    println("반액대매출을 실행했습니다.");
                    println(player.getName() + e.getMessage()); // "님이 땅을 가지고 있지 않습니다."
                    println("----------------------------------------------------------------");
                }

            } // 홀더블 펑션을 뽑았으면 아무것도 수행하지 않는다.
            println("----------------------------------------------------------------");
            println("황금 열쇠를 뽑습니다.");
            println(player.getName() + "님이 황금열쇠 " + goldenKey.getTitle());
            println("----------------------------------------------------------------");
        } else if (currentTile instanceof PurchasableTile) { // 건물 지을 수 있는 도시 도착
            boolean shouldPay = ((PurchasableTile) currentTile).shouldPay(player);
            if (shouldPay) { // 통행료를 내야하는 상황
                try {
                    // 우대권을 찾아야됨
                    wantToUseGoldenKey(player, player.findTollFreePassKey());
                } catch (HoldableKeyEvent e) {
                    println(e.getMessage()); // 황금열쇠를 사용했음
                } catch (RuntimeException e) {
                    println(e.getMessage()); // 해당 황금열쇠가 존재하지 않음
                }
            }
        } else if (currentTile instanceof Island) { // 무인도 도착

        } else if (currentTile instanceof SpecialVehicle) {

        }

        // 도착한 타일 구입 페이즈
    }
}
