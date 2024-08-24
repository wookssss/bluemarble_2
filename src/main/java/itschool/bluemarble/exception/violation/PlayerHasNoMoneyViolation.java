package itschool.bluemarble.exception.violation;

public class PlayerHasNoMoneyViolation extends RuntimeException {
    public PlayerHasNoMoneyViolation(String playerName) {
        super(playerName + "이/가 보유한 돈이 부족합니다.");
    }
}
