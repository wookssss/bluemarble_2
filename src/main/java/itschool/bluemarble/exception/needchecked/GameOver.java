package itschool.bluemarble.exception.needchecked;

// 검사 예외 : throws나 try, catch가 강제됨
public class GameOver extends Exception {
    String winner;

    public GameOver(String winner) {
        super(winner + "님이 게임을 우승하셨습니다.\n게임을 종료합니다.");
    }
}
