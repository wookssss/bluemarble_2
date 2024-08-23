package itschool.bluemarble.exception.violation;

public class PlayerHasNoMoneyViolation extends RuntimeException {
    public PlayerHasNoMoneyViolation() {
        super("플레이어가 보유한 돈이 부족합니다.");
    }
}
