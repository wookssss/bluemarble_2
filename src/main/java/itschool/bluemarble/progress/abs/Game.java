package itschool.bluemarble.progress.abs;

import itschool.bluemarble.entity.Player;
import itschool.bluemarble.factory.TileFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 게임 안에는 매턴이 발생하며 (플레이어가) 매턴마다 순서에 따라 주사위를 굴린다.
public abstract class Game {
    protected final int NUMBER_OF_PLAYER;
    protected int turn = 0;
    // final protected static List TILES = TileFactory.getTiles(); // Tiles에 getTiles 메소드 필요
    final protected List<Player> PLAYERS = new ArrayList<Player>();

    protected Game(int numberOfPlayer) {
        this.NUMBER_OF_PLAYER = numberOfPlayer;
        for (int i = 0; i < numberOfPlayer; i++) {
            PLAYERS.add(new Player()); // name을 세팅할 생성자 필요
        }
    }

    public abstract void showMapByConsole();
}
