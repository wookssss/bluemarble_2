package itschool.bluemarble.exception.violation;

public class BankruptPlayerViolation extends RuntimeException {
    public BankruptPlayerViolation(String playerName) {
        super(playerName + "님이 파산하셨습니다.");
    }
}
