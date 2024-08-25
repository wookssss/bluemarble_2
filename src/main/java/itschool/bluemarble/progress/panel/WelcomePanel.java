package itschool.bluemarble.progress.panel;

import itschool.bluemarble.progress.GameByJFrame;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {
    GameByJFrame frame;

    // Component 구성요소
    JLabel $playerNameLabel;
    JTextField $playerNameField;

    public WelcomePanel(GameByJFrame frame) {
        frame.setTitle("초기 화면");
        this.frame = frame;

        this.setLayout(new GridLayout(3, 4));

        $playerNameLabel = new JLabel("이름(한글 2~4자)");

        $playerNameLabel.setVerticalAlignment(SwingConstants.CENTER);
        $playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        $playerNameField = new JTextField();


        this.add($playerNameLabel);
        this.add($playerNameField);
    }
}
