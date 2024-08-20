package itschool.bluemarble.enttiy;

// 게임 안에는 매턴이 발생하며 (플레이어가) 매턴마다 순서에 따라 주사위를 굴린다.
public class Game {
    private int turn = 0;
    private final int numberOfPlayer;

    private Game(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    private static Game createGame(int numberOfPlayer) {
        if(numberOfPlayer >= 2 && numberOfPlayer <= 4) {
            return new Game(numberOfPlayer);
        }
        return null;
    }
}
