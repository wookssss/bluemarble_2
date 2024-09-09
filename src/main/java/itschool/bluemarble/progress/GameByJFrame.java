package itschool.bluemarble.progress;

import itschool.bluemarble.exception.event.HoldableKeyEvent;
import itschool.bluemarble.exception.violation.PlayerHasNoMoneyViolation;
import itschool.bluemarble.model.entity.Dice;
import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.goldenKey.GoldenKey;
import itschool.bluemarble.model.entity.tile.abs.PurchasableTile;
import itschool.bluemarble.progress.ifs.GameInterface;
import itschool.bluemarble.progress.panel.WelcomePanel;

import javax.swing.*;
import java.util.ArrayList;

public class GameByJFrame extends JFrame implements GameInterface {

    ArrayList<String> playerNameList = new ArrayList<>();

    public GameByJFrame() {
        super("부루마블");
        this.add(new WelcomePanel(this));
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void changePanel(JPanel jPanel) {
        this.getContentPane().removeAll();
        this.add(jPanel);
        this.revalidate();
        this.repaint();
    }


    @Override
    public void showMap() {

    }

    @Override
    public void confirmToUseGoldenKey(Player player, GoldenKey goldenKey) throws HoldableKeyEvent {

    }

    @Override
    public void confirmToBuyPurchasableTile(Player player, PurchasableTile tile) throws PlayerHasNoMoneyViolation {

    }

    @Override
    public boolean confirm(String message) {
        return false;
    }

    @Override
    public void printOutDiceResult(Player player, Dice dice) {

    }

    @Override
    public void printOutOfDrawedGoldenKey(Player player, GoldenKey goldenKey) {

    }

    @Override
    public void printOutOfException(RuntimeException exception) {

    }

    @Override
    public void printOutOfPlayerInfo(Player player) {

    }

    @Override
    public void printOutOfMoving(Player player) {

    }

    @Override
    public void choiceTile(Player player){

    }

    @Override
    public void printOutOfIslandCount(Player player) {

    }
}
