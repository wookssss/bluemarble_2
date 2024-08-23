package itschool.bluemarble.exception.violation;

public class PlayerHasNoLandViolation extends RuntimeException {
    public PlayerHasNoLandViolation() {
        super("님이 땅을 가지고 있지 않습니다.");
    }
}
