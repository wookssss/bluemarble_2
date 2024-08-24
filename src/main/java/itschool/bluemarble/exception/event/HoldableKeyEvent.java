package itschool.bluemarble.exception.event;

public class HoldableKeyEvent extends RuntimeException {
    public HoldableKeyEvent(String goldenKeyTitle) {
        super("님이/가 황금열쇠"+ goldenKeyTitle + "을 사용하셨습니다.");
    }
}
