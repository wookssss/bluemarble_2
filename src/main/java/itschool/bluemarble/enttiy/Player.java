package itschool.bluemarble.enttiy;

public class Player {
    private String name;
    // 현재 위치 : 타일 번호 0 ~ 39
    private int curPos = 0;
    private Dice dice = new Dice();

    public int rollDice() {
        return dice.roll();
    }

    // 절대적인 타일번호
    public void moveByAbsoluteValue(int abs) {
        curPos = abs;
    }

    // 상대적으로 변화값
    public void moveByRelativeValue(int rel) {
        curPos += rel;

        if(curPos > 39) {
            curPos -= 39;
        }
    }
}
