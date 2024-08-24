package itschool.bluemarble.exception.event;

public class LoanEvent extends RuntimeException {
    public LoanEvent(String playerName) {
        super(playerName + "님, 대출을 진행하시겠습니까?");
    }
}
