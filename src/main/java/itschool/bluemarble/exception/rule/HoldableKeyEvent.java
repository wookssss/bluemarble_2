package itschool.bluemarble.exception.rule;

public class HoldableKeyEvent extends RuntimeException {
    public HoldableKeyEvent(String title) {
        super("님, 황금열쇠"+ title + "을 사용하셨습니다.");
    }
}
