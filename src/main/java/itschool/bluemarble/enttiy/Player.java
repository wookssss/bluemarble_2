package itschool.bluemarble.enttiy;

public class Player {

    private Dice dice = new Dice();

    public int rollDice() {
        return dice.roll();
    }
}
