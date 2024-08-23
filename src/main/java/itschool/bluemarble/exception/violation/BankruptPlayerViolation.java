package itschool.bluemarble.exception.violation;

public class BankruptPlayerViolation extends RuntimeException {
    public BankruptPlayerViolation() {
        super("님이 파산하셨습니다.");
    }
}
