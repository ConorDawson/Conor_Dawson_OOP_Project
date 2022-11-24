package Knock_31;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderBoard extends JFrame{
    private JPanel LeaderBoardPanel;
    private JScrollPane LeaderBoard;
    private JLabel LeaderBoardLabel;
    private JButton homeButton;

    public LeaderBoard(){
        setContentPane(LeaderBoardPanel);
        setSize(1500,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        LeaderBoardLabel.setText(Test.ResultSave + "\n");



        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainMenu();
            }
        });
    }

    public static void main(String[] args) {
        new LeaderBoard();
    }
}
